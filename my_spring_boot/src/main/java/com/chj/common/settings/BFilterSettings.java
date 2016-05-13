package com.chj.common.settings;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.chj.common.FilterProperties;

@Configuration
@ConfigurationProperties(prefix = "filter.bbb")
public class BFilterSettings extends FilterProperties {
	private static BFilterSettings SETTINGS;

	@PostConstruct
	private void init() {
		SETTINGS = this;
	}

	public static BFilterSettings instance() {
		return SETTINGS;
	}

}
