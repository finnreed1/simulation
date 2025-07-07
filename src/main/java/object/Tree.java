package object;

public class Tree extends Entity {
    private char entityTree;

    public char getEntityTree() {
        return entityTree;
    }
    public Tree(String name){ super(name); }

    public Tree(char tree, String name){
        super(name);
        entityTree = tree;
    }
}
