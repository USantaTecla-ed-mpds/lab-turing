package usantatecla.utils.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NullCoordinateTest {

    private ConcreteCoordinate concreteCoordinate;

    @BeforeEach
    public void beforeEach() {
        this.concreteCoordinate = new ConcreteCoordinate(1, 1);
    }

    @Test
    public void testGivenNullCoordinateWhenIsNullThenIsTrue() {
        assertThat(Coordinate.NULL.isNull(), is(true));
    }

    @Test
    public void testGivenNullCoordinateWhenGetDirectionThenNullDirection() {
        assertThat(Coordinate.NULL.getDirection(this.concreteCoordinate), is(Direction.NULL));
        assertThat(Coordinate.NULL.getDirection(Coordinate.NULL), is(Direction.NULL));
    }

    @Test
    public void testGivenNullCoordinateWhenInHorizontalThenFalse() {
        assertThat(Coordinate.NULL.inHorizontal(this.concreteCoordinate), is(false));
    }

    @Test
    public void testGivenNullCoordinateWhenInVerticalThenFalse() {
        assertThat(Coordinate.NULL.inVertical(this.concreteCoordinate), is(false));
    }

    @Test
    public void testGivenNullCoordinateWhenInMainDiagonalThenFalse() {
        assertThat(Coordinate.NULL.inMainDiagonal(), is(false));
    }

    @Test
    public void testGivenNullCoordinateWhenIsEqualsToAnotherCoordinateThenFalse() {
        assertThat(Coordinate.NULL.equals(this.concreteCoordinate), is(false));
    }

    @Test
    public void testGivenNullCoordinateWhenToStringThenValue() {
        assertThat(Coordinate.NULL.toString(), is("Coordinate (NULL)"));
    }
    
}
