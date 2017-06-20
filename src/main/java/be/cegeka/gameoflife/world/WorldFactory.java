package be.cegeka.gameoflife.world;

import be.cegeka.gameoflife.cell.Cell;
import be.cegeka.gameoflife.cell.CellService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorldFactory {
    @Autowired
    private CellService cellService;

    @NotNull
    public World createNewWorld(World world) {
        List<Cell> cellList = new ArrayList<>();
        for (Cell cell : world.getGrid()) {
            addCellToNewWorld(world, cellList, cell);
        }
        return new World(cellList);
    }

    private void addCellToNewWorld(World world, List<Cell> cellList, Cell cell) {
        if(cellService.cellLives(world, cell)){
            Cell newCell = new Cell(true, cell.getRow(), cell.getCol());
            cellList.add(newCell);
        }else{
            cellList.add(new Cell(false, cell.getRow(), cell.getCol()));
        }
    }
}
