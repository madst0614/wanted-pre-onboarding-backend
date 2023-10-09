package com.onboarding.recruit.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Log4j2
public class DataSourceTests {

	@Setter(onMethod_ = { @Autowired })
	private DataSource dataSource;

	@Test
	public void testConnection() {
		try (Connection con = dataSource.getConnection()) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
