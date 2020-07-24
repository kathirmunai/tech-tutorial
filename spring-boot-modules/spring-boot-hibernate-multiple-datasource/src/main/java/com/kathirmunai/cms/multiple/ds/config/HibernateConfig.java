package com.kathirmunai.cms.multiple.ds.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class HibernateConfig {
	
	@Value("${ds1.url}")
	String ds1Url;
	
	@Value("${ds1.user}")
	String ds1User;
	
	@Value("${ds1.pass}")
	String ds1Pass;

	@Value("${ds2.url}")
	String ds2Url;
	
	@Value("${ds2.user}")
	String ds2User;
	
	@Value("${ds2.pass}")
	String ds2Pass;

	@Primary
	@Bean
	public LocalSessionFactoryBean ds1SessionFactoryBean() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(ds1DataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public LocalSessionFactoryBean ds2SessionFactoryBean() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(ds2DataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Primary
	@Bean
	public DataSource ds1DataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl(ds1Url);
		dataSource.setUsername(ds1User);
		dataSource.setPassword(ds1Pass);
		return dataSource;
	}

	@Bean
	public DataSource ds2DataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl(ds2Url);
		dataSource.setUsername(ds2User);
		dataSource.setPassword(ds2Pass);
		return dataSource;
	}

	@Primary
	@Bean
	public PlatformTransactionManager ds1HibernateTransactionManager() {
		HibernateTransactionManager transactionManager
		= new HibernateTransactionManager();
		transactionManager.setSessionFactory(ds1SessionFactoryBean().getObject());
		return transactionManager;
	}

	@Bean
	public PlatformTransactionManager ds2HibernateTransactionManager() {
		HibernateTransactionManager transactionManager
		= new HibernateTransactionManager();
		transactionManager.setSessionFactory(ds2SessionFactoryBean().getObject());
		return transactionManager;
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty(
				org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
		hibernateProperties.setProperty(
				org.hibernate.cfg.Environment.SHOW_SQL, "true");
		hibernateProperties.setProperty(
				org.hibernate.cfg.Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		hibernateProperties.setProperty(
				org.hibernate.cfg.Environment.HBM2DDL_AUTO, "none");

		return hibernateProperties;
	}
}