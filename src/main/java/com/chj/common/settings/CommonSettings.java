package com.chj.common.settings;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "common")
public class CommonSettings {

	private String[] pattern;
	private String[] location;

	private static CommonSettings SETTINGS;

	@PostConstruct
	private void init() {
		SETTINGS = this;
	}

	public String[] getPattern() {
		return pattern;
	}

	public void setPattern(String[] pattern) {
		this.pattern = pattern;
	}

	public String[] getLocation() {
		return location;
	}

	public void setLocation(String[] location) {
		this.location = location;
	}

	public static CommonSettings instance() {
		return SETTINGS;
	}

}
