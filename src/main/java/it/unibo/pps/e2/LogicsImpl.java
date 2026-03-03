package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {

    private final Board board;

    public LogicsImpl(int size, Pair<Integer, Integer> pawn, Pair<Integer, Integer> knight) {
        if (pawn == null || knight == null || size <= 1 || pawn.equals(knight))
            throw new IllegalArgumentException();
        this.board = new BoardImpl(size, pawn, knight);
    }

    public LogicsImpl(int size) {
        if (size <= 1)
            throw new IllegalArgumentException();
        this.board = new BoardImpl(size);
    }
    
	@Override
	public boolean hit(int row, int col) {
		this.board.moveKnight(row, col);
		return this.board.hasKnight(row, col) && this.board.hasPawn(row, col);
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.board.hasKnight(row, col);
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.board.hasPawn(row, col);
	}
}
