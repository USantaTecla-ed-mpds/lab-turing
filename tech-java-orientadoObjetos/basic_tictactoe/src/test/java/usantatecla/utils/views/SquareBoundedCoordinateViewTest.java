package usantatecla.utils.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.models.SquareBoundedCoordinate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SquareBoundedCoordinateViewTest {

    @Mock
    private Console console;

    private static final int DIMENSION = 7;
    private static final String ERROR = "error";

    public int getDimension() {
        return SquareBoundedCoordinateViewTest.DIMENSION;
    }

    public SquareBoundedCoordinateView getCoordinateView() {
        return new SquareBoundedCoordinateView() {

            @Override
            public SquareBoundedCoordinate createCoordinate(ConcreteCoordinate concreteCoordinate) {
                return new SquareBoundedCoordinate(concreteCoordinate) {
                    @Override
                    protected int getDimension() {
                        return SquareBoundedCoordinateViewTest.DIMENSION;
                    }
                };
            }

            @Override
            public String getErrorMessage() {
                return SquareBoundedCoordinateViewTest.ERROR;
            }

        };
    }

    @Test
    public void testGivenSquareBoundedCoordinateWhenReadThenCorrect() {
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(this.getDimension());
            SquareBoundedCoordinate coordinate = this.getCoordinateView().read("");

            assertThat(coordinate.getRow(), is(this.getDimension()-1));
            assertThat(coordinate.getColumn(), is(this.getDimension()-1));
        }
    }

    @Test
    public void testGivenSquareBoundedCoordinateWhenReadThenIncorrect() {
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(this.getDimension() + 1, this.getDimension());
            SquareBoundedCoordinateView coordinate = this.getCoordinateView();
            coordinate.read("");
            verify(this.console).writeln(coordinate.getErrorMessage());
        }
    }

}
