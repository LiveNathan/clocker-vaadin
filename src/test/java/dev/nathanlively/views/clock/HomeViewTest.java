package dev.nathanlively.views.clock;

import com.vaadin.flow.component.UI;
import dev.nathanlively.HomeView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.github.mvysny.kaributesting.v10.LocatorJ._get;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("ui")
class HomeViewTest extends KaribuTest {

    private HomeView view;

    @BeforeEach
    public void login() {
        UI.getCurrent().navigate(HomeView.class);
        view = _get(HomeView.class);
    }

    @Test
    public void getRequestToIndex_returnsView() {
        assertThat(view).isNotNull();
    }

    @Test
    void viewIndex_returnsListOfClockEventViews() {
        // Arrange: Mock the ClockEventService to return a list of ClockEvent views
//        List<ClockEvent> mockEvents = List.of(
//                new ClockEvent(LocalDateTime.now(), ClockEventType.IN),
//                new ClockEvent(LocalDateTime.now(), ClockEventType.OUT)
//        );

        // Act: Initialize the View and check if the list is injected correctly.
//        HomeView homeView = new HomeView(clockEventService);
//        UnorderedList eventsList = homeView.getContent().getComponentAt(0, UnorderedList.class);

        // Assert: Check if the list contains the expected items
//        assertThat(eventsList.getComponentCount()).isEqualTo(mockEvents.size());
    }
}