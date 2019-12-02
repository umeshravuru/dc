package com.drchrono.dc.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class PostgresCloudConfig {

  @Value("${spring.datasource.drivername}")
  private String driverClassName;
  @Value("${spring.datasource.password}")
  private String encryptedPassword;
  @Value("${spring.datasource.testOnBorrow:true}")
  private String testOnBorrow;
  @Value("$spring.datasource.testOnReturn:true}")
  private String testOnReturn;
  @Value("${spring.datasource.testWhileIdle:true}")
  private String testWhileIdle;
  @Value("${spring.datasource.url}")
  private String url;
  @Value("${spring.datasource.username}")
  private String username;
  @Value("${spring.datasource.validationQuery:select 1}")
  private String validationQuery;

  public JdbcTemplate jdbcTemplatePostgres (@Qualifier("dspostgres") DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean(name = "dspostgres")
  public DataSource primaryDataSource () {

    DataSource dataSource = new DataSource();

    dataSource.setDriverClassName(driverClassName);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(encryptedPassword);
    dataSource.setValidationQuery(validationQuery);
    dataSource.setInitialSize(2);
    dataSource.setMaxIdle(3);
    dataSource.setMinIdle(1);
    return dataSource;
  }
}
