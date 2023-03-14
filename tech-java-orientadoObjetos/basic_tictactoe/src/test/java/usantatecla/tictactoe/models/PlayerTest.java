package usantatecla.tictactoe.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

public class PlayerTest {

    private final Color COLOR = Color.O;
    private PlayerBuilder playerBuilder;

    @BeforeEach
    public void BeforeEach() {
        this.playerBuilder = new PlayerBuilder().color(this.COLOR);
    }

    @Test
    public void testGivenPlayerWhenAreAllTokensOnBoardThenTrue() {
        Player player = this.playerBuilder.rows(
                "OO ",
                "   ",
                " O "
        ).build();
        assertThat(player.areAllTokensOnBoard(), is(true));
    }

    @Test
    public void testGivenPlayerWhenAreAllTokensOnBoardThenFalse() {
        Player player = this.playerBuilder.build();
        assertThat(player.areAllTokensOnBoard(), is(false));
    }

    @Test
    public void testGivenNewPlayerWhenAreAllTokensOnBoardThenReturnTrue() {
        Player player = this.playerBuilder.rows(
                "OO ",
                "O  ",
                "   "
        ).build();
        assertThat(player.areAllTokensOnBoard(), is(true));
    }

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorNULL() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = this.playerBuilder.build();
        assertThat(player.getPutTokenError(coordinate), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorNotEmpty() {
        Player player = this.playerBuilder.rows(
                "   ",
                " O ",
                "   "
        ).build();
        assertThat(player.getPutTokenError(new Coordinate(1, 1)), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenPlayerWhenGetOriginMoveTokenErrorThenErrorNotOwner() {
        Player player = this.playerBuilder.rows(
                "   ",
                " X ",
                "   "
        ).build();
        assertThat(player.getOriginMoveTokenError(new Coordinate(1, 1)), is(Error.NOT_OWNER));
    }

    @Test
    public void testGivenNewPlayerWhenGetOriginMoveTokenErrorThenReturnErrorNull() {
        Player player = this.playerBuilder.rows(
                "OO ",
                "O  ",
                "   "
        ).build();
        assertThat(player.getOriginMoveTokenError(new Coordinate(0, 1)), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenNoError() {
        Player player = this.playerBuilder.rows(
                "   ",
                " O ",
                "   "
        ).build();
        assertThat(player.getTargetMoveTokenError(new Coordinate(1, 1), new Coordinate(0, 0)), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorNotEmpty() {
        Player player = this.playerBuilder.rows(
                "   ",
                " OO",
                "   "
        ).build();
        assertThat(player.getTargetMoveTokenError(new Coordinate(1, 1), new Coordinate(1, 2)), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorSameCoordinates() {
        Player player = this.playerBuilder.rows(
                "   ",
                " O ",
                "   "
        ).build();
        assertThat(player.getTargetMoveTokenError(new Coordinate(1, 1), new Coordinate(1, 1)), is(Error.SAME_COORDINATES));
    }

    @Test
    public void testGivenNewPlayerWhenGetColorThenReturnTheColor() {
        Player player = this.playerBuilder.build();
        assertThat(player.getColor(), is(Color.O));
    }

}
