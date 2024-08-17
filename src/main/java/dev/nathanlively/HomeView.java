package dev.nathanlively;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@PageTitle("clock")
@Route(value = "")
@RouteAlias(value = "")
@Uses(Icon.class)
public class HomeView extends Composite<VerticalLayout> {

    private static final Logger log = LoggerFactory.getLogger(HomeView.class);

    private final ClockEventService service;

    private final Button clockInButton;
    private final Button clockOutButton;
    private final UnorderedList eventsList;

    public HomeView(ClockEventService service) {
        this.service = service;
        this.clockInButton = createClockInButton();
        this.clockOutButton = createClockOutButton();
        this.eventsList = createEventsList();

        setupLayout();
        addClockEvents();
        updateButtonVisibility();
    }

    private void setupLayout() {
        VerticalLayout content = getContent();
        content.setWidth("100%");
        content.getStyle().set("flex-grow", "1");

        HorizontalLayout mainRow = new HorizontalLayout();
        mainRow.addClassNames(Gap.MEDIUM, LumoUtility.Height.SCREEN);
        mainRow.setWidth("100%");
        mainRow.getStyle().set("flex-grow", "1");

        VerticalLayout column1 = new VerticalLayout();
        column1.getStyle().set("flex-grow", "1");
        column1.setJustifyContentMode(JustifyContentMode.CENTER);
        column1.setAlignItems(Alignment.CENTER);

        VerticalLayout column2 = new VerticalLayout();
        column2.getStyle().set("flex-grow", "1");

        column1.add(clockInButton, clockOutButton);
        column2.add(eventsList);

        mainRow.add(column1, column2);
        content.add(mainRow);
    }

    private Button createClockInButton() {
        Button button = new Button("Clock In!!!", event -> clockIn());
        button.setId("button-primary");
        button.setWidth("min-content");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        return button;
    }

    private Button createClockOutButton() {
        Button button = new Button("Clock Out", event -> clockOut());
        button.setId("button-secondary");
        button.setWidth("min-content");
        return button;
    }

    private UnorderedList createEventsList() {
        UnorderedList list = new UnorderedList();
        list.setId("events-list");
        list.setWidth("100%");
        list.setHeight("100%");
        return list;
    }

    private void clockIn() {
        ClockEventView clockEventView = service.clockIn();
        eventsList.addComponentAsFirst(new ListItem(clockEventView.timeStamp()));
        updateButtonVisibility();
    }

    private void clockOut() {
        ClockEventView clockEventView = service.clockOut();
        eventsList.addComponentAsFirst(new ListItem(clockEventView.timeStamp()));
        updateButtonVisibility();
    }

    void addClockEvents() {
        List<ClockEventView> allClockEvents = service.all();
        allClockEvents.forEach(clockEvent -> {
            log.info("Adding event: {}", clockEvent);
            eventsList.add(new ListItem(clockEvent.timeStamp()));
        });
    }

    private void updateButtonVisibility() {
        ClockEventType lastEventType = service.getLastClockEventType();
        boolean isClockedIn = lastEventType == ClockEventType.IN;
        clockInButton.setVisible(!isClockedIn);
        clockOutButton.setVisible(isClockedIn);
    }
}
