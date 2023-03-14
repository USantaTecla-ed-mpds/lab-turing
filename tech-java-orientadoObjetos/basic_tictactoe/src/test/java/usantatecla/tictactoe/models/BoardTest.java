package usantatecla.tictactoe.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    private BoardBuilder boardBuilder;

    @BeforeEach
    public void beforeEach() {
        this.boardBuilder = new BoardBuilder();
    }

    @Test
    public void testGivenEmptyBoardWhenStartThenIsEmpty() {
        Board board = this.boardBuilder.build();
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                assertThat(board.isEmpty(new Coordinate(i, j)), is(true));
            }
        }
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenThenIsOccupiedIsTrue() {
        Board board = this.boardBuilder.build();
        Color color = Color.O;
        Coordinate coordinate = new Coordinate(0, 0);
        board.putToken(coordinate, color);
        assertThat(board.isOccupied(coordinate, color), is(true));
    }

    @Test
    public void testGivenBoardWhenMoveXTokenOriginIsEmptyAndTargetIsOccupiedThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "X  ",
                "   ",
                "   ").build();
        Coordinate origin = new Coordinate(0, 0);
        Coordinate target = new Coordinate(0, 1);
        board.moveToken(origin, target);
        assertThat(board.isEmpty(origin), is(true));
        assertThat(board.isOccupied(target, Color.X), is(true));
    }

    @Test
    public void testGivenBoardWhenMoveXTokenAndTargetIsOccupiedThenIsAssertion() {
        Board board = this.boardBuilder.rows(
                "XO ",
                "   ",
                "   ").build();
        Coordinate origin = new Coordinate(0, 0);
        Coordinate target = new Coordinate(0, 1);
        Assertions.assertThrows(AssertionError.class, () -> board.moveToken(origin, target));
    }

    @Test
    public void testGivenBoardWhenMoveTokenAndOriginIsEmptyThenIsAssertion() {
        Board board = this.boardBuilder.build();
        Coordinate origin = new Coordinate(1, 0);
        Coordinate target = new Coordinate(2, 2);
        Assertions.assertThrows(AssertionError.class, () -> board.moveToken(origin, target));
    }

    @Test
    public void testGivenBoardWhenMoveTokenAndOriginIsEqualsTargetThenIsAssertion() {
        Board board = this.boardBuilder.rows(
                "X  ",
                "   ",
                "   ").build();
        Coordinate origin = new Coordinate(0, 0);
        Coordinate target = new Coordinate(0, 0);
        Assertions.assertThrows(AssertionError.class, () -> board.moveToken(origin, target));
    }

    @Test
    public void testGivenBoardWhenGetColorThenReturn() {
        Board board = this.boardBuilder.rows(
                "X  ",
                "   ",
                "   ").build();
        assertThat(board.getColor(new Coordinate(0, 0)), is(Color.X));
    }

    @Test
    public void testGivenBoardWhenGetColorFromNullCoordinateThenReturn() {
        Board board = this.boardBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> board.getColor(new Coordinate()));
    }

    @Test
    public void testGivenEmptyBoardWhenCheckIsOccupiedThenIsFalse() {
        Board board = this.boardBuilder.build();
        assertThat(board.isOccupied(new Coordinate(0, 0), Color.X), is(false));
    }

    @Test
    public void testGivenBoardWhenCheckIsOccupiedThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "X  ",
                "   ",
                "   ").build();
        assertThat(board.isOccupied(new Coordinate(0, 0), Color.X), is(true));
    }

    @Test
    public void testGivenBoardWhenCheckNullCoordinateIsOccupiedThenAssertionError() {
        Board board = this.boardBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> board.isOccupied(new Coordinate(), Color.O));
    }

    @Test
    public void testGivenBoardWhenIsTicTacToeThenIsFalse() {
        Board board = this.boardBuilder.build();
        assertThat(board.isTicTacToe(Color.O), is(false));
    }

    @Test
    public void testGivenBoardWhenIsTicTacToeNullColorThenAssertionError() {
        Board board = this.boardBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> board.isTicTacToe(Color.NULL));
    }

    @Test
    public void testGivenBoardWhenIsVerticalTicTacToeThenIsTrue() {
        Board board = this.boardBuilder.rows(
                " X ",
                "OXO",
                " X ").build();
        assertThat(board.isTicTacToe(Color.X), is(true));
    }

    @Test
    public void testGivenBoardWhenIsHorizontalTicTacToeThenIsTrue() {
        Board board = this.boardBuilder.rows(
                " O ",
                "XXX",
                " O ").build();
        assertThat(board.isTicTacToe(Color.X), is(true));
    }

    @Test
    public void testGivenBoardWhenIsDiagonalTicTacToeThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "X  ",
                "OXO",
                "  X").build();
        assertThat(board.isTicTacToe(Color.X), is(true));
    }

    @Test
    public void testGivenBoardWhenIsInverseDiagonalTicTacToeThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "  X",
                "OXO",
                "X  ").build();
        assertThat(board.isTicTacToe(Color.X), is(true));
    }

    @Test
    public void testGivenCompleteBoardAndIsTicTacToeThenIsFalse() {
        Board board = this.boardBuilder.rows(
                "XO ",
                "XO ",
                "OX ").build();
        assertThat(board.isTicTacToe(Color.X), is(false));
        assertThat(board.isTicTacToe(Color.O), is(false));
    }

}
