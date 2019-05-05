package gradle.cucumber;

import java.util.List;

public class DefaultPower extends Included implements Power {
    @Override
    public String identity() {
        return null;
    }

    @Override
    public void putBomb(Cell currentCell, List<Bomb> bomb, Casillero casillero, Integer i) {
        Bomb b = bomb.get(0);
        currentCell.setContent(b);
        b.setCell(currentCell);
    }

    @Override
    public void jumpWall(Casillero casillero, Bomberman bomberman) {

    }

    @Override
    public void throwBomb(Bomb bomb, int i, Bomberman bomberman, Casillero casillero) {

    }

    @Override
    public void changeStatus(Bomberman bomberman) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void destroy() {

    }

    @Override
    public ContentStatus getStatus() {
        return null;
    }

    @Override
    public boolean isABomb() {
        return false;
    }
}
