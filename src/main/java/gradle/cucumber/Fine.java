package gradle.cucumber;

public class Fine extends ContentStatus {
    @Override
    public Boolean isDestroyed() {
        return false;
    }

    @Override
    public Boolean isFine() {
        return true;
    }
}
