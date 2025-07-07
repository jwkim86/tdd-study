package com.koreaap.itdev2.common.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@Transactional
public class HibernateConfigTest {

  @Autowired private DataSource dataSource;

  @Autowired private EntityManagerFactory entityManagerFactory;

  @Test
  void contextLoads() {
    assertNotNull(dataSource, "DataSource should not be null");
    assertNotNull(entityManagerFactory, "EntityManagerFactory should not be null");
  }

  @Test
  void shouldCreateEntityManager() {
    var entityManager = entityManagerFactory.createEntityManager();
    assertNotNull(entityManager, "EntityManager should not be null");
    entityManager.close();
  }
}
