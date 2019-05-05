package gradle.cucumber;

public abstract class Enemy extends Included {

    protected ContentStatus status;

    public Enemy(){
        this.status = new Fine();
    }

    @Override
    public abstract void changeStatus(Bomberman bomberman);

    @Override
    public abstract boolean isEmpty();

    @Override
    public abstract void destroy();

    @Override
    public abstract ContentStatus getStatus();

    public abstract void setCell(Cell cell);

    public boolean isDead() {
        return this.getStatus().isDestroyed();
    }
}
