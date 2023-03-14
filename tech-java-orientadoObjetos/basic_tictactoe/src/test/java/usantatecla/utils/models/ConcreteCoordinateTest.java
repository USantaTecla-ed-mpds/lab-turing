package usantatecla.utils.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class ConcreteCoordinateTest {

  private Coordinate coordinate;

  @BeforeEach
  public void beforeEach() {
    this.coordinate = new ConcreteCoordinate(1, 1);
  }

  @Test
  public void testGivenCoordinateWhenIsNullThenIsFalse() {
    assertThat(this.coordinate.isNull(), is(false));
  }

  @Test
  public void testGivenCoordinateWhenGetDirectionThenValue() {
    assertThat(this.coordinate.getDirection(new ConcreteCoordinate(1, 2)), is(Direction.HORIZONTAL));
    assertThat(this.coordinate.getDirection(new ConcreteCoordinate(2, 1)), is(Direction.VERTICAL));
    assertThat(this.coordinate.getDirection(new ConcreteCoordinate(0, 0)), is(Direction.MAIN_DIAGONAL));
    assertThat(this.coordinate.getDirection(new ConcreteCoordinate(0, 2)), is(Direction.NULL));
    assertThat(this.coordinate.getDirection(this.coordinate), is(Direction.NULL));
    assertThat(this.coordinate.getDirection(Coordinate.NULL), is(Direction.NULL));
  }

  @Test
  public void testGivenCoordinateWhenInHorizontalThenValue() {
    assertThat(this.coordinate.inHorizontal(new ConcreteCoordinate(1, 2)), is(true));
    assertThat(this.coordinate.inHorizontal(new ConcreteCoordinate(0, 0)), is(false));
    assertThat(this.coordinate.inHorizontal(Coordinate.NULL), is(false));
  }

  @Test
  public void testGivenCoordinateWhenInVerticalThenValue() {
    assertThat(this.coordinate.inVertical(new ConcreteCoordinate(1, 0)), is(false));
    assertThat(this.coordinate.inVertical(new ConcreteCoordinate(2, 1)), is(true));
    assertThat(this.coordinate.inVertical(Coordinate.NULL), is(false));
  }

  @Test
  public void testGivenCoordinateWhenInMainDiagonalThenFalse() {
    assertThat(this.coordinate.inMainDiagonal(), is(true));
    assertThat(new ConcreteCoordinate(2, 1).inMainDiagonal(), is(false));
  }

  @Test
  public void testGivenCoordinateWhenIsEqualsThenReturn() {
    assertThat(this.coordinate.equals(new ConcreteCoordinate(1, 1)), is(true));
    assertThat(this.coordinate.equals(new ConcreteCoordinate(0, 1)), is(false));
    assertThat(this.coordinate.equals(Coordinate.NULL), is(false));
  }

  @Test
  public void testGivenCoordinateWhenToStringThenReturn() {
    assertThat(this.coordinate.toString(), is("Coordinate (1, 1)"));
  }

}
