package be.cegeka.gameoflife;

import java.util.List;

/**
 * Created by xanv on 17/06/2017.
 */
public class Cell {
    private boolean isAlive = false;
    private int row;
    private int col;

    public Cell(boolean isAlive, int row, int col) {
        this.isAlive = isAlive;
        this.row = row;
        this.col = col;
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

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
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

    public Boolean doesCellLives(World world) {
        List<Cell> grid = world.getGrid();
        int count = 0;

        for (Cell cell : grid) {
            if (cellIsInRangeOfRow(cell) && cellIsInRangeOfCol(cell)) {
                if (checkUpperLeftCorner(cell)) {
                    count++;
                }
                if (checkAboveCell(cell)) {
                    count++;
                }
                if (checkUpperRightCorner(cell)) {
                    count++;
                }
                if (checkLeftOfCell(cell)) {
                    count++;
                }
                if (checkRightOfCell(cell)) {
                    count++;
                }
                if (checkBottomLeftCorner(cell)) {
                    count++;
                }
                if (checkUnderCell(cell)) {
                    count++;
                }
                if (checkBottomRightCorner(cell)) {
                    count++;
                }
            }
        }
        if (isAlive && (count == 2 || count == 3)) {
            return true;
        } else if (!isAlive && count == 3) {
            return true;
        }
        return false;

    }

    private boolean cellIsInRangeOfCol(Cell cell) {
        return cell.getCol() == col - 1 || cell.getCol() == col || cell.getCol() == col + 1;
    }

    private boolean cellIsInRangeOfRow(Cell cell) {
        return cell.getRow() == row - 1 || cell.getRow() == row || cell.getRow() == row + 1;
    }

    private boolean checkBottomRightCorner(Cell cell) {
        return cell.getRow() == row + 1 && cell.getCol() == col + 1 && cell.isAlive();
    }

    private boolean checkUnderCell(Cell cell) {
        return cell.getRow() == row + 1 && cell.getCol() == col && cell.isAlive();
    }

    private boolean checkBottomLeftCorner(Cell cell) {
        return cell.getRow() == row + 1 && cell.getCol() == col - 1 && cell.isAlive();
    }

    private boolean checkRightOfCell(Cell cell) {
        return cell.getRow() == row && cell.getCol() == col + 1 && cell.isAlive();
    }

    private boolean checkLeftOfCell(Cell cell) {
        return cell.getRow() == row && cell.getCol() == col - 1 && cell.isAlive();
    }

    private boolean checkUpperRightCorner(Cell cell) {
        return cell.getRow() == row - 1 && cell.getCol() == col + 1 && cell.isAlive();
    }

    private boolean checkAboveCell(Cell cell) {
        return cell.getRow() == row - 1 && cell.getCol() == col && cell.isAlive();
    }

    private boolean checkUpperLeftCorner(Cell cell) {
        return cell.getRow() == row - 1 && cell.getCol() == col - 1 && cell.isAlive();
    }
}
