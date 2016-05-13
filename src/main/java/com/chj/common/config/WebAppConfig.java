package com.chj.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.chj.common.interceptor.AInterceptor;
import com.chj.common.settings.CommonSettings;

@Component
public class WebAppConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	private CommonSettings commonSettings;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AInterceptor()).addPathPatterns("/ccc/**");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(commonSettings.getPattern()).addResourceLocations(commonSettings.getLocation());
	}

}
