package be.cegeka.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class GameOfLifeFactory {
    public static List<Cell> convertBooleanToCell(List<List<Boolean>> world){
        List<Cell> cellList = new ArrayList<>();
        for (int row = 0; row < world.size(); row++) {
            for (int col = 0; col < world.get(0).size(); col++) {
                boolean cellBoolean = world.get(row).get(col);
                Cell cell = new Cell(cellBoolean, row, col);
                cellList.add(cell);
            }
        }
        return cellList;
    }


    public static World createNewWorld(World world) {
        List<Cell> cellList = new ArrayList<>();
        for (Cell cell : world.getGrid()) {
            if(cell.doesCellLives(world)){
                Cell newCell = new Cell(true, cell.getRow(), cell.getCol());
                cellList.add(newCell);
            }else{
                cellList.add(new Cell(false, cell.getRow(), cell.getCol()));
            }
        }
        return new World(cellList);
    }

    public static List<List<Boolean>> convertNewWorldToListOfBooleans(World newWorld) {
        List<List<Boolean>> booleanWorld = new ArrayList<>();
        for (int row = 0; row <= newWorld.getMaxRow().getAsInt(); row++) {
            List<Boolean> booleanList = new ArrayList<>();
            for (int col = 0; col <= newWorld.getMaxCol().getAsInt(); col++) {
                Cell cell = newWorld.getCell(row, col).get();
                Boolean booleanCell = cell.isAlive();
                booleanList.add(booleanCell);
            }
            booleanWorld.add(booleanList);
        }
        return booleanWorld;
    }
}
