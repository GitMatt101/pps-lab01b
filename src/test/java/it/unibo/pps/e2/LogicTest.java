package it.unibo.pps.e2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private static final int BOARD_SIZE = 9;
    private static final int CENTER = BOARD_SIZE / 2;
    private static final Pair<Integer, Integer> KNIGHT = new Pair<>(CENTER, CENTER);
    private static final Pair<Integer, Integer> PAWN = new Pair<>(0, 0);
    private Logics logics;

    @BeforeEach
    public void init() {
        this.logics = new LogicsImpl(BOARD_SIZE, PAWN, KNIGHT);
    }

    @Test
    public void testInitialPosition() {
        assertTrue(this.logics.hasPawn(PAWN.getX(), PAWN.getY()));
        assertTrue(this.logics.hasKnight(KNIGHT.getX(), KNIGHT.getY()));
    }

    @Test
    public void testMoveOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(-1, -1));
    }

    @ParameterizedTest
    @MethodSource("provideValidMoves")
    public void testValidMove(int row, int col) {
        this.logics.hit(row, col);
        assertTrue(this.logics.hasKnight(row, col));
    }

    @Test
    public void testInvalidMove() {
        Pair<Integer, Integer> invalidMove = new Pair<>(1, 1);
        this.logics.hit(invalidMove.getX(), invalidMove.getY());
        assertFalse(this.logics.hasKnight(invalidMove.getX(), invalidMove.getY()));
    }

    private static Stream<Arguments> provideValidMoves() {
        List<Arguments> arguments = new ArrayList<>();
        for (int i : List.of(-1, 1)) {
            arguments.add(Arguments.of(KNIGHT.getX() + i, KNIGHT.getY() + 2));
            arguments.add(Arguments.of(KNIGHT.getX() + i, KNIGHT.getY() - 2));
            arguments.add(Arguments.of(KNIGHT.getX() + i * 2, KNIGHT.getY() + 1));
            arguments.add(Arguments.of(KNIGHT.getX() + i * 2, KNIGHT.getY() - 1));
        }
        return arguments.stream();
    }
}
