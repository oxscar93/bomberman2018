package gradle.cucumber;

public class EmptyContent extends Included {
    @Override
    public void changeStatus(Bomberman bomberman) {

    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public void destroy() {

    }

    @Override
    public ContentStatus getStatus() {
       return this.status;
    }

    @Override
    public boolean isABomb() {
        return false;
    }
}
