package object;

public class Rock extends Entity {
    private char entityRock;

    public char getEntityRock() {
        return entityRock;
    }
    public Rock(String name){super(name);}
    public Rock(char rock, String name){
        super(name);
        entityRock = rock;
    }
}
