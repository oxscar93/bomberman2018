package gradle.cucumber;

public class Destroyed extends ContentStatus {
    @Override
    public Boolean isDestroyed() {
        return true;
    }

    @Override
    public Boolean isFine() {
        return false;
    }
}
