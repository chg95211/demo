package com.chj.common.filters;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.core.Ordered;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.chj.common.FilterProperties;
import com.chj.common.utils.UrlPathUtil;

public abstract class BaseFilter extends OncePerRequestFilter implements Filter, Ordered {

	protected Log log = LogFactory.getLog(this.getClass());
	
	protected FilterProperties filterProperties;

	@Autowired
	PathMatcher pathMatcher;
	
	public FilterRegistrationBean inactiveRegister() {
		FilterRegistrationBean filter =	 new FilterRegistrationBean();
		filter.setFilter(this);
		filter.setName(this.getClass().getName()+"Register");
		filter.setEnabled(true);
		this.setBeanName(this.getClass().getName());
		return filter;
	}

	public boolean match(HttpServletRequest request, HttpServletResponse response) {
		String[] includePatterns = filterProperties.getIncludePattern();
		String[] excludePatterns = filterProperties.getExcludePattern();
		if (excludePatterns != null) {
			for (int i = 0; i < excludePatterns.length; i++) {
				boolean rs = pathMatcher.match(excludePatterns[i], UrlPathUtil.getServletPath(request));
				if (rs) {
					return !rs;
				}
			}
		}
		boolean rs = false;
		if (includePatterns != null) {
			for (int i = 0; i < includePatterns.length; i++) {
				rs = pathMatcher.match(includePatterns[i], UrlPathUtil.getServletPath(request));
				if (rs) {
					break;
				}
			}
		}
		return rs;
	}

}
