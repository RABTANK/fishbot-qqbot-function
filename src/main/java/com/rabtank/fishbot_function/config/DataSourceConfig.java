package com.rabtank.fishbot_function.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "fishingDataSourceProperties")
    @ConfigurationProperties("spring.datasource.fishing")
    public DataSourceProperties fishingDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "fishingDataSource")
    public DataSource fishingDataSource(@Qualifier("fishingDataSourceProperties") DataSourceProperties fishingDataSourceProperties) {
        return fishingDataSourceProperties.initializeDataSourceBuilder().type(DriverManagerDataSource.class).build();
    }

    @Bean(name = "fishingJdbcTemplate")
    public JdbcTemplate fishingJdbcTemplate(@Qualifier("fishingDataSource") DataSource fishingDataSource) {
        return new JdbcTemplate(fishingDataSource);
    }

    @Bean(name = "userDataSourceProperties")
    @ConfigurationProperties("spring.datasource.user")
    public DataSourceProperties userDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "userDataSource")
    public DataSource userDataSource(@Qualifier("userDataSourceProperties") DataSourceProperties userDataSourceProperties) {
        return userDataSourceProperties.initializeDataSourceBuilder().type(DriverManagerDataSource.class).build();
    }

    @Bean(name = "userJdbcTemplate")
    public JdbcTemplate userJdbcTemplate(@Qualifier("userDataSource") DataSource userDataSource) {
        return new JdbcTemplate(userDataSource);
    }
}