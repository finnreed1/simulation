package object;

import main.Map;
import util.Pathfinding;

public class Predator extends Creature {
    private int damage;
    public Predator(int hp, int speed, int damage, String name) {
        super(hp, speed, name);
        this.damage = damage;
    }

    @Override
    public void makeMove(Cell oldKey, Map map) {
        Cell newKey = Pathfinding.findNextCell(oldKey, map, map.getHerbivorePosition());
        if (map.getMap().containsKey(newKey)) {
            Entity entity = map.getMap().get(newKey);
                if (entity instanceof Creature creature && entity.getName() == "H") {
                    if (creature.getHp() <= this.damage){
                        creature.setHp(0);
                        if (map.getMap().containsKey(oldKey)) {
                            Entity ent = map.getMap().get(oldKey);
                            for (int i = 0; i < map.getPredatorPosition().size(); i++) {
                                if (map.getPredatorPosition().get(i) == oldKey) {
                                    map.getPredatorPosition().remove(i);
                                    map.getPredatorPosition().add(newKey);
                                }
                            }
                            map.getHerbivorePosition().remove(newKey);
                            map.getMap().remove(oldKey);
                            map.getMap().put(newKey, ent);
                        }
                    }
                    else{
                        creature.setHp(creature.getHp() - this.damage);
                    }
            }
        }
        else {
            if (map.getMap().containsKey(oldKey)) {
                Entity ent = map.getMap().get(oldKey);
                for (int i = 0; i < map.getPredatorPosition().size(); i++) {
                    if (map.getPredatorPosition().get(i) == oldKey) {
                        map.getPredatorPosition().remove(i);
                        map.getPredatorPosition().add(newKey);
                    }
                }
                map.getMap().remove(oldKey);
                map.getMap().put(newKey, ent);
            }
        }
    }

}
