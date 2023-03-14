package usantatecla.utils.views;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ColorCodeTest {

    @Mock
    private Console console;

    private ColorCode colorCode;

    @BeforeEach
    public void beforeEach() {
        this.colorCode = ColorCode.BLUE;
    }

    @Test
    public void testGivenColorCodeWhenCallGetColorThenReturnCorrectStringColor() {
        assertThat(this.colorCode.get(), is("\u001B[34m"));
    }

    @Test
    public void testGivenNullColorCodeWhenCallGetColorThenAssertError() {
        Assertions.assertThrows(AssertionError.class, () -> ColorCode.NULL.get());
    }

    @Test
    public void testGivenIndexWhenCallGetColorByIndexThenReturnCorrectStringColor() {
        assertThat(ColorCode.get(0), is("\u001B[30m"));
    }

    @Test
    public void testGivenOutOfBoundsIndexWhenCallGetColorByIndexThenAssertionError() {
        Assertions.assertThrows(AssertionError.class, () -> ColorCode.get(-1));
        Assertions.assertThrows(AssertionError.class, () -> ColorCode.get(ColorCode.NULL.ordinal()));
    }

    @Test
    public void testGivenColorCodeWhenGetInitialThenReturn() {
        assertThat(this.colorCode.getInitial(), is('b'));
    }

    @Test
    public void testGivenNotNullColorCodeWhenIsNullThenFalse() {
        assertThat(this.colorCode.isNull(), is(false));
    }

    @Test
    public void testGivenNullColorCodeWhenIsNullThenTrue() {
        assertThat(ColorCode.NULL.isNull(), is(true));
    }

    @Test
    public void testGivenColorCodeWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.colorCode.write();
            verify(this.console).write(this.colorCode.get() + this.colorCode.getInitial() + ColorCode.RESET_COLOR.get());
        }
    }

    @Test
    public void testGivenNullColorCodeWhenWriteThenZeroInteractions() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            ColorCode.NULL.write();
            verifyNoInteractions(this.console);
        }
    }
    
}
