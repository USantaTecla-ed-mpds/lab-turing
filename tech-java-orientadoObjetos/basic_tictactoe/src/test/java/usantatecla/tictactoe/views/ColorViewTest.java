package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.types.Color;
import usantatecla.utils.views.Console;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ColorViewTest {

    @Mock
    private Console console;

    private ColorView colorView;

    @BeforeEach
    public void beforeEach() {
        this.colorView = new ColorView();
    }

    @Test
    public void testGivenColorWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.colorView.write(Color.X);
            this.colorView.write(Color.O);
            this.colorView.write(Color.NULL);
            verify(this.console).write("X");
            verify(this.console).write("O");
            verify(this.console).write(" ");
        }
    }

}
