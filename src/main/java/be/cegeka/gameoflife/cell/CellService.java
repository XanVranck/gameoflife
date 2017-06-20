package be.cegeka.gameoflife.cell;

import be.cegeka.gameoflife.world.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CellService {
    @Autowired
    private CellRulesApplier cellRulesApplier;

    public boolean cellLives(World world, Cell cell){
        return cellRulesApplier.doesCellLive(world, cell);
    }
}
