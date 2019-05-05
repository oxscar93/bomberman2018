package gradle.cucumber;

import java.util.ArrayList;
import java.util.List;

public class Bomberman {

    public Cell currentCell;
    public Status status;
    private Power power;

    public Bomberman(){
        this.status = new Alive();
        this.power = new DefaultPower();
    }

    public boolean canMove(Cell cell) {
        return cell.isEmpty();
    }

    public void move(Cell cell){
        this.currentCell = cell;
        this.updateStatus();
    }

    private void updateStatus(){

        this.currentCell.getContent().changeStatus(this);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean isDead(){
        return this.status.isDead();
    }

    public boolean isInAnEmptyCell() {
        return this.currentCell.isEmpty();
    }

    public void setCell(Cell cell) { this.currentCell = cell; }

    public void putBomb(ArrayList<Bomb> bombs, int i, Casillero casillero ) {
        this.power.putBomb(this.currentCell, bombs, casillero, 0);
    }

    public void addPower(Power power) {

        this.power = power;
    }

    public boolean powerIncluded(Power power) {
       /*TODO mejorar busqueda*/
        return true;
    }

    public Power getPowers() {
        return power;
    }

    public Cell getCell() {
        return this.currentCell;
    }
}
