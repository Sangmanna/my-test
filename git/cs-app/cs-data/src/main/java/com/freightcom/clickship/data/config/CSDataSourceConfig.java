package com.freightcom.clickship.data.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "csAuditorAware")
@EnableJpaRepositories(
	    basePackages = "com.freightcom.clickship.data.rep", 
	    entityManagerFactoryRef = "csEntityManager", 
	    transactionManagerRef = "csTransactionManager"
	)
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class })
public class CSDataSourceConfig {
	
	@Value("${datasource.classname}")
	private String driverClassName;

	@Value("${cs.datasource.url}")
	private String url;

	@Value("${datasource.username}")
	private String username;

	@Value("${datasource.password}")
	private String password;

	@Value("${cs.datasource.jndi.url}")
	private String jndiURL;
	
	@Bean
	@Primary
	public DataSource csDataSource() {
		JndiTemplate jndiTemplate = new JndiTemplate();
		try {
			return (DataSource) jndiTemplate.lookup(jndiURL);
		} catch (NamingException e) {
			// For local environment
			final BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driverClassName);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			
			return dataSource;
		}
	}
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean csEntityManager() {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(csDataSource());
		em.setJpaProperties(additionalProperties());
		em.setPackagesToScan("com.freightcom.clickship.*.entity");
		
		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		return em;
	}

	@Bean
	public JpaTransactionManager csTransactionManager() throws SQLException, IllegalArgumentException, NamingException {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(csEntityManager().getObject());
		return txManager;
	}
	
	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

		return properties;
	}
}
