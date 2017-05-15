package com.qingyi.SBJM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 主程序类
 *
 * @author qingyi xuelongqy@foxmail.com
 * @Title: Application类
 * @Description: 主程序类
 * @version: V1.0
 * @date 2017 -01-17 20:52:01
 */
@SpringBootApplication	//主程序注解(标识程序的入口)
@ServletComponentScan	//开启Servlet注解扫描
public class Application extends SpringBootServletInitializer{

	/**
	 * 应用的入口点,启动方法.
	 *
	 * @param args 启动参数
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * 配置方法(使用外部Tomcat时使用)
	 *
	 * @param builder the builder
	 * @return the spring application builder
	 * @Title: configure方法
	 * @Description: 配置方法
	 * @author qingyi xuelongqy@foxmail.com
	 * @date 2017 -01-17 20:53:50
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}
}
