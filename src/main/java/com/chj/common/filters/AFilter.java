package com.chj.common.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.chj.common.settings.AFilterSettings;
import com.chj.common.utils.UrlPathUtil;

@Component
public class AFilter extends BaseFilter {

	private AFilterSettings aFilterSettings;

	public AFilterSettings getaFilterSettings() {
		return aFilterSettings;
	}

	@Autowired
	public void setaFilterSettings(AFilterSettings aFilterSettings) {
		this.filterProperties = this.aFilterSettings = aFilterSettings;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		if(match(request, response)){
			log.info(aFilterSettings.getOrder() +  " --- AFilter : " +  UrlPathUtil.getServletPath(request) + " 被拦截!");
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public int getOrder() {
		return aFilterSettings.getOrder();
	}
	

	@Bean(name="aFilterRegistration")
	@ConditionalOnClass(name="javax.servlet.DispatcherType")
	public FilterRegistrationBean inactiveRegister() {
		return super.inactiveRegister();
	}
	
	

}
