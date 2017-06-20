package be.cegeka.gameoflife.surviverules;

import be.cegeka.gameoflife.cell.Cell;
import be.cegeka.gameoflife.world.World;

public interface SurviveRules {
    boolean doesCellLive(World world, Cell originalCell);

    boolean originalCellWasDeadAndHasExactlyThreeNeighbours(Cell originalCell, int amountOfNeighbours);

    boolean originalCellWasAliveAndHasTwoOrThreeNeighbours(Cell originalCell, int amountOfLivingNeighbours);
}
