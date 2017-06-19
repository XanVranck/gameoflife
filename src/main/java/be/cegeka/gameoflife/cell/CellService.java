package be.cegeka.gameoflife.cell;

import be.cegeka.gameoflife.world.World;

public class CellService {
    private CellSurviveRules cellSurviveRules = new CellSurviveRules();

    public boolean cellLives(World world, Cell cell){
        return cellSurviveRules.doesCellLive(world, cell);
    }
}
