package dev.nathanlively.views.clock;

import com.vaadin.flow.component.UI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.github.mvysny.kaributesting.v10.LocatorJ._get;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("mvc")
class ClockMvcTest extends KaribuTest {

    @BeforeEach
    public void login() {
        UI.getCurrent().getPage().reload();
        UI.getCurrent().navigate(ClockView.class);
    }

    @Test
    public void getRequestToIndex() throws Exception {
        ClockView view = _get(ClockView.class);

        assertThat(view).isNotNull();
    }
}