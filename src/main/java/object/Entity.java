package object;

public abstract class Entity {
    private String name;
    public Entity(){}
    public Entity(String name) { this.name = name; }
    public String getName() { return name; }
}
