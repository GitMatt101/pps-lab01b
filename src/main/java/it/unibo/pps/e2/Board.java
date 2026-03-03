package it.unibo.pps.e2;

public interface Board {
    boolean hasPawn(int row, int col);
    boolean hasKnight(int row, int col);
    void moveKnight(int row, int col);
}
