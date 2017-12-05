package com.yh.st.common.util.jsoup;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * jsoup
 * 
 * @author yh
 * @Date 2017年12月5日
 * @desc
 */
public class JsoupUtil {

	private static String[] userAgents = {
			"Mozilla/5.0 (Windows NT 10.0; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0",
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50",
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Maxthon 2.0)",
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:2.0.1) Gecko/20100101 Firefox/4.0.1",
			"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0)" };

	/**
	 * @Description 将所有https的网站添加信任 爬取https网站时需要
	 */
	public static void addHttpsTrust() {
		try {
			HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			});

			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, new X509TrustManager[] { new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain, String authType)
						throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType)
						throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[0];
				}
			} }, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description 获取页面信息
	 * @param rule
	 *            请求规则
	 * @return 页面的document对象
	 * @throws Exception
	 */
	public static Document getDocumentByRule(JsoupRule rule) throws Exception {
		// 添加https信任
		if (rule.getUrl().startsWith("https://")) {
			addHttpsTrust();
		}
		// 获取连接
		Connection conn = Jsoup.connect(rule.getUrl());
		conn.userAgent("Mozilla/5.0 (Windows NT 6.1; rv:30.0) Gecko/20100101 Firefox/30.0");
		// 是否需要用代理
		// 设置查询参数
		if (rule.getParamNames() != null) {
			for (int i = 0; i < rule.getParamNames().length; i++) {
				conn.data(rule.getParamNames()[i], rule.getParamValues()[i]);
			}
		}
		// 根据请求类型获取返回数据
		Document doc = null;
		if (rule.getRequestMethod() == 0) {
			doc = conn.timeout(10000).get();
		} else if (rule.getRequestMethod() == 1) {
			doc = conn.timeout(10000).post();
		} else {
			throw new Exception("无效的请求类型");
		}
		return doc;
	}
}
