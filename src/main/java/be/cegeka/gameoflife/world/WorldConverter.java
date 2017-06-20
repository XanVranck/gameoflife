package be.cegeka.gameoflife.world;

import be.cegeka.gameoflife.cell.Cell;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorldConverter {
    public List<Cell> convertWorldFromBooleanListToCellList(List<List<Boolean>> world){
        List<Cell> cellList = new ArrayList<>();
        for (int row = 0; row < world.size(); row++) {
            for (int col = 0; col < world.get(0).size(); col++) {
                makeCellOutOfBoolean(world, cellList, row, col);
            }
        }
        return cellList;
    }

    private void makeCellOutOfBoolean(List<List<Boolean>> world, List<Cell> cellList, int row, int col) {
        boolean cellBoolean = world.get(row).get(col);
        Cell cell = new Cell(cellBoolean, row, col);
        cellList.add(cell);
    }

    public List<List<Boolean>> convertNewWorldFromCellListToBooleansList(World newWorld) {
        List<List<Boolean>> booleanWorld = new ArrayList<>();
        for (int row = 0; row <= newWorld.getMaxRow().getAsInt(); row++) {
            List<Boolean> booleanList = new ArrayList<>();
            for (int col = 0; col <= newWorld.getMaxCol().getAsInt(); col++) {
                makeBooleanOutOfCell(newWorld, row, booleanList, col);
            }
            booleanWorld.add(booleanList);
        }
        return booleanWorld;
    }

    private void makeBooleanOutOfCell(World newWorld, int row, List<Boolean> booleanList, int col) {
        Cell cell = newWorld.getCell(row, col).get();
        Boolean booleanCell = cell.getIsAlive();
        booleanList.add(booleanCell);
    }
}
