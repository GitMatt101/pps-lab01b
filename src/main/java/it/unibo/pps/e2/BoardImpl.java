package it.unibo.pps.e2;

import java.util.Random;

public class BoardImpl implements Board {

    private final int size;
    private final Pair<Integer, Integer> pawn;
    private Pair<Integer, Integer> knight;
    private final Random random = new Random();

    public BoardImpl(int size, Pair<Integer, Integer> pawn, Pair<Integer, Integer> knight) {
        this.size = size;
        this.pawn = pawn;
        this.knight = knight;
    }

    public BoardImpl(int size) {
        this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();
    }

    private Pair<Integer,Integer> randomEmptyPosition() {
        Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
        // the recursive call below prevents clash with an existing pawn
        return this.pawn != null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.pawn.equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.knight.equals(new Pair<>(row, col));
    }

    @Override
    public void moveKnight(int row, int col) {
        if (!this.checkBounds(row, col))
            throw new IndexOutOfBoundsException();
        int x = row - this.knight.getX();
        int y = col - this.knight.getY();
        if (this.checkValidMove(x, y))
            this.knight = new Pair<>(row,col);
    }

    /**
     * Checks if the given position is within bounds
     * @param row
     * @param col
     * @return true if the position is inside the board
     */
    private boolean checkBounds(int row, int col) {
        return row >= 0 && col >= 0 && row < this.size && col < this.size;
    }

    /**
     * Checks if the given movement represents a valid move for the knight
     * @param x
     * @param y
     * @return true if the move is valid, meaning if the knight moves in an 'L' shape
     */
    private boolean checkValidMove(int x, int y) {
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }
}
