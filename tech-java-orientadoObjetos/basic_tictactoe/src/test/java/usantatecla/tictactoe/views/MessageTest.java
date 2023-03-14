package usantatecla.tictactoe.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MessageTest {

    @Mock
    private Console console;

    @Test
    public void testGivenNewMessageWhenToStringThenReturn() {
        assertThat(Message.COORDINATE_TO_PUT.toString(), is("Coordinate to put"));
    }

    @Test
    public void testGivenNewMessageWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Message.COORDINATE_TO_PUT.write();
            verify(this.console).write("Coordinate to put");
        }
    }

    @Test
    public void testGivenNewMessageWhenWritelnThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Message.COORDINATE_TO_PUT.writeln();
            verify(this.console).writeln("Coordinate to put");
        }
    }

    @Test
    public void testGivenNewMessageWhenWritelnPlayerThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            String player = "X";
            Message.PLAYER_WIN.writeln(player);
            verify(this.console).writeln(player + " player: You win!!! :-)");
        }
    }
    
}
