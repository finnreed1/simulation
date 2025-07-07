package object;

public class Grass extends Entity {
    private char entityGrass;

    public char getEntityGrass() {
        return entityGrass;
    }
    public Grass(String name){ super(name);}

    public Grass(char grass, String name){
        super(name);
        entityGrass = grass;
    }
}
