package gradle.cucumber;

import java.util.List;

public class JumpAndThrow extends Included implements Power {
    @Override
    public String identity() {
        return "JumpAndThrow";
    }

    @Override
    public void putBomb(Cell currentCell, List<Bomb> bomb, Casillero casillero, Integer i) {
       new ThrowSeveralBomb().putBomb(currentCell, bomb, casillero, i );
    }

    @Override
    public void jumpWall(Casillero casillero, Bomberman bomberman) {
        new JumpWall().jumpWall(casillero, bomberman);
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
