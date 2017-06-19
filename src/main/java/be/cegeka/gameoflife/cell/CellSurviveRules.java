package be.cegeka.gameoflife.cell;

import be.cegeka.gameoflife.world.World;

import java.util.ArrayList;
import java.util.List;

public class CellSurviveRules {
    public Boolean doesCellLives(World world, Cell originalCell) {
        List<Cell> neighbours = new ArrayList<>();

        for (Cell cell : world.getGrid()) {
            if (cell.IsInRangeOf(originalCell)) {
                neighbours.add(cell);
            }
        }
        return determineIfCellLives(neighbours, originalCell);
    }

    private Boolean determineIfCellLives(List<Cell>neighbours, Cell originalCell) {
        int amountOfLivingNeighbours = (int) neighbours.stream().filter(Cell::getIsAlive).count();

        return originalCellWasAliveAndHasTwoOrThreeNeighbours(originalCell, amountOfLivingNeighbours) ||
                OriginalCellWasDeadAndHasExactlyThreeNeighbours(originalCell, amountOfLivingNeighbours);
    }

    private boolean OriginalCellWasDeadAndHasExactlyThreeNeighbours(Cell originalCell, int amountOfLivingNeighbours) {
        return !originalCell.getIsAlive() && amountOfLivingNeighbours == 3;
    }

    private boolean originalCellWasAliveAndHasTwoOrThreeNeighbours(Cell originalCell, int amountOfLivingNeighbours) {
        return originalCell.getIsAlive() && (amountOfLivingNeighbours == 2 || amountOfLivingNeighbours == 3);
    }
}
