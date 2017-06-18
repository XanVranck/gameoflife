package be.cegeka.gameoflife;

import java.util.List;

public class GameOfLifeService {
    private World world;

    public List<List<Boolean>> getNewWorld(List<List<Boolean>> oldWorld){
        List<Cell> oldWorldWithCells = GameOfLifeFactory.convertBooleanToCell(oldWorld);
        world = new World(oldWorldWithCells);
        World newWorld = createNewWorld(world);
        return convertNewWorldToListOfBooleans(newWorld);
    }

    private List<List<Boolean>> convertNewWorldToListOfBooleans(World newWorld) {
        return GameOfLifeFactory.convertNewWorldToListOfBooleans(newWorld);
    }

    private World createNewWorld(World world) {
        return GameOfLifeFactory.createNewWorld(world);
    }
}
