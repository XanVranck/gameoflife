package be.cegeka.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Cell> grid = new ArrayList<>();

    public World(List<Cell> grid) {
        this.grid = grid;
    }

    public List<Cell> getGrid() {
        return grid;
    }
}
