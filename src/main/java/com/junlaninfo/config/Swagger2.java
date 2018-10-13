package com.junlaninfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 *在springboot中使用 Swagger2  
 * Swagger的配置类
 */
@Configuration      //这是一个配置类
@EnableSwagger2    //开启Swagger2的注解
public class Swagger2 {
	
	@Bean
	public Docket     createSwaggerApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);   //选择Swagger_2的风格返回
	    docket.apiInfo(apiinfo())         //选择ApiInfo
	          .select()
	          .apis(RequestHandlerSelectors.basePackage("com.junlaninfo.controller"))   //给出controller层packeage的位置
		      .paths(PathSelectors.any())
		      .build();
	    return docket;
	}
	
	/*
	 * 返回一个ApiInfo 给Docket
	 * 步骤：
	 *    先创建一个ApiInfoBuilder，利用其设置一些参数
	 *    通过ApiInfoBuilder.build(),返回一个ApiInfo
	 *    
	 */
	public ApiInfo apiinfo() {
		//创建一个ApiInfoBuilder
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		apiInfoBuilder.title("springboot 利用Swagger2构建api文档");
		apiInfoBuilder.description("springboot和jpa整合的各个端口");
		apiInfoBuilder.termsOfServiceUrl("http://baidu.com");
		apiInfoBuilder.version("1.0");
		ApiInfo apiInfo = apiInfoBuilder.build();
		return apiInfo;
	}

}
