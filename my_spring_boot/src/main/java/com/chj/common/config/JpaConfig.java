package com.chj.common.config;

import javax.sql.DataSource;
import javax.sql.XADataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.chj.dao.MyRepositoryFactoryBean;

@Configuration
@EnableJpaRepositories(repositoryFactoryBeanClass = MyRepositoryFactoryBean.class, basePackages = { "com.chj.dao","com.chj.domain" })
@ConditionalOnMissingBean({ DataSource.class, XADataSource.class })
public class JpaConfig {

	private static Log log = LogFactory.getLog(JpaConfig.class);

	@Autowired
	private DataSourceProperties properties;

	@Bean
	public DataSource dataSource() {
		log.info("create jdbc datasource from JpaConfig.");
		DataSourceBuilder factory = DataSourceBuilder.create(this.properties.getClassLoader()).driverClassName(this.properties.getDriverClassName()).url(this.properties.getUrl()).username(this.properties.getUsername()).password(this.properties.getPassword());
		return factory.build();
	}

}
