package be.cegeka.gameoflife.world;

import be.cegeka.gameoflife.World.World;
import be.cegeka.gameoflife.cell.Cell;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WorldTest {
    private List<Boolean> listOfBooleans1 = new ArrayList<>();
    private List<Boolean> listOfBooleans2 = new ArrayList<>();
    private List<Boolean> listOfBooleans3 = new ArrayList<>();

    private List<List<Boolean>> booleanWorld = new ArrayList<>();

    private List<Cell> listOfCells = new ArrayList<>();

    private World world;

    private Cell cellRow0Col0;
    private Cell cellRow0Col1;
    private Cell cellRow0Col2;
    private Cell cellRow1Col0;
    private Cell cellRow1Col1;
    private Cell cellRow1Col2;
    private Cell cellRow2Col0;
    private Cell cellRow2Col1;
    private Cell cellRow2Col2;

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

        cellRow0Col0 = new Cell(false, 0 , 0);
        cellRow0Col1 = new Cell(false, 0 , 1);
        cellRow0Col2 = new Cell(false, 0 , 2);
        cellRow1Col0 = new Cell(true,1,0);
        cellRow1Col1 = new Cell(false,1,1);
        cellRow1Col2 = new Cell(true,1,2);
        cellRow2Col0 = new Cell(false, 2,0);
        cellRow2Col1 = new Cell(true, 2,1);
        cellRow2Col2= new Cell(false, 2,2);

        listOfCells.add(cellRow0Col0);
        listOfCells.add(cellRow0Col1);
        listOfCells.add(cellRow0Col2);
        listOfCells.add(cellRow1Col0);
        listOfCells.add(cellRow1Col1);
        listOfCells.add(cellRow1Col2);
        listOfCells.add(cellRow2Col0);
        listOfCells.add(cellRow2Col1);
        listOfCells.add(cellRow2Col2);

        world = new World(listOfCells);
    }

    @Test
    public void getCell_ShouldReturnCell() throws Exception {
        assertThat(world.getCell(1,0).get()).isEqualTo(cellRow1Col0);
    }

    @Test
    public void getMaxCol_ShouldReturn2() throws Exception {
        assertThat(world.getMaxCol().getAsInt()).isEqualTo(2);
    }

    @Test
    public void getMaxRow_ShouldReturn2() throws Exception{
        assertThat(world.getMaxRow().getAsInt()).isEqualTo(2);
    }
}