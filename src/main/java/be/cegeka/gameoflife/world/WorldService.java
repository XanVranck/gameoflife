package be.cegeka.gameoflife.world;

import be.cegeka.gameoflife.cell.Cell;

import java.util.List;

public class WorldService {

    public List<List<Boolean>> getNewWorld(List<List<Boolean>> oldWorld){
        World currentWorld = createWorldWithCells(oldWorld);
        World newWorld = createNewWorld(currentWorld);
        return convertNewWorldToListOfBooleans(newWorld);
    }

    private World createWorldWithCells(List<List<Boolean>> oldWorld) {
        List<Cell> oldWorldWithCells = WorldConverter.convertWorldFromBooleanListToCellList(oldWorld);
        return new World(oldWorldWithCells);
    }

    private List<List<Boolean>> convertNewWorldToListOfBooleans(World newWorld) {
        return WorldConverter.convertNewWorldFromCellListToBooleansList(newWorld);
    }

    private World createNewWorld(World currentWorld) {
        return WorldFactory.createNewWorld(currentWorld);
    }
}
