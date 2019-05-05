package gradle.cucumber;

import java.util.List;

public class ThrowSeveralBomb extends Included implements Power{
    @Override
    public String identity() {
        return "ThrowSeveralBomb";
    }

    @Override
    public void putBomb(Cell currentCell, List<Bomb> bomb, Casillero casillero, Integer i) {
        int ind = 0;

        for (Cell c : casillero.getCells()) {
            c.setContent(bomb.get(ind));
            ind++;
        }
    }

    @Override
    public void jumpWall(Casillero casillero, Bomberman bomberman) {

    }

    @Override
    public void throwBomb(Bomb bomb, int i, Bomberman bomberman, Casillero casillero) {

    }

    @Override
    public void changeStatus(Bomberman bomberman) {
        bomberman.addPower(this);
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
