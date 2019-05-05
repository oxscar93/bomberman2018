package gradle.cucumber;

public class Alive extends Status {
    @Override
    public Boolean isDead() {
        return false;
    }
}
