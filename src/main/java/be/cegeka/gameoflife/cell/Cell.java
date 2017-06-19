package be.cegeka.gameoflife.cell;


public class Cell {
    private boolean isAlive = false;
    private int row;
    private int col;

    public Cell(boolean isAlive, int row, int col) {
        this.isAlive = isAlive;
        this.row = row;
        this.col = col;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (isAlive != cell.isAlive) return false;
        if (row != cell.row) return false;
        return col == cell.col;
    }

    @Override
    public int hashCode() {
        int result = (isAlive ? 1 : 0);
        result = 31 * result + row;
        result = 31 * result + col;
        return result;
    }

    public boolean isInRangeOf(Cell originalCell) {
        return checkLineAbove(originalCell) || checkSameLineAs(originalCell) || checkLineUnder(originalCell);
    }

    private boolean checkLineUnder(Cell originalCell) {
        return row == originalCell.getRow() + 1 && col == originalCell.getCol() - 1
            || row == originalCell.getRow() + 1 && col == originalCell.getCol()
            || row == originalCell.getRow() + 1 && col == originalCell.getCol() + 1;
    }

    private boolean checkSameLineAs(Cell originalCell) {
        return (row == originalCell.getRow() && col == originalCell.getCol() - 1
            || row == originalCell.getRow() && col == originalCell.getCol() + 1)
            && !this.equals(originalCell);
    }

    private boolean checkLineAbove(Cell originalCell) {
        return row == originalCell.getRow() - 1 && col == originalCell.getCol() - 1
            || row == originalCell.getRow() - 1 && col == originalCell.getCol()
            || row == originalCell.getRow() - 1 && col == originalCell.getCol() + 1;
    }
}
