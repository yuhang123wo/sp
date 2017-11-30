package com.yh.st.base.config.WebSocket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.alibaba.fastjson.JSON;
import com.yh.st.base.service.NoticeService;
import com.yh.st.base.vo.MessageVo;
import com.yh.st.common.util.StringUtil;

public class CmdHandler extends TextWebSocketHandler {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	// / 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;
	// concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
	private static CopyOnWriteArraySet<WebSocketSession> wsClientMap = new CopyOnWriteArraySet<>();

	@Resource
	private NoticeService noticeService;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		wsClientMap.add(session);
		addOnlineCount();
		logger.info(session.getId() + "有新链接加入，当前链接数为：" + wsClientMap.size());
		super.afterConnectionEstablished(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
			throws Exception {
		wsClientMap.remove(session);
		subOnlineCount();
		logger.info("有一链接关闭，当前链接数为：" + wsClientMap.size());
		super.afterConnectionClosed(session, status);
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {
		logger.info("message received: {}", message.getPayload());
		try {
			sendMsgToAll(message);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void sendMsgToAll(TextMessage message) throws IOException {
		String msg = message.getPayload();
		if (StringUtil.isNull(msg)) {
			return;
		}
		// 先保存信息
		MessageVo vo = JSON.parseObject(msg, MessageVo.class);
		noticeService.addAllUserNotice(vo.getUserId(), vo.getMessage(), vo.getTitle());
		TextMessage text = new TextMessage(vo.getMessage());
		for (WebSocketSession item : wsClientMap) {
			item.sendMessage(text);
		}
		logger.info("成功群送一条消息:" + wsClientMap.size());
	}

	public static synchronized int getOnlineCount() {
		return CmdHandler.onlineCount;
	}

	public static synchronized void addOnlineCount() {
		CmdHandler.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		CmdHandler.onlineCount--;
	}
}