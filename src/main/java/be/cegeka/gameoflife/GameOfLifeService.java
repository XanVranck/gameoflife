package be.cegeka.gameoflife;

import java.util.List;

public class GameOfLifeService {
    private World world;

    public List<List<Boolean>> getNewWorld(List<List<Boolean>> oldWorld){
        List<Cell> oldWorldWithCells = GameOfLifeFactory.convertBooleanToCell(oldWorld);
        world = new World(oldWorldWithCells);
        createNewWorld(world);
        return null;
    }

    private World createNewWorld(World world) {
        GameOfLifeFactory.creatNewWorld(world);
        return null;
    }
}
