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

import com.chj.common.settings.BFilterSettings;
import com.chj.common.utils.UrlPathUtil;

@Component
public class BFilter extends BaseFilter {
	
	private BFilterSettings bFilterSettings;

	public BFilterSettings getbFilterSettings() {
		return bFilterSettings;
	}

	@Autowired
	public void setbFilterSettings(BFilterSettings bFilterSettings) {
		this.filterProperties = this.bFilterSettings = bFilterSettings;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		if (match(request, response)) {
			log.info(bFilterSettings.getOrder() +  " --- BFilter : " +  UrlPathUtil.getServletPath(request) + " 被拦截!");
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public int getOrder() {
		return bFilterSettings.getOrder();
	}
	
	@Bean(name="bFilterRegistration")
	@ConditionalOnClass(name="javax.servlet.DispatcherType")
	public FilterRegistrationBean inactiveRegister() {
		return super.inactiveRegister();
	}

}
