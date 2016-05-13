package com.chj.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class TestLdapConfig {
	@Value("${ldap.test.url}")
	private String url;
	@Value("${ldap.test.username}")
	private String userDn;
	@Value("${ldap.test.authpwd}")
	private String password;
	private static TestLdapConfig LDAP_SETTINGS;

	@PostConstruct
	private void init() {
		LDAP_SETTINGS = this;
	}

	public static TestLdapConfig instance() {
		return LDAP_SETTINGS;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserDn() {
		return userDn;
	}

	public void setUserDn(String userDn) {
		this.userDn = userDn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Bean(name = { "test_ldap" })
	public LdapTemplate ldapTemplate() throws Exception {
		LdapContextSource dsscs = new LdapContextSource();
		dsscs.setUrl(getUrl());
		dsscs.setUserDn(getUserDn());
		dsscs.setPassword(getPassword());
		// dsscs.setBase(getUserBase());
		dsscs.afterPropertiesSet();
		LdapTemplate lt = new LdapTemplate();
		lt.setContextSource(dsscs);
		return lt;
	}
}
