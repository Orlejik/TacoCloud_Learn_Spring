package com.art.demo4.HealthIndicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health() {
        try{
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return Health.up().withDetail("message", "Database is available").build();
        }catch (Exception ex){
            return Health.down().withDetail("error", "Database is unavailable : "+ ex.getMessage()).build();
        }
    }
}
