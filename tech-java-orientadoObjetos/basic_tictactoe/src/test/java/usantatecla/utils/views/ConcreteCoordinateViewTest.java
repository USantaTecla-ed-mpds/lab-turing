package usantatecla.utils.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.models.ConcreteCoordinate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConcreteCoordinateViewTest {

  @Mock
  private Console console;

  @Test
  public void testGivenEmptyCoordinatesWhenReadThenCorrectValues() {
    try (MockedStatic<Console> console = mockStatic(Console.class)) {
      console.when(Console::getInstance).thenReturn(this.console);

      final ConcreteCoordinate[] coordinates = {  new ConcreteCoordinate(1, 2), new ConcreteCoordinate(0, 3) };
      for(int i = 0; i < coordinates.length; i++) {
        when(this.console.readInt(anyString())).thenReturn(coordinates[i].getRow() + 1, coordinates[i].getColumn() + 1);
        ConcreteCoordinateView coordinate = new ConcreteCoordinateView();

        assertThat(coordinate.read("TITLE"), is(coordinates[i]));
      }
    }
  }

}
