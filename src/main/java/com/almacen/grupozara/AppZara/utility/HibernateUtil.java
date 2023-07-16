package com.almacen.grupozara.AppZara.utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;

	static {

		if (sessionFactory == null) {

			try {

				Configuration configuration = new Configuration();

				Properties dbSettings = new Properties();
				dbSettings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Drive");
				dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/storeZaraDB?useSSL=false");
				dbSettings.put(Environment.USER, "root");
				dbSettings.put(Environment.PASS, "root");
				dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQ5LDialect");
				dbSettings.put(Environment.SHOW_SQL, "true");
				dbSettings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				dbSettings.put(Environment.HBM2DDL_AUTO, "create-auto");

				configuration.setProperties(dbSettings);
				configuration.addAnnotatedClass(com.almacen.grupozara.AppZara.models.Product.class);
				configuration.addAnnotatedClass(com.almacen.grupozara.AppZara.models.Price.class);
				configuration.addAnnotatedClass(com.almacen.grupozara.AppZara.models.Brand.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				// sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				// Create MetadataSource
				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
				// Create Metada
				Metadata metada = metadataSources.getMetadataBuilder().build();
				// Create SessionFactory
				sessionFactory = metada.getSessionFactoryBuilder().build();

			} catch (Exception e) {

				e.printStackTrace();
				if (standardServiceRegistry != null) {
					StandardServiceRegistryBuilder.destroy(standardServiceRegistry);

				}
			}

		}

	}

	// Utility method to return SessionFactory
	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}
}
