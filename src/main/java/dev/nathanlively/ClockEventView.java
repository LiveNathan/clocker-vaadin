package dev.nathanlively;

public record ClockEventView(String timeStamp) {
    static ClockEventView from(ClockEvent event) {
        return new ClockEventView(event.time().toString() + " " + event.type().toString());
    }
}
