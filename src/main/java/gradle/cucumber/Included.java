package gradle.cucumber;

public abstract class Included {

    ContentStatus status = new Fine();

    public Cell cell;

    public abstract void changeStatus(Bomberman bomberman);

    public abstract boolean isEmpty();

    public abstract void destroy();

    public abstract ContentStatus getStatus();

    public abstract boolean isABomb();

}
