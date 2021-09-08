package com.example.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * [解决springboot 项目配置文件指定端口号没生效](https://blog.csdn.net/u010695169/article/details/105247079)
	 * @return
	 */
//	@Bean
//	public TomcatServletWebServerFactory servletContainer(){
//		return new TomcatServletWebServerFactory(9081) ;
//	}
}
