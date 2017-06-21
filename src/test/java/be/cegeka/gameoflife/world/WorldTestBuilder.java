package be.cegeka.gameoflife.world;

import be.cegeka.gameoflife.cell.Cell;

import java.util.ArrayList;
import java.util.List;

public class WorldTestBuilder {
    private List<Cell> cellList = new ArrayList<>();
    private Cell cellRow0Col0 = new Cell(false, 0 , 0);
    private Cell cellRow0Col1 = new Cell(false, 0 , 1);
    private Cell cellRow0Col2 = new Cell(false, 0 , 2);
    private Cell cellRow1Col0 = new Cell(true,1,0);
    private Cell cellRow1Col1 = new Cell(false,1,1);
    private Cell cellRow1Col2 = new Cell(true,1,2);
    private Cell cellRow2Col0 = new Cell(false, 2,0);
    private Cell cellRow2Col1 = new Cell(true, 2,1);
    private Cell cellRow2Col2= new Cell(false, 2,2);

    public WorldTestBuilder(){
        cellList.add(cellRow0Col0);
        cellList.add(cellRow0Col1);
        cellList.add(cellRow0Col2);
        cellList.add(cellRow1Col0);
        cellList.add(cellRow1Col1);
        cellList.add(cellRow1Col2);
        cellList.add(cellRow2Col0);
        cellList.add(cellRow2Col1);
        cellList.add(cellRow2Col2);
    }

    public WorldTestBuilder withCellList(List<Cell> cellList) {
        this.cellList = cellList;
        return this;
    }

    public World build(){
        return new World(cellList);
    }
}
