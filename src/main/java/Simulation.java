import main.Map;
import object.Cell;
import object.Creature;
import object.Entity;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    public static void main(String[] args) {
        Map simulation = new Map();
        simulation.inicilizationInside();
        simulation.inicilizationOutside();
        int tries = 1;
        while (!simulation.getHerbivorePosition().isEmpty()){
            move(simulation);
            simulation.inicilizationOutside();
            System.out.println("Ход номер " + tries++);
        }
    }

    public static void move(Map map) {
        List<Cell> initialPredators = new ArrayList<>(map.getPredatorPosition());
        List<Cell> initialHerbivores = new ArrayList<>(map.getHerbivorePosition());

        for (Cell cell : initialPredators) {
            Entity entity = map.getMap().get(cell);
            if (entity instanceof Creature creature && "P".equals(entity.getName())) {
                creature.makeMove(cell, map);
            }
        }

        for (Cell cell : initialHerbivores) {
            Entity entity = map.getMap().get(cell);
            if (entity instanceof Creature creature && "H".equals(entity.getName())) {
                creature.makeMove(cell, map);
            }
        }
    }
}
