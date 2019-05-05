package gradle.cucumber;

import java.util.ArrayList;
import java.util.List;

public class Casillero {

    private List<Cell> cells;

    public Casillero(List<Cell> cells){
        this.cells = cells;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public Cell getCellByDistance(int distance){
        return this.cells.get(distance - 1);
    }
}
