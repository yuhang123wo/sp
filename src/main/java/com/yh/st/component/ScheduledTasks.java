package com.yh.st.component;

import java.util.Date;

import javax.annotation.Resource;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yh.st.base.domain.News;
import com.yh.st.base.service.NewsService;
import com.yh.st.common.util.DateUtils;
import com.yh.st.common.util.jsoup.JsoupRule;
import com.yh.st.common.util.jsoup.JsoupUtil;

/**
 * 任务相关
 * 
 * @author yh
 * @Date 2017年12月5日
 * @desc
 */
@Component
public class ScheduledTasks {

	@Resource
	private NewsService newsService;
	Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	@Scheduled(cron = "0 0 7 * * ?")
	public void newsGrabbing() {
		logger.error("newsGrabbing start++++");
		try {
			news();
		} catch (Exception e) {
			logger.error("newsGrabbing", e);
		}
		logger.error("newsGrabbing end++++");
	}

	private String url = "https://www.oschina.net/news";

	private void news() throws Exception {
		JsoupRule rule = new JsoupRule();
		rule.setUrl(url);
		rule.setRequestMethod(1);
		Document doc = JsoupUtil.getDocumentByRule(rule);
		Elements items = doc.select("#all-news .item");
		String host = "https://www.oschina.net";
		for (Element item : items) {
			// 过滤广告
			if (!item.attr("data-tracepid").isEmpty()) {
				continue;
			}
			// 标题
			String title = item.select("a").first().text();

			// 标题地址
			String title_href = item.select("a").first().attr("href");
			if (!title_href.startsWith("https://")) {
				title_href = host + title_href;
			}
			// 描述
			String desc = item.select("div[class=sc sc-text text-gradient wrap summary]").text();

			// 作者头像
			String author_image = item.select("img[class=avatar]").attr("src");
			// String author_image = item.select("img").first().attr("src");

			Element mr = item.select(".from .mr").get(0);
			// 作者
			String author = mr.select("a").text();
			// 从span[class=mr]中移除a标签，输出的即为发布时间
			mr.select("a").remove();
			String published = mr.text();
			if (!compareTime(published)) {
				break;
			}
			News news = new News();
			news.setTitle(title);
			news.setUrl(title_href);
			news.setType(1);
			newsService.addNews(news);
		}

	}

	private boolean compareTime(String published) {
		String time = published.replaceAll("发布于", "").trim();
		Date newsTime = DateUtils.parseDatePattern(time, DateUtils.PATTERN_1);
		if (newsTime.after(DateUtils.getLasDay(new Date(), -1))) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		ScheduledTasks task = new ScheduledTasks();
		task.news();
	}
}
