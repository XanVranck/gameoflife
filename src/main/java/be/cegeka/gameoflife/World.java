package be.cegeka.gameoflife;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class World {
    private List<Cell> grid = new ArrayList<>();

    public World(List<Cell> grid) {
        this.grid = grid;
    }

    public List<Cell> getGrid() {
        return grid;
    }

    public Optional<Cell> getCell(int row, int col){
        return this.grid.stream().filter(cell -> cell.getRow() == row && cell.getCol() == col).findFirst();
    }

    public OptionalInt getMaxCol(){
        return this.grid.stream().mapToInt(Cell::getCol).max();
    }

    public OptionalInt getMaxRow(){
        return this.grid.stream().mapToInt(Cell::getRow).max();
    }
}
