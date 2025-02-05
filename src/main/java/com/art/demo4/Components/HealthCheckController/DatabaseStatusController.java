package com.art.demo4.Components.HealthCheckController;

import com.art.demo4.HealthIndicator.DatabaseStatusIndicator;
import com.art.demo4.HealthIndicator.DatabaseStatusResponse;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DatabaseStatusController {

    private final DatabaseStatusIndicator databaseStatus;

    @GetMapping("/db-status")
    public DatabaseStatusResponse getDBStatusResponse(){
        Health health = databaseStatus.health();
        boolean isDatabaseUp = health.getStatus().equals(Health.status("UP").build().getStatus());
        String message = isDatabaseUp ? "Up" : "Down";
        return new DatabaseStatusResponse(isDatabaseUp, message);
    }
}
