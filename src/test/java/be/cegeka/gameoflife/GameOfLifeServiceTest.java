package be.cegeka.gameoflife;

import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class GameOfLifeServiceTest {
    private List<List<Boolean>> booleanWorld = new ArrayList<>();
    private List<Boolean> bools1OldWorld = new ArrayList<>();
    private List<Boolean> bools1NewWorld = new ArrayList<>();
    private List<Boolean> bools2OldWorld = new ArrayList<>();
    private List<Boolean> bools2NewWorld = new ArrayList<>();
    private List<Cell> cellWorldOld = new ArrayList<>();
    private List<Cell> cellWorldNew = new ArrayList<>();
    private GameOfLifeService service= new GameOfLifeService();
    private World newWorld;

    @Before
    public void setUp() throws Exception {
        Cell cellTrue = new Cell(true, 0, 0);
        Cell cellFalse = new Cell(false, 0, 1);
        Cell cellFalse2 = new Cell(false, 1, 0);
        Cell cellFalse3 = new Cell(false, 1, 1);
        Cell cellFalse4 = new Cell(false, 0, 0);

        bools1OldWorld.add(true);
        bools1OldWorld.add(false);
        bools2OldWorld.add(false);
        bools2OldWorld.add(false);

        bools1NewWorld.add(false);
        bools1NewWorld.add(false);
        bools2NewWorld.add(false);
        bools2NewWorld.add(false);

        cellWorldOld.add(cellTrue);
        cellWorldOld.add(cellFalse);
        cellWorldOld.add(cellFalse2);
        cellWorldOld.add(cellFalse3);

        cellWorldNew.add(cellFalse);
        cellWorldNew.add(cellFalse2);
        cellWorldNew.add(cellFalse3);
        cellWorldNew.add(cellFalse4);


        booleanWorld.add(bools1OldWorld);
        booleanWorld.add(bools2OldWorld);

        World oldWorld = new World(cellWorldOld);
        newWorld = new World(cellWorldNew);
    }

//    @Test
//    public void createWorld_ShouldReturn_AllFalse() throws Exception {
//        Assertions.assertThat(service.getNewWorld(booleanWorld)).isEqualTo(newWorld);
//
//    }
}