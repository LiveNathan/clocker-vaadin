package dev.nathanlively.views.clock;

import com.vaadin.testbench.unit.UIUnitTest;
import com.vaadin.testbench.unit.ViewPackages;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@ViewPackages(classes = {ClockView.class})
@Tag("mvc")
class ClockMvcTest extends UIUnitTest {

    @Test
    public void getRequestToIndex() throws Exception {
        ClockView view = navigate(ClockView.class);

        assertThat(view).isNotNull();
    }
}