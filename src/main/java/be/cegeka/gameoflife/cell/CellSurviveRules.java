package be.cegeka.gameoflife.cell;

import be.cegeka.gameoflife.World.World;

import java.util.List;

public class CellSurviveRules {

    public Boolean doesCellLives(World world, Cell originalCell) {
        List<Cell> grid = world.getGrid();
        int count = 0;

        for (Cell cell : grid) {
            if (cellIsInRangeOfRow(cell, originalCell) && cellIsInRangeOfCol(cell, originalCell)) {
                count = countLivingCells(count, cell, originalCell);
            }
        }
        return determineIfCellLivesOrDie(count, originalCell);

    }

    private int countLivingCells(int count, Cell cell, Cell originalCell) {
        count = checkLineAboveCell(count, cell, originalCell);
        count = checkSameLineAsCell(count, cell, originalCell);
        count = checkLineUnderCell(count, cell, originalCell);
        return count;
    }

    private int checkLineUnderCell(int count, Cell cell, Cell originalCell) {
        if (checkBottomLeftCorner(cell, originalCell)) {
            count++;
        }
        if (checkLineUnderCell(cell, originalCell)) {
            count++;
        }
        if (checkBottomRightCorner(cell, originalCell)) {
            count++;
        }
        return count;
    }

    private int checkSameLineAsCell(int count, Cell cell, Cell originalCell) {
        if (checkLeftOfCell(cell, originalCell)) {
            count++;
        }
        if (checkRightOfCell(cell, originalCell)) {
            count++;
        }
        return count;
    }

    private int checkLineAboveCell(int count, Cell cell, Cell originalCell) {
        if (checkUpperLeftCorner(cell, originalCell)) {
            count++;
        }
        if (checkLineAboveCell(cell, originalCell)) {
            count++;
        }
        if (checkUpperRightCorner(cell, originalCell)) {
            count++;
        }
        return count;
    }

    private boolean cellIsInRangeOfCol(Cell cell, Cell originalCell) {
        return cell.getCol() == originalCell.getCol() - 1 || cell.getCol() == originalCell.getCol() || cell.getCol() == originalCell.getCol() + 1;
    }

    private boolean cellIsInRangeOfRow(Cell cell, Cell originalCell) {
        return cell.getRow() == originalCell.getRow() - 1 || cell.getRow() == originalCell.getRow() || cell.getRow() == originalCell.getRow() + 1;
    }

    private boolean checkBottomRightCorner(Cell cell, Cell originalCell) {
        return cell.getRow() == originalCell.getRow() + 1 && cell.getCol() == originalCell.getCol() + 1 && cell.getIsAlive();
    }

    private boolean checkLineUnderCell(Cell cell, Cell originalCell) {
        return cell.getRow() == originalCell.getRow() + 1 && cell.getCol() == originalCell.getCol() && cell.getIsAlive();
    }

    private boolean checkBottomLeftCorner(Cell cell, Cell originalCell) {
        return cell.getRow() == originalCell.getRow() + 1 && cell.getCol() == originalCell.getCol() - 1 && cell.getIsAlive();
    }

    private boolean checkRightOfCell(Cell cell, Cell originalCell) {
        return cell.getRow() == originalCell.getRow() && cell.getCol() == originalCell.getCol() + 1 && cell.getIsAlive();
    }

    private boolean checkLeftOfCell(Cell cell, Cell originalCell) {
        return cell.getRow() == originalCell.getRow() && cell.getCol() == originalCell.getCol() - 1 && cell.getIsAlive();
    }

    private boolean checkUpperRightCorner(Cell cell, Cell originalCell) {
        return cell.getRow() == originalCell.getRow() - 1 && cell.getCol() == originalCell.getCol() + 1 && cell.getIsAlive();
    }

    private boolean checkLineAboveCell(Cell cell, Cell originalCell) {
        return cell.getRow() == originalCell.getRow() - 1 && cell.getCol() == originalCell.getCol() && cell.getIsAlive();
    }

    private boolean checkUpperLeftCorner(Cell cell, Cell originalCell) {
        return cell.getRow() == originalCell.getRow() - 1 && cell.getCol() == originalCell.getCol() - 1 && cell.getIsAlive();
    }

    private Boolean determineIfCellLivesOrDie(int count, Cell originalCell) {
        if (originalCell.getIsAlive() && (count == 2 || count == 3)) {
            return true;
        } else if (!originalCell.getIsAlive() && count == 3) {
            return true;
        }
        return false;
    }
}
