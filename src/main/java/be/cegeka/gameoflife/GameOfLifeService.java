package be.cegeka.gameoflife;

import java.util.List;

public class GameOfLifeService {

    public List<List<Boolean>> getNewWorld(List<List<Boolean>> oldWorld){
        World currentWorld = createWorldWithCells(oldWorld);
        World newWorld = createNewWorld(currentWorld);
        return convertNewWorldToListOfBooleans(newWorld);
    }

    private World createWorldWithCells(List<List<Boolean>> oldWorld) {
        List<Cell> oldWorldWithCells = GameOfLifeFactory.convertBooleanToCell(oldWorld);
        return new World(oldWorldWithCells);
    }

    private List<List<Boolean>> convertNewWorldToListOfBooleans(World newWorld) {
        return GameOfLifeFactory.convertNewWorldToListOfBooleans(newWorld);
    }

    private World createNewWorld(World currentWorld) {
        return GameOfLifeFactory.createNewWorld(currentWorld);
    }
}
