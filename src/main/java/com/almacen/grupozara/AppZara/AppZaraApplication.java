package com.almacen.grupozara.AppZara;



import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration(exclude = { 
		DataSourceAutoConfiguration.class, 
        DataSourceTransactionManagerAutoConfiguration.class ,
		HibernateJpaAutoConfiguration.class })
@EntityScan(basePackages = { "com.almacen.grupozara.AppZara.models.*" })
@ComponentScan(basePackages={"com.almacen.grupozara.AppZara.controllers.*","com.almacen.grupozara.AppZara.services.*","com.almacen.grupozara.AppZara.repository.*"})
@EnableTransactionManagement
@SpringBootApplication
public class AppZaraApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppZaraApplication.class, args);
		Persistence.generateSchema("unidadPersistencia",null);
	}


}




