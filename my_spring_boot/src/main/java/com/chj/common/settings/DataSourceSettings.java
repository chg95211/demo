package com.chj.common.settings;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "datasource")
public class DataSourceSettings {
	private static DataSourceSettings SETTINGS;

	private String type;
	private String driver;
	private String url;
	private String username;
	private String signword;

	@PostConstruct
	private void init() {
		SETTINGS = this;
	}

	public static DataSourceSettings instance() {
		return SETTINGS;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSignword() {
		return signword;
	}

	public void setSignword(String signword) {
		this.signword = signword;
	}

}
