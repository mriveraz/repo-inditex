package com.almacen.grupozara.AppZara;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({"/shema.sql","/data.sql"})
class AppZaraApplicationTests {

	@Test
	void contextLoads() {
	}

}

