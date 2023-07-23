package com.almacen.grupozara.AppZara.utility;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.almacen.grupozara.AppZara.config.AppConfig;

import jakarta.persistence.spi.PersistenceProvider;
import jakarta.persistence.spi.PersistenceProviderResolver;
import jakarta.persistence.spi.PersistenceProviderResolverHolder;

public abstract class JPAUtility {

	private static final EntityManagerFactory emFactory;
	
	private static EntityManager manager = null;
	
	 private static final Environment env = null;
	 

	static {

		PersistenceProviderResolverHolder
				.setPersistenceProviderResolver((PersistenceProviderResolver) new PersistenceProviderResolver() {

					public List<PersistenceProvider> getPersistenceProviders() {
						return Collections.singletonList(new HibernatePersistenceProvider());
					}

					public void clearCachedProviders() {
					}
				});
		
			  Map<String, Object> properties = new HashMap<String, Object>();
			  properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
			  properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		
		     emFactory = Persistence.createEntityManagerFactory("unidadPersistencia");
		     manager = emFactory.createEntityManager();
	}

	public JPAUtility() {

	}

	public static EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}

	public static void close() {
		emFactory.close();
	}

}
