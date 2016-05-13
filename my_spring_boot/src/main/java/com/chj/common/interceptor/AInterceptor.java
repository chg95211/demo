package com.chj.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.chj.common.utils.UrlPathUtil;

public class AInterceptor extends HandlerInterceptorAdapter {

	protected Log log = LogFactory.getLog(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info(this.getClass().getName() +  " --- : " +  UrlPathUtil.getServletPath(request) + " 被拦截!");
		return super.preHandle(request, response, handler);
	}

}
