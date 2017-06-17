package be.cegeka.gameoflife;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CellTest {
    private Cell cell = new Cell(false, 1, 2);
    @Test
    public void isAlive() throws Exception {
        assertThat(cell.isAlive()).isEqualTo(false);
    }

    @Test
    public void getRow() throws Exception {
        assertThat(cell.getRow()).isEqualTo(1);
    }

    @Test
    public void getCol() throws Exception {
        assertThat(cell.getCol()).isEqualTo(2);
    }

    @Test
    public void setIsAlive() throws Exception {
        cell.setIsAlive(true);
        assertThat(cell.isAlive()).isEqualTo(true);
    }

}