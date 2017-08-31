package be.cegeka.gameoflife.surviverules;

import be.cegeka.gameoflife.cell.Cell;
import be.cegeka.gameoflife.world.World;

public interface SurviveRules {
    boolean doesCellLive(World world, Cell originalCell);

    boolean comesAlive(Cell originalCell, int amountOfNeighbours);

    boolean staysAlive(Cell originalCell, int amountOfLivingNeighbours);
}
