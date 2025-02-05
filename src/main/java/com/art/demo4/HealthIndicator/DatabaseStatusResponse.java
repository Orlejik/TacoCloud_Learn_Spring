package com.art.demo4.HealthIndicator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatabaseStatusResponse {
    private boolean isDatabaseUp;
    private String message;

    public DatabaseStatusResponse(boolean isDatabaseUp, String message) {
        this.isDatabaseUp = isDatabaseUp;
        this.message = message;
    }

    public boolean isIsDatabaseUp() {
        return isDatabaseUp;
    }
    public String getMessage(){
        return message;
    }
}
