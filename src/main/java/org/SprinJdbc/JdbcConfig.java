package org.SprinJdbc;

import org.SprinJdbc.dao.StudentDao;
import org.SprinJdbc.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
//CompanentScan is used for get the classs which you want to use with this configuration
@ComponentScan(basePackages = {"org.SprinJdbc.dao"})
public class JdbcConfig {
    @Bean("ds")
    public DataSource getDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost: 3306/springJdbc");
        ds.setUsername("anmol");
        ds.setPassword("Rivigo@123");
        return ds;
    }
    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
}
