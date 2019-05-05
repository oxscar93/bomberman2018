package gradle.cucumber;

import java.util.List;

public class JumpWall extends Included implements Power{
    @Override
    public String identity() {
        return "JumpWall";
    }

    @Override
    public void putBomb(Cell currentCell, List<Bomb> bomb, Casillero casillero, Integer i) {

    }

    @Override
    public void jumpWall(Casillero casillero, Bomberman bomberman) {
        for (Cell c : casillero.getCells()) {
            if (c.getContent().isEmpty()){
                bomberman.move(c);
                break;
            }
        }
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
