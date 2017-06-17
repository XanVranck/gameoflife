package be.cegeka.gameoflife;

/**
 * Created by xanv on 17/06/2017.
 */
public class Cell {
    private boolean isAlive = false;
    private int row;
    private int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
