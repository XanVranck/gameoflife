package be.cegeka.gameoflife.cell;

import be.cegeka.gameoflife.world.World;

import java.util.ArrayList;
import java.util.List;

public class CellSurviveRules {
    public Boolean doesCellLives(World world, Cell originalCell) {
        List<Cell> grid = world.getGrid();
        List<Cell> neighbours = new ArrayList<>();

        for (Cell cell : grid) {
            if (cellIsInRangeOfRow(cell, originalCell) && cellIsInRangeOfCol(cell, originalCell) && !cell.equals(originalCell)) {
                neighbours.add(cell);
            }
        }
        return determineIfCellLives(neighbours, originalCell);
    }

    private boolean cellIsInRangeOfCol(Cell cell, Cell originalCell) {
        return cell.getCol() == originalCell.getCol() - 1 || cell.getCol() == originalCell.getCol() || cell.getCol() == originalCell.getCol() + 1;
    }

    private boolean cellIsInRangeOfRow(Cell cell, Cell originalCell) {
        return cell.getRow() == originalCell.getRow() - 1 || cell.getRow() == originalCell.getRow() || cell.getRow() == originalCell.getRow() + 1;
    }

    private Boolean determineIfCellLives(List<Cell>neighbours, Cell originalCell) {
        int amountOfLivingNeighbours = (int) neighbours.stream().filter(Cell::getIsAlive).count();

        return originalCellWasAllreadyAliveAndHasTwoOrThreeNeighbours(originalCell, amountOfLivingNeighbours) ||
                OriginalCellWasDeadAndHasExactlyThreeNeighbours(originalCell, amountOfLivingNeighbours);
    }

    private boolean OriginalCellWasDeadAndHasExactlyThreeNeighbours(Cell originalCell, int amountOfLivingNeighbours) {
        return !originalCell.getIsAlive() && amountOfLivingNeighbours == 3;
    }

    private boolean originalCellWasAllreadyAliveAndHasTwoOrThreeNeighbours(Cell originalCell, int amountOfLivingNeighbours) {
        return originalCell.getIsAlive() && (amountOfLivingNeighbours == 2 || amountOfLivingNeighbours == 3);
    }
}
