package usantatecla.utils.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ClosedIntervalTest {

    private ClosedInterval closedInterval;

    @BeforeEach
    public void beforeEach() {
        this.closedInterval = new ClosedInterval(-1, 1);
    }

    @Test
    public void testGivenClosedIntervalWhenIsIncludeThenOk() {
        assertThat(this.closedInterval.isIncluded(-1), is(true));
        assertThat(this.closedInterval.isIncluded(0), is(true));
        assertThat(this.closedInterval.isIncluded(1), is(true));
    }

    @Test
    public void testGivenClosedIntervalWhenIsIncludeThenNotOk() {
        assertThat(this.closedInterval.isIncluded(-666), is(false));
        assertThat(this.closedInterval.isIncluded(666), is(false));
    }

    @Test
    public void testGivenClosedIntervalWhenToStringThenOk() {
        assertThat(this.closedInterval.toString(), is("[-1, 1]"));
    }

}
