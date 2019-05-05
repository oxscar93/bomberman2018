package gradle.cucumber;

public class Wall extends Included{

    ContentStatus status = new Fine();

    @Override
    public void changeStatus(Bomberman bomberman) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public void destroy() { this.status = new Destroyed();
    }


    public ContentStatus getStatus() {
        return status;
    }

    @Override
    public boolean isABomb() {
        return false;
    }

    public void setStatus(ContentStatus status) {
        this.status = status;
    }
}
