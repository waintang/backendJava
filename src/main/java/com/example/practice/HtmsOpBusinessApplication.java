package com.example.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类命名 建议以spring.application.name命名（虽然没强制校验）
 */
@SpringBootApplication
public class HtmsOpBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtmsOpBusinessApplication.class, args);
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
