package gradle.cucumber;

import java.util.List;

public interface Power {

    public String identity();

    void putBomb(Cell currentCell, List<Bomb> bomb, Casillero casillero, Integer i);

    void jumpWall(Casillero casillero, Bomberman bomberman);

    void throwBomb(Bomb bomb, int i, Bomberman bomberman, Casillero casillero);

}
