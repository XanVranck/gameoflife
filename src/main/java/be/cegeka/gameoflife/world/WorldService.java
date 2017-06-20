package be.cegeka.gameoflife.world;

import be.cegeka.gameoflife.cell.Cell;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorldService {
    @Autowired
    private WorldConverter worldConverter;

    @Autowired
    private WorldFactory worldFactory;

    public List<List<Boolean>> getNewWorld(List<List<Boolean>> oldWorld){
        World currentWorld = createWorldWithCells(oldWorld);
        World newWorld = createNewWorld(currentWorld);
        return convertNewWorldToListOfBooleans(newWorld);
    }

    @NotNull
    private World createWorldWithCells(List<List<Boolean>> oldWorld) {
        List<Cell> oldWorldWithCells = worldConverter.convertWorldFromBooleanListToCellList(oldWorld);
        return new World(oldWorldWithCells);
    }

    private List<List<Boolean>> convertNewWorldToListOfBooleans(World newWorld) {
        return worldConverter.convertNewWorldFromCellListToBooleansList(newWorld);
    }

    @NotNull
    private World createNewWorld(World currentWorld) {
        return worldFactory.createNewWorld(currentWorld);
    }
}
