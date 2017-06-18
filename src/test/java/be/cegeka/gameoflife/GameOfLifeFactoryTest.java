package be.cegeka.gameoflife;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by xanv on 18/06/2017.
 */
public class GameOfLifeFactoryTest {
    private List<Boolean> listOfBooleans1 = new ArrayList<>();
    private List<Boolean> listOfBooleans2 = new ArrayList<>();
    private List<Boolean> listOfBooleans3 = new ArrayList<>();

    private List<List<Boolean>> booleanWorld = new ArrayList<>();

    private List<Cell> listOfCells = new ArrayList<>();
    private List<Cell> newListOfCells = new ArrayList<>();

    private World oldWorld;
    private World newWorld;

    @Before
    public void setUp() throws Exception {
        listOfBooleans1.add(false);
        listOfBooleans1.add(false);
        listOfBooleans1.add(false);
        listOfBooleans2.add(true);
        listOfBooleans2.add(false);
        listOfBooleans2.add(true);
        listOfBooleans3.add(false);
        listOfBooleans3.add(true);
        listOfBooleans3.add(false);

        booleanWorld.add(listOfBooleans1);
        booleanWorld.add(listOfBooleans2);
        booleanWorld.add(listOfBooleans3);

        Cell cellRow0Col0 = new Cell(false, 0 , 0);
        Cell cellRow0Col1 = new Cell(false, 0 , 1);
        Cell cellRow0Col2 = new Cell(false, 0 , 2);
        Cell cellRow1Col0 = new Cell(true,1,0);
        Cell cellRow1Col1 = new Cell(false,1,1);
        Cell cellRow1Col2 = new Cell(true,1,2);
        Cell cellRow2Col0 = new Cell(false, 2,0);
        Cell cellRow2Col1 = new Cell(true, 2,1);
        Cell cellRow2Col2= new Cell(false, 2,2);

        Cell newCellRow0Col0 = new Cell(false, 0 , 0);
        Cell newCellRow0Col1 = new Cell(false, 0 , 1);
        Cell newCellRow0Col2 = new Cell(false, 0 , 2);
        Cell newCellRow1Col0 = new Cell(false,1,0);
        Cell newCellRow1Col1 = new Cell(true,1,1);
        Cell newCellRow1Col2 = new Cell(false,1,2);
        Cell newCellRow2Col0 = new Cell(false, 2,0);
        Cell newCellRow2Col1 = new Cell(true, 2,1);
        Cell newCellRow2Col2= new Cell(false, 2,2);

        listOfCells.add(cellRow0Col0);
        listOfCells.add(cellRow0Col1);
        listOfCells.add(cellRow0Col2);
        listOfCells.add(cellRow1Col0);
        listOfCells.add(cellRow1Col1);
        listOfCells.add(cellRow1Col2);
        listOfCells.add(cellRow2Col0);
        listOfCells.add(cellRow2Col1);
        listOfCells.add(cellRow2Col2);

        newListOfCells.add(newCellRow0Col0);
        newListOfCells.add(newCellRow0Col1);
        newListOfCells.add(newCellRow0Col2);
        newListOfCells.add(newCellRow1Col0);
        newListOfCells.add(newCellRow1Col1);
        newListOfCells.add(newCellRow1Col2);
        newListOfCells.add(newCellRow2Col0);
        newListOfCells.add(newCellRow2Col1);
        newListOfCells.add(newCellRow2Col2);

        oldWorld = new World(listOfCells);
        newWorld = new World(newListOfCells);

    }

    @Test
    public void convertBooleanToCell() throws Exception {
        assertThat(GameOfLifeFactory.convertBooleanToCell(booleanWorld)).isEqualTo(listOfCells);
    }

    @Test
    public void createNewWorld() throws Exception {
        assertThat(GameOfLifeFactory.createNewWorld(oldWorld)).isEqualToComparingFieldByField(newWorld);
    }
}