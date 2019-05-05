package gradle.cucumber;

public class Metal extends Wall {
    public Metal(){

    }

    @Override
    public void destroy() {
        this.status = new Fine();
    }
}
