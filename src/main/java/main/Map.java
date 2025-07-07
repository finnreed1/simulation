package main;

import object.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Map {
    private int height = 10;
    private int width = 15;
    private HashMap<Cell, Entity> map = new HashMap<Cell, Entity>();
    private List<Cell> herbivorePosition = new ArrayList<>();
    private List<Cell> predatorPosition = new ArrayList<>();
    private List<Cell> grassPosition = new ArrayList<>();

    public List<Cell> getGrassPosition() { return grassPosition; }
    public List<Cell> getHerbivorePosition() { return herbivorePosition; }
    public List<Cell> getPredatorPosition() { return predatorPosition; }
    public int getHeight() { return height; }
    public int getWidth() { return width; }
    public HashMap<Cell, Entity> getMap() { return map; }

    public void inicilizationInside(){
        // размещение травоядных, количество 3;
        int cntHerbivore = 0; int cntPredator = 0; int cntTree = 0; int cntRock = 0; int cntGrass = 0;
        int cntObjects = 2;
        while (cntHerbivore < cntObjects || cntPredator < cntObjects || cntTree < cntObjects || cntRock < cntObjects || cntGrass < cntObjects){
            Random rnd = new Random();
            int i = rnd.nextInt(height);
            int j = rnd.nextInt(width);
            Cell cell = new Cell(i, j);
            if (!map.containsKey(cell)) {
                if (cntHerbivore < cntObjects) {
                    Entity ent = new Herbivore(100, 1, "H");
                    map.put(cell, ent);
                    herbivorePosition.add(cell);
                    cntHerbivore++;
                } else if (cntPredator < cntObjects) {
                    Entity ent = new Predator(100, 1, 50, "P");
                    map.put(cell, ent);
                    predatorPosition.add(cell);
                    cntPredator++;
                } else if (cntTree < cntObjects) {
                    Entity ent = new Tree("T");
                    map.put(cell, ent);
                    cntTree++;
                } else if (cntRock < cntObjects) {
                    Entity ent = new Rock("R");
                    map.put(cell, ent);
                    cntRock++;
                } else if (cntGrass < cntObjects) {
                    Entity ent = new Grass("G");
                    map.put(cell, ent);
                    grassPosition.add(cell);
                    cntGrass++;
                }
            }
        }
    }
    // рендерер: переместить в главный класс приложения;
    public void inicilizationOutside(){
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                Cell cell = new Cell(i, j);
                if (map.containsKey(cell))
                { System.out.print(map.get(cell).getName()); }
                else { System.out.print("."); }
            }
            System.out.println();
        }
        System.out.println();
    }
}