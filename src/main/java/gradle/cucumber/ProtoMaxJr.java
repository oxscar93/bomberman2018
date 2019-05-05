package gradle.cucumber;

public class ProtoMaxJr extends Enemy{

    public ProtoMaxJr(){
        this.status = new Fine();
    }

    @Override
    public void changeStatus(Bomberman bomberman) {

        bomberman.setStatus(new Die());
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void destroy() {

        this.status = new Destroyed();
        this.cell.setContent(new JumpWall());
    }

    @Override
    public ContentStatus getStatus() {
        return this.status;
    }

    @Override
    public boolean isABomb() {
        return false;
    }

    @Override
    public void setCell(Cell cell) {

        this.cell = cell;
    }
}
