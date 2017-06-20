package be.cegeka.gameoflife.world;

import be.cegeka.GameoflifeApplicationTests;
import be.cegeka.gameoflife.cell.Cell;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WorldServiceTest extends GameoflifeApplicationTests {
    private List<List<Boolean>> booleanWorld = new ArrayList<>();
    private List<List<Boolean>> booleanNewWorld = new ArrayList<>();
    private List<Boolean> bools1OldWorld = new ArrayList<>();
    private List<Boolean> bools1NewWorld = new ArrayList<>();
    private List<Boolean> bools2OldWorld = new ArrayList<>();
    private List<Boolean> bools2NewWorld = new ArrayList<>();
    private List<Cell> cellWorldOld = new ArrayList<>();
    private List<Cell> cellWorldNew = new ArrayList<>();

    @Autowired
    private WorldService service;

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

        booleanNewWorld.add(bools1NewWorld);
        booleanNewWorld.add(bools2NewWorld);
    }

    @Test
    public void createWorld_ShouldReturn_AllFalse() throws Exception {
        assertThat(service.getNewWorld(booleanWorld)).isEqualTo(booleanNewWorld);
    }
}
