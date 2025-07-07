package object;

import main.Map;
import util.Pathfinding;

public class Herbivore extends Creature {
    public Herbivore(int hp, int speed, String name) {
        super(hp, speed, name);
    }

    @Override
    public void makeMove(Cell oldKey, Map map) {
        Cell newKey = Pathfinding.findNextCell(oldKey, map, map.getGrassPosition());
        if (map.getMap().containsKey(newKey)){
            if (map.getMap().get(newKey).getName() == "G"){
                if (getHp() <= 80){
                    int result = getHp() + 20;
                    setHp(result);
                }
                else {
                    setHp(100);
                }
                map.getGrassPosition().remove(newKey);
            }
        }
        if (map.getMap().containsKey(oldKey)) {
            Entity ent = map.getMap().get(oldKey);
            for (int i = 0; i < map.getHerbivorePosition().size(); i++) {
                if (map.getHerbivorePosition().get(i) == oldKey){
                    map.getHerbivorePosition().remove(i);
                    map.getHerbivorePosition().add(newKey);
                }
            }
            map.getMap().remove(oldKey);
            map.getMap().put(newKey, ent);
        }
    }
}
