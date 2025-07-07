package util;

import main.Map;
import object.Cell;

import java.util.ArrayList;
import java.util.List;

public class Pathfinding {
    public static Cell findNextCell(Cell cellStart, Map mp, List<Cell> list) {
        // reverse: cellEnd -> cellStart;
        List<Cell> previosLayer = new ArrayList<Cell>();
        List<Cell> currentLayer = new ArrayList<Cell>();
        Cell cellEnd = findNearestCell(mp, cellStart, list);
        currentLayer.add(cellEnd);
        while(!currentLayer.contains(cellStart)){
            List<Cell> nextLayer = new ArrayList<>();
            for(Cell c : currentLayer){
                for (Cell nextcell : moves(c)) {
                    if (newcellCheck(mp.getHeight(), mp.getWidth(), nextcell.getX(), nextcell.getY())) {
                        if (!newcellCheckObject(mp, nextcell)) {
                            if (!previosLayer.contains(nextcell)) {
                                nextLayer.add(nextcell);
                            }
                        }
                        else {
                            if (newcellCheckEnd(nextcell, cellStart)) {
                                return c;
                            }
                        }
                    }
                }
            }
            previosLayer = currentLayer;
            currentLayer = nextLayer;
        }
        return cellStart;
    }

    public static int findLengthPath(Map mp, Cell cellStart, Cell cellEnd){
        int count = 0;
        List<Cell> previosLayer = new ArrayList<Cell>();
        List<Cell> currentLayer = new ArrayList<Cell>();
        currentLayer.add(cellStart);
        while(!currentLayer.contains(cellEnd)){
            List<Cell> nextLayer = new ArrayList<>();
            for(Cell c : currentLayer){
                for (Cell nextcell : moves(c)) {
                    if (newcellCheck(mp.getHeight(), mp.getWidth(), nextcell.getX(), nextcell.getY())) {
                        if (!newcellCheckObject(mp, nextcell)) {
                            if (!previosLayer.contains(nextcell)) {
                                nextLayer.add(nextcell);
                            }
                        }
                        else {
                            if (newcellCheckEnd(nextcell, cellEnd)) {
                                nextLayer.add(nextcell);
                            }
                        }
                    }
                }
            }
            previosLayer = currentLayer;
            currentLayer = nextLayer;
            count++;
        }
        return count;
    }

    public static Cell findNearestCell(Map mp, Cell cellStart, List<Cell> list){
        Cell result = cellStart;
        int minCount = mp.getHeight() * mp.getWidth();
        for (Cell cellEnd : list) {
            int count = findLengthPath(mp, cellStart, cellEnd);
            if (count < minCount){
                result = cellEnd;
                minCount = count;
            }
        }
        return result;
    }
    private static boolean newcellCheckObject(Map mp, Cell nextCell){
        return mp.getMap().containsKey(nextCell);
    }

    private static boolean newcellCheckEnd(Cell nextCell, Cell cellEnd){
        return (nextCell.getX() == cellEnd.getX() && nextCell.getY() == cellEnd.getY());

    }
    private static boolean newcellCheck(int heigth, int width, int x, int y){
        boolean flag = false;
        if (x >= 0 && y >= 0) {
            if (x < heigth && y < width) {
                flag = true;
            }
        }
        return flag;
    }
    private static Cell[] moves(Cell cell){
        return new Cell[]{new Cell(cell.getX()+1, cell.getY()), new Cell(cell.getX(), cell.getY()+1),
                          new Cell(cell.getX()-1, cell.getY()), new Cell(cell.getX(), cell.getY()-1)};
    }
}
