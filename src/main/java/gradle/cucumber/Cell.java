package gradle.cucumber;

public class Cell {
    public Included content;
    public Integer position;

    public Cell(Included content) {
        this.content = content;
    }

    public Cell(Included content, Integer position) {
        this.content = content;
        this.position = position;
    }

    public boolean isEmpty() {
        return this.content.isEmpty();
    }

    public void setContent(Included included) {
        this.content = included;
    }

    public Included getContent() {
        return this.content;
    }

    public boolean destroyContent() {
        return this.getContent().getStatus().isDestroyed();
    }
}
