package com.chj.common;

import java.io.Serializable;
import java.util.Arrays;

public abstract class FilterProperties implements Serializable{

	protected boolean enable;
	protected int order;
	protected String[] includePattern;
	protected String[] excludePattern;

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String[] getIncludePattern() {
		return includePattern;
	}

	public void setIncludePattern(String[] includePattern) {
		this.includePattern = includePattern;
	}

	public String[] getExcludePattern() {
		return excludePattern;
	}

	public void setExcludePattern(String[] excludePattern) {
		this.excludePattern = excludePattern;
	}

	@Override
	public String toString() {
		return "FilterProperties [enable=" + enable + ", order=" + order + ", includePattern=" + Arrays.toString(includePattern) + ", excludePattern=" + Arrays.toString(excludePattern) + "]";
	}

}
