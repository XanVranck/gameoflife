package be.cegeka.gameoflife.World;

import be.cegeka.gameoflife.cell.Cell;

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

    //TODO: col begint vanaf 0 --> max = 2, terwijl dit 3 moet terug geven
    public OptionalInt getMaxCol(){
        return this.grid.stream().mapToInt(Cell::getCol).max();
    }

    //TODO: col begint vanaf 0 --> max = 2, terwijl dit 3 moet terug geven
    public OptionalInt getMaxRow(){
        return this.grid.stream().mapToInt(Cell::getRow).max();
    }
}
