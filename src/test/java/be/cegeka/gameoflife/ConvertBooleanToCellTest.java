package be.cegeka.gameoflife;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by xanv on 17/06/2017.
 */
public class ConvertBooleanToCellTest {
    private List<List<Boolean>> booleanWorld = new ArrayList<>();
    private List<Boolean> bools1 = new ArrayList<>();
    private List<Boolean> bools2 = new ArrayList<>();
    private List<Cell> cellWorld = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        Cell cellTrue = new Cell(true, 0, 0);
        Cell cellFalse = new Cell(false, 0, 1);
        Cell cellFalse2 = new Cell(false, 1, 0);
        Cell cellFalse3 = new Cell(false, 1, 1);

        bools1.add(true);
        bools1.add(false);
        bools2.add(false);
        bools2.add(false);

        cellWorld.add(cellTrue);
        cellWorld.add(cellFalse);
        cellWorld.add(cellFalse2);
        cellWorld.add(cellFalse3);

        booleanWorld.add(bools1);
        booleanWorld.add(bools2);
    }

    @Test
    public void convertBooleanToCell() throws Exception {
        assertThat(ConvertBooleanToCell.convertBooleanToCell(booleanWorld)).isEqualTo(cellWorld);
    }

}