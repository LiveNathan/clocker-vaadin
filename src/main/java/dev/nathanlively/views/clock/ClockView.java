package dev.nathanlively.views.clock;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("clock")
@Route(value = "")
@RouteAlias(value = "")
@Uses(Icon.class)
public class ClockView extends Composite<VerticalLayout> {

    public ClockView() {
        HorizontalLayout mainRow = new HorizontalLayout();
        VerticalLayout column1 = new VerticalLayout();
        VerticalLayout column2 = new VerticalLayout();

        Button buttonPrimary = new Button();
        Button buttonSecondary = new Button();
        UnorderedList evnetsList = new UnorderedList();

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        mainRow.addClassName(Gap.MEDIUM);
        mainRow.setWidth("100%");
        mainRow.getStyle().set("flex-grow", "1");
        column1.getStyle().set("flex-grow", "1");
        column1.getStyle().set("flex-grow", "1");
        column1.setJustifyContentMode(JustifyContentMode.CENTER);
        column1.setAlignItems(Alignment.CENTER);
        buttonPrimary.setText("Clock In");
        column1.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSecondary.setText("Clock Out");
        column1.setAlignSelf(FlexComponent.Alignment.CENTER, buttonSecondary);
        buttonSecondary.setWidth("min-content");
        column2.getStyle().set("flex-grow", "1");
        column2.getStyle().set("flex-grow", "1");
        evnetsList.setWidth("100%");
        evnetsList.setHeight("100%");
//        setUnoGridSampleData(basicGrid);
        getContent().add(mainRow);
        mainRow.add(column1);
        column1.add(buttonPrimary);
        column1.add(buttonSecondary);
        mainRow.add(column2);
        column2.add(evnetsList);
    }

    private void setGridSampleData(Grid grid) {
//        grid.setItems(query -> samplePersonService.list(
//                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
//                .stream());
    }

//    @Autowired()
//    private SamplePersonService samplePersonService;
}
