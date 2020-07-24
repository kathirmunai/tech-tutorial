package com.kathirmunai.cms.multiple.ds.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class MultipleDSDaoImpl implements IMultipleDSDao {

	private	static final String DS1_SYSDATE = "select curdate()";
	private static final String DS2_SYSDATE = "select curdate()";

	@Autowired
	@Qualifier(value="ds1SessionFactoryBean")
	private LocalSessionFactoryBean ds1SessionFactoryBean;

	@Autowired
	@Qualifier(value="ds2SessionFactoryBean")
	private LocalSessionFactoryBean ds2SessionFactoryBean;

	private SessionFactory getSessionFactory(LocalSessionFactoryBean sfBean){
		Configuration configuration = sfBean.getConfiguration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

	@Override
	public String getDs1Sysdate() {
		String value = null;

		SessionFactory ds1SessionFactory= getSessionFactory(ds1SessionFactoryBean);
		final Session session = ds1SessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query =session.createNativeQuery(DS1_SYSDATE);
		value = String.valueOf(query.getSingleResult());
		session.getTransaction().commit();
		session.close();
		return value;
	}

	@Override
	public String getDs2Sysdate() {
		String value = null;

		SessionFactory ds2SessionFactory= getSessionFactory(ds2SessionFactoryBean);
		final Session session = ds2SessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query =session.createNativeQuery(DS2_SYSDATE);
		value = String.valueOf(query.getSingleResult());
		session.getTransaction().commit();
		session.close();
		return value;
	}
}
