package com.art.demo4.HealthIndicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseStatusIndicator implements HealthIndicator {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Health health() {
        try{
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return Health.up().withDetail("message", "Database is available").build();
        }catch(Exception e){
            return Health.down().withDetail("message", "Database unavailable"+e.getMessage()).build();
        }
    }
}
