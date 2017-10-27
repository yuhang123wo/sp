package com.yh.st.base.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
// 保证在MyBatisConfig实例化之后再实例化该类
public class MapperScannerConfig {

	// mapper接口的扫描器
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		System.out.println(22);
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.yh.st.base.mapper");
		return mapperScannerConfigurer;
	}

}
