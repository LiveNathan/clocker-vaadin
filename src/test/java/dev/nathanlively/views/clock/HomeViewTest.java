package dev.nathanlively.views.clock;

import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import dev.nathanlively.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.mvysny.kaributesting.v10.LocatorJ._get;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("ui")
class HomeViewTest extends KaribuTest {

    private HomeView view;
    private static final Logger log = LoggerFactory.getLogger(HomeViewTest.class);
    private ClockRepository repository;
    private ClockEvent clockInEvent;

    @BeforeEach
    public void login() {
        repository = InMemoryClockRepository.createEmpty();
        clockInEvent = new ClockEvent(ClockService.aug7at8am(), ClockEventType.IN);
        ClockEventService clockEventService = new ClockEventService(repository, ClockService.fixedAtAug7at8am());
        view = new HomeView(clockEventService);
    }

    @Test
    public void getRequestToIndex_returnsView() {
        assertThat(view).isNotNull();
    }

    @Test
    void viewIndex_returnsListOfClockEventViews() {
        repository.save(clockInEvent);
        assertThat(repository.findAll()).hasSize(1);
        UnorderedList eventList = _get(UnorderedList.class, spec -> spec.withId("events-list"));

        assertThat(eventList).isNotNull();


        List<ListItem> items = eventList.getChildren()
                .filter(component -> component instanceof ListItem)
                .map(component -> (ListItem) component)
                .collect(Collectors.toList());

        items.forEach(item -> log.info(item.getText()));

        assertThat(items).isNotEmpty();
    }
}