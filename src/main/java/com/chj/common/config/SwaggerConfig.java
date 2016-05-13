package com.chj.common.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	static Log log = LogFactory.getLog(SwaggerConfig.class);

	@Bean
	public Docket demoApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("demo").genericModelSubstitutes(DeferredResult.class)
		// .genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false).forCodeGeneration(false).pathMapping("/").select()
				//.paths(or(regex("/demo/.*")))// 过滤的接口
				.build().apiInfo(demoApiInfo());
	}

	private ApiInfo demoApiInfo() {
		ApiInfo apiInfo = new ApiInfo("Electronic Health Record(EHR) Platform API",// 大标题
				"EHR Platform's REST API, for system administrator",// 小标题
				"1.0",// 版本
				"NO terms of service", "[email protected]",// 作者
				"The Apache License, Version 2.0",// 链接显示文字
				"http://www.apache.org/licenses/LICENSE-2.0.html"// 网站链接
		);
		return apiInfo;
	}
}
