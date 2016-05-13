package com.chj.common.settings;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.chj.common.FilterProperties;

@Configuration
@ConfigurationProperties(prefix = "filter.aaa")
public class AFilterSettings extends FilterProperties {
	private static AFilterSettings SETTINGS;

	@PostConstruct
	private void init() {
		SETTINGS = this;
	}

	public static AFilterSettings instance() {
		return SETTINGS;
	}

}
