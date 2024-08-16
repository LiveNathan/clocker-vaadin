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
    private final Button buttonPrimary;
    private final Button buttonSecondary;
    private final UnorderedList eventsList;

    public HomeView(ClockEventService service) {
        this.service = service;
        HorizontalLayout mainRow = new HorizontalLayout();
        VerticalLayout column1 = new VerticalLayout();
        VerticalLayout column2 = new VerticalLayout();

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        mainRow.addClassName(Gap.MEDIUM);
        mainRow.setWidth("100%");
        mainRow.getStyle().set("flex-grow", "1");

        column1.getStyle().set("flex-grow", "1");
        column1.setJustifyContentMode(JustifyContentMode.CENTER);
        column1.setAlignItems(Alignment.CENTER);

        buttonPrimary = new Button("Clock In", event -> clockIn());
        buttonSecondary = new Button("Clock Out", event -> clockOut());
        eventsList = new UnorderedList();

        buttonPrimary.setId("button-primary");
        buttonSecondary.setId("button-secondary");
        eventsList.setId("events-list");

        buttonPrimary.setWidth("min-content");
        buttonSecondary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        column2.getStyle().set("flex-grow", "1");
        eventsList.setWidth("100%");
        eventsList.setHeight("100%");
        addClockEvents();
        updateButtonVisibility();

        getContent().add(mainRow);
        mainRow.add(column1);
        column1.add(buttonPrimary);
        column1.add(buttonSecondary);
        mainRow.add(column2);
        column2.add(eventsList);
    }

    private void clockIn() {
        ClockEventView clockEventView = service.clockIn();
        eventsList.addComponentAsFirst(new ListItem(clockEventView.toString()));
        updateButtonVisibility();
    }

    private void clockOut() {
        ClockEventView clockEventView = service.clockOut();
        eventsList.addComponentAsFirst(new ListItem(clockEventView.toString()));
        updateButtonVisibility();
    }

    void addClockEvents() {
        List<ClockEventView> allClockEvents = service.all();
        for (ClockEventView clockEvent : allClockEvents) {
            log.info("Adding event: {}", clockEvent);
            eventsList.add(new ListItem(clockEvent.toString()));
        }
    }

    private void updateButtonVisibility() {
        ClockEventType lastEventType = service.getLastClockEventType();
        if (lastEventType == ClockEventType.IN) {
            buttonPrimary.setVisible(false);
            buttonSecondary.setVisible(true);
        } else {
            buttonPrimary.setVisible(true);
            buttonSecondary.setVisible(false);
        }
    }

}
