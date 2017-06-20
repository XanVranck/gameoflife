package be.cegeka.gameoflife.cell;

import be.cegeka.gameoflife.surviverules.SurviveRules;
import be.cegeka.gameoflife.world.World;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CellRulesApplier implements SurviveRules {
    public boolean doesCellLive(World world, Cell originalCell) {
        List<Cell> neighbours = new ArrayList<>();

        for (Cell cell : world.getGrid()) {
            if (cell.isInRangeOf(originalCell)) {
                neighbours.add(cell);
            }
        }
        return determineIfCellLives(neighbours, originalCell);
    }

    private boolean determineIfCellLives(List<Cell> neighbours, Cell originalCell) {
        int amountOfLivingNeighbours = (int) neighbours.stream()
                                                        .filter(Cell::getIsAlive)
                                                        .count();

        return originalCellWasAliveAndHasTwoOrThreeNeighbours(originalCell, amountOfLivingNeighbours)
            || originalCellWasDeadAndHasExactlyThreeNeighbours(originalCell, amountOfLivingNeighbours);
    }

    public boolean originalCellWasDeadAndHasExactlyThreeNeighbours(Cell originalCell, int amountOfLivingNeighbours) {
        return !originalCell.getIsAlive() && amountOfLivingNeighbours == 3;
    }

    public boolean originalCellWasAliveAndHasTwoOrThreeNeighbours(Cell originalCell, int amountOfLivingNeighbours) {
        return originalCell.getIsAlive() && (amountOfLivingNeighbours == 2 || amountOfLivingNeighbours == 3);
    }
}
