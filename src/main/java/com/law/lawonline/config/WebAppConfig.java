package com.law.lawonline.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

import static org.hibernate.cfg.Environment.*;

@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
@PropertySource({"classpath:db-cfg.properties", "classpath:application.properties"})
@ComponentScan({"com.law.lawonline.error", "com.law.lawonline.service",
        "com.law.lawonline.dao", "com.law.lawonline.elasticsearch.service",
        "com.law.lawonline.elasticsearch.repository"})
public class WebAppConfig {

    @Autowired
    private Environment env;

    ////////// Register beans of DataSource and JdbcTemplate. //////////
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        Properties props = new Properties();
        // Setting JDBC properties
        props.put(DRIVER, env.getProperty("mysql.driverClassName"));
        props.put(URL, env.getProperty("mysql.url"));
        props.put(USER, env.getProperty("mysql.username"));
        props.put(PASS, env.getProperty("mysql.password"));

        // Setting Hibernate properties
        props.put(DIALECT, env.getProperty("hibernate.dialect"));
        props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        props.put(FORMAT_SQL, env.getProperty("hibernate.format_sql"));
        props.put(USE_SQL_COMMENTS, env.getProperty("hibernate.use_sql_comments"));

        // Setting C3P0 properties
        props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
        props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
        props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
        props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
        props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));

        dataSource.setConnectionProperties(props);

        System.out.println(String.format("### DataSource {%s} ### already registered...", dataSource.getClass().getName()));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
    ////////// END //////////

    @Autowired
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager tx = new DataSourceTransactionManager(dataSource);
        return tx;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}