package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.types.Error;
import usantatecla.utils.views.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ErrorViewTest {

    @Mock
    private Console console;

    private ErrorView errorView;

    @BeforeEach
    public void beforeEach() {
        this.errorView = new ErrorView();
    }

    @Test
    public void testGivenCorrectErrorWhenWritelnThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln(Error.NOT_OWNER);
            verify(this.console).writeln("There is not a token of yours");
        }
    }

    @Test
    public void testGivenNullErrorWhenWritelnThenConsoleIsNotCalled() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln(Error.NULL);
            verify(this.console, never()).writeln(anyString());
        }
    }

}
