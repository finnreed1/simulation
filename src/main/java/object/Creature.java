package object;
import main.Map;

public abstract class Creature extends Entity {
    private int hp;
    private int speed;

    public int getHp() { return hp; }
    public int getSpeed() { return speed; }
    public void setHp(int hp) { this.hp = hp; }
    public void setSpeed(int speed) { this.speed = speed; }

    public Creature(int hp, int speed, String name) {
        super(name);
        this.hp = hp;
        this.speed = speed;
    }
    public abstract void makeMove(Cell cell, Map map);
}
