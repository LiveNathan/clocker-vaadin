package dev.nathanlively;

import java.util.List;

public interface ClockRepository {
    void save(ClockEvent clockEvent);

    List<ClockEvent> findAll();

    ClockEventType findLast();
}
