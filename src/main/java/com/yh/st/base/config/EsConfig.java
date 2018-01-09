package com.yh.st.base.config;

import java.net.InetAddress;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hungnguyen on 12/16/14.
 */
//@Configuration
public class EsConfig {

	@Value("${elasticsearch.host}")
	private String EsHost;

	@Value("${elasticsearch.port}")
	private int EsPort;

	@Value("${elasticsearch.clustername}")
	private String EsClusterName;

	@Bean
	public TransportClient init() {
		TransportClient transportClient = null;
		try {
			// 配置信息
			Settings esSetting = Settings.builder().put("cluster.name", EsClusterName).build();
			transportClient = new PreBuiltTransportClient(esSetting);
			InetSocketTransportAddress inetSocketTransportAddress = new InetSocketTransportAddress(
					InetAddress.getByName(EsHost), Integer.valueOf(EsPort));
			transportClient.addTransportAddresses(inetSocketTransportAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return transportClient;
	}

}