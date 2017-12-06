package com.yh.st.base.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
public class MyBatisConfig {

	@Value("${gsb_config}")
	private String jdbcUrl;
	
	@Autowired
	private DataSource dataSource;

	@Bean
	@ConditionalOnMissingBean
	// 当容器里没有指定的Bean的情况下创建该对象
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
		System.out.println(jdbcUrl+":jdbcUrl");
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		// 设置数据源
		sqlSessionFactoryBean.setDataSource(dataSource);
		// 设置mybatis的主配置文件
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource mybatisConfigXml = resolver
				.getResource("classpath:mybatis/mybatis-config.xml");
		sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);
		// 设置别名包
		sqlSessionFactoryBean.setTypeAliasesPackage("com.yh.st.base.domain");
		sqlSessionFactoryBean.setMapperLocations(resolver
				.getResources("classpath*:mybatis/mappers/*Mapper.xml"));
		return sqlSessionFactoryBean;
	}

}
