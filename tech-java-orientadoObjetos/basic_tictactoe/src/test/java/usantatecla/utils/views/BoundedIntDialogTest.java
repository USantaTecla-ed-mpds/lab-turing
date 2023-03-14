package usantatecla.utils.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.models.ClosedInterval;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BoundedIntDialogTest {

    private final int MIN = -1;
    private final int MAX = 1;
    private BoundedIntDialog boundedIntDialog;
    private ClosedInterval limits;
    private String title = "TITLE";

    @Mock
    private Console console;

    @BeforeEach
    public void beforeEach() {
        this.boundedIntDialog = new BoundedIntDialog(MIN, MAX);
        this.limits = new ClosedInterval(MIN, MAX);
    }

    @Test
    public void testGivenLimitedIntDialogWhenReadOutsideThenRepeat() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);

            when(this.console.readInt(title + "? " + this.limits + ": ")).thenReturn(MIN-1,MIN-1,MIN);
            assertThat(this.boundedIntDialog.read(title), is(MIN));

            when(this.console.readInt(title + "? " + this.limits + ": ")).thenReturn(MAX+1,MAX+1,MAX);
            assertThat(this.boundedIntDialog.read(title), is(MAX));

        }
    }

}
