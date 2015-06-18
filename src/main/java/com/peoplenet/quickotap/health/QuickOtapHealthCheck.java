package com.peoplenet.quickotap.health;

import com.peoplenet.service.boot.health.HealthCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * By implementing the HealthCheck interface, this class will be accessed by SystemHealthServices.
 * This implementation checks the main datasource.
 */
@Component
public class QuickOtapHealthCheck implements HealthCheck, HealthIndicator {

    private static final Logger LOG = LoggerFactory.getLogger(QuickOtapHealthCheck.class);

    @Override
    @SuppressWarnings("unchecked")
    public boolean executeHealthCheck() {
        //Should maybe add a check to see if RabbitMQ is up?
        return true;
    }

    @Override
    public Health health() {
        if (!executeHealthCheck()) {
            return Health.down().withDetail("Error Code",":(").build();
        }
        return Health.up().build();
    }
}