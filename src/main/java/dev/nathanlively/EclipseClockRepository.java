package dev.nathanlively;

import org.springframework.data.repository.ListCrudRepository;

public interface EclipseClockRepository extends ListCrudRepository<ClockEvent, Long> {
}
