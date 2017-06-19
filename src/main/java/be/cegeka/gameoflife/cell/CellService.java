package be.cegeka.gameoflife.cell;

import be.cegeka.gameoflife.World.World;

public class CellService {
    private CellSurviveRules cellSurviveRules = new CellSurviveRules();

    public boolean doesCellLive(World world, Cell cell){
        return cellSurviveRules.doesCellLives(world, cell);
    }
}
