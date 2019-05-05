package gradle.cucumber;

public class Bomb extends Included {

    private int time;

    public Bomb(int ticks) {
        this.time = ticks;
    }

    public void explode(Casillero casillero) {
        Integer pos = cell.position;

        for (Cell cell : casillero.getCells()) {
            if ((cell.position - pos) <= 3){
                cell.getContent().destroy();
            }
        }
    }

    @Override
    public void changeStatus(Bomberman bomberman) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void destroy() {

    }

    @Override
    public ContentStatus getStatus() {
       return this.status;
    }

    public void setCell(Cell cell){
        this.cell = cell;
    }

    public boolean isABomb(){
        return true;
    }
}
