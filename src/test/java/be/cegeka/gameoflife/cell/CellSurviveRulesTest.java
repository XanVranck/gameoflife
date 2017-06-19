package be.cegeka.gameoflife.cell;

import be.cegeka.gameoflife.world.World;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CellSurviveRulesTest {
    private Cell cellRow0Col0 = new Cell(false, 0, 0);
    private Cell cellRow0Col1 = new Cell(true, 0, 1);
    private Cell cellRow0Col2 = new Cell(false, 0, 1);
    private Cell cellRow1Col0 = new Cell(true, 1, 0);
    private Cell cellRow1Col1 = new Cell(false, 1, 1);
    private Cell cellRow1Col2 = new Cell(true, 1, 2);
    private Cell cellRow2Col0 = new Cell(false, 2, 0);
    private Cell cellRow2Col1 = new Cell(false, 2, 1);
    private Cell cellRow2Col2 = new Cell(false, 2, 2);
    private List<Cell> cellList = new ArrayList<>();
    private World world;
    private CellSurviveRules cellSurviveRules = new CellSurviveRules();

    @Before
    public void setUp() throws Exception {
        cellList.add(cellRow0Col0);
        cellList.add(cellRow0Col1);
        cellList.add(cellRow0Col2);
        cellList.add(cellRow1Col0);
        cellList.add(cellRow1Col1);
        cellList.add(cellRow1Col2);
        cellList.add(cellRow2Col0);
        cellList.add(cellRow2Col1);
        cellList.add(cellRow2Col2);
        world = new World(cellList);
    }

    @Test
    public void doesCellLives_dies() throws Exception {
        assertThat(cellSurviveRules.doesCellLives(world, cellRow0Col0)).isEqualTo(false);
    }

    @Test
    public void doesCellLives_ComesTolive() throws Exception {
        assertThat(cellSurviveRules.doesCellLives(world, cellRow1Col1)).isEqualTo(true);
    }

    @Test
    public void doelCellLive_survives() throws Exception {
        assertThat(cellSurviveRules.doesCellLives(world, cellRow0Col1)).isEqualTo(true);
    }
}