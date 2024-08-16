package dev.nathanlively;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class ServiceConfig {
    @Bean
    public ClockEventService clockEventService(EclipseClockRepository eclipseClockRepository) {
        ClockRepository clockEclipseAdapter = new ClockEclipseAdapter(eclipseClockRepository);
        return new ClockEventService(clockEclipseAdapter, Clock.systemDefaultZone());
    }
}
