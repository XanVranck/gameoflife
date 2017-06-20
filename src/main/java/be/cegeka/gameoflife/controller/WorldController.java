package be.cegeka.gameoflife.controller;

import be.cegeka.gameoflife.world.WorldService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/gameoflife")
public class WorldController {

    @Autowired
    private WorldService service;

    private static Logger logger = Logger.getLogger(WorldController.class);

    @RequestMapping(value = "/world", method = POST)
    @ResponseBody
    public List<List<Boolean>> getWorld(@RequestBody List<List<Boolean>> currentWorld) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(5);
        return service.getNewWorld(currentWorld);
    }

}
