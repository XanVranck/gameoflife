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

    public Boolean doesCellLives(World world) {
        List<Cell> grid = world.getGrid();
        int count = 0;

        for (Cell cell : grid) {
            if (cellIsInRangeOfRow(cell) && cellIsInRangeOfCol(cell)) {
                count = countLivingCells(count, cell);
            }
        }
        return determineIfCellLivesOrDie(count);

    }

    private Boolean determineIfCellLivesOrDie(int count) {
        if (isAlive && (count == 2 || count == 3)) {
            return true;
        } else if (!isAlive && count == 3) {
            return true;
        }
        return false;
    }

    private int countLivingCells(int count, Cell cell) {
        count = checkLineAboveCell(count, cell);
        count = checkSameLineAsCell(count, cell);
        count = checkLineUnderCell(count, cell);
        return count;
    }

    private int checkLineUnderCell(int count, Cell cell) {
        if (checkBottomLeftCorner(cell)) {
            count++;
        }
        if (checkLineUnderCell(cell)) {
            count++;
        }
        if (checkBottomRightCorner(cell)) {
            count++;
        }
        return count;
    }

    private int checkSameLineAsCell(int count, Cell cell) {
        if (checkLeftOfCell(cell)) {
            count++;
        }
        if (checkRightOfCell(cell)) {
            count++;
        }
        return count;
    }

    private int checkLineAboveCell(int count, Cell cell) {
        if (checkUpperLeftCorner(cell)) {
            count++;
        }
        if (checkLineAboveCell(cell)) {
            count++;
        }
        if (checkUpperRightCorner(cell)) {
            count++;
        }
        return count;
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

    private boolean checkLineUnderCell(Cell cell) {
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

    private boolean checkLineAboveCell(Cell cell) {
        return cell.getRow() == row - 1 && cell.getCol() == col && cell.isAlive();
    }

    private boolean checkUpperLeftCorner(Cell cell) {
        return cell.getRow() == row - 1 && cell.getCol() == col - 1 && cell.isAlive();
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
}
