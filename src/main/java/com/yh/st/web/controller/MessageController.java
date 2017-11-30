package com.yh.st.web.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.st.common.PushSocket;

@Controller
@RequestMapping("message")
public class MessageController {

	@Resource
	private PushSocket warningPushSocket;

	@RequestMapping("send")
	@ResponseBody
	public void send() throws IOException {
		warningPushSocket.sendMessage("messassd");
	}
}
