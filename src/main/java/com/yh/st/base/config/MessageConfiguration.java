package com.yh.st.base.config;

import java.text.SimpleDateFormat;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON
 * 
 * @author yh
 * @Date 2017年11月1日
 * @desc <!-- 将Jackson2HttpMessageConverter的默认格式化输出设为true -->
 */
@Configuration
public class MessageConfiguration {
	@Bean
	@ConditionalOnMissingBean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jsonView = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		jsonView.setObjectMapper(objectMapper);
		jsonView.setPrettyPrint(true);
		return jsonView;
	}
}
