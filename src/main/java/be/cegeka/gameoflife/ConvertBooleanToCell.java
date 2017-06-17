package be.cegeka.gameoflife;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xanv on 17/06/2017.
 */
public class ConvertBooleanToCell {
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
}
