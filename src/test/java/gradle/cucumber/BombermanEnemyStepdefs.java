package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;


public class BombermanEnemyStepdefs {

    private Bomberman bomberman;
    private Bomb bomb;
    private Bomb bomb2;
    private Bagulaa bagulaa;
    private ProtoMaxJr protoMaxJr;
    private ProtoMaxUnits protoMaxUnits;
    private Casillero casillero;
    private Casillero casillero2;
    private Cell celda0;
    private Cell celda1;
    private Cell celda2;
    private Cell celda3;
    private Cell celda4;
    private Cell celda5;
    private ThrowBomb throwBombP;
    private JumpWall jumpWall;
    private ThrowSeveralBomb manyBombs;
    private List<Bomb> bombs;
    private ArrayList<Cell> cells;

    @Given("^a Bomberman that leaves a bomb$")
    public void a_bomberman_that_leaves_a_bomb() throws Throwable {

        this.bomberman = new Bomberman();
        this.bomb = new Bomb(3);
        this.celda0 = new Cell(new EmptyContent(), 0);
        this.celda1 = new Cell(new EmptyContent(), 1);
        this.celda2 = new Cell(new EmptyContent(), 2);

        this.bomberman.setCell(celda0);

        List<Cell> cells = new ArrayList<Cell>();
        cells.add(celda0);
        cells.add(celda1);
        cells.add(celda2);

        this.casillero = new Casillero(cells);
        ArrayList<Bomb> bombs= new ArrayList<Bomb>();
        bombs.add(bomb);

        this.bomberman.putBomb(bombs, 0, this.casillero);
    }

    @When("^bagulaa is near and the bomb explodes$")
    public void bagulaa_is_near_and_the_bomb_explodes() throws Throwable {
        this.bagulaa = new Bagulaa();
        this.bagulaa.setCell(this.celda1);
        celda1.setContent(bagulaa);
        this.bomb.explode(this.casillero);
    }

    @Then("^bagulaa dies and Bomberman gets the power to throw bombs$")
    public void bagulaa_dies_and_bomberman_gets_power_throw_bombs() throws Throwable {
        this.bomberman.move(this.celda1);
        assertTrue(this.bagulaa.isDead());
        assertTrue(this.bomberman.getPowers().identity() == "ThrowBomb");
    }

    @Given("^a bomberman$")
    public void aBomberman() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.bomberman = new Bomberman();
    }

    @When("^a bomberman gets the power to throw bomb$")
    public void aBombermanGetsThePowerToThrowBomb() throws Throwable {

        this.celda0 = new Cell(new EmptyContent(), 0);
        this.celda1 = new Cell(new EmptyContent(), 1);
        this.celda2 = new Cell(new Melanin(), 2);
        this.celda3 = new Cell(new EmptyContent(), 3);
        this.celda4 = new Cell(new EmptyContent(), 4);
        this.celda5 = new Cell(new EmptyContent(), 5);

        List<Cell> cells = new ArrayList<Cell>();
        cells.add(celda0);
        cells.add(celda1);
        cells.add(celda2);
        cells.add(celda3);
        cells.add(celda4);
        cells.add(celda5);

        this.bomberman.setCell(celda0);
        this.bomb2 = new Bomb(3);

        this.casillero = new Casillero(cells);
        this.bomberman.addPower(new ThrowBomb());
    }

    @Then("^the bomberman throws the bomb (\\d+) squares from his position and destroys a wall of melanin$")
    public void the_bomberman_throws_the_bomb_squares_from_his_position_and_destroys_a_wall_of_melanin(int pos) throws Throwable {
        this.bomberman.getPowers().throwBomb(this.bomb2,pos, bomberman,casillero);
        assertTrue(bomb2.cell.position == 2);
        assertTrue(this.casillero.getCells().get(2).getContent().getStatus().isFine());
        this.bomb2.explode(casillero);
        assertTrue(this.casillero.getCells().get(2).getContent().getStatus().isDestroyed());
    }

    @When("^proto Max Jr is near and the bomb explodes$")
    public void proto_max_jr_is_near_and_the_bomb_explodes() throws Throwable {
        this.protoMaxJr = new ProtoMaxJr();
        this.protoMaxJr.setCell(this.celda1);
        celda1.setContent(protoMaxJr);
        this.bomb.explode(this.casillero);
    }


    @Then("^proto Max Jr dies and Bomberman gets the power to jump walls$")
    public void proto_max_jr_dies_and_Bomberman_gets_the_power_to_jump_walls() throws Throwable {
        this.bomberman.move(this.celda1);
        assertTrue(this.protoMaxJr.isDead());
        assertTrue(this.bomberman.getPowers().identity() == "JumpWall");
    }


    @When("^proto Max Units is near and the bomb explodes$")
    public void proto_Max_Units_is_near_and_the_bomb_explodes() throws Throwable {
        this.protoMaxUnits = new ProtoMaxUnits();
        this.protoMaxUnits.setCell(this.celda1);
        this.celda1.setContent(this.protoMaxUnits);
        this.bomb.explode(this.casillero);
    }

    @Then("^proto Max Units dies and Bomberman gets power to jump walls or throw several bombs at the same time$")
    public void proto_max_units_dies_and_Bomberman_gets_power_to_jump_walls_or_throw_several_bombs_at_the_same_time() throws Throwable {
        this.bomberman.move(this.celda1);
        assertTrue(this.protoMaxUnits.isDead());
        assertTrue(this.bomberman.getPowers().identity() == "ThrowSeveralBomb");
    }


    @When("^a bomberman gets the power to jump walls$")
    public void aBombermanGetsThePowerToJumpWalls() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Wall melanin = new Melanin();
        Wall metal = new Metal();

        this.celda0 = new Cell(metal, 0);
        this.celda1 = new Cell(melanin, 1);
        this.celda2 = new Cell(new EmptyContent(), 2);

        List<Cell> cells = new ArrayList<Cell>();
        cells.add(celda0);
        cells.add(celda1);
        cells.add(celda2);

        this.casillero = new Casillero(cells);
        this.bomberman.addPower(new JumpWall());
        this.bomberman.getPowers().jumpWall(casillero,this.bomberman);
    }

    @Then("^a bomberman jumps (\\d+) locker with a wall$")
    public void aBombermanJumpsLockerWithAWall(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(this.bomberman.getCell().isEmpty());
    }

    @When("^a bomberman gets the power to throw several bombs$")
    public void aBombermanGetsThePowerToThrowSeveralBombs() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Wall melanin = new Melanin();
        Wall metal = new Metal();

        this.celda0 = new Cell(metal, 0);
        this.celda1 = new Cell(melanin, 1);
        this.celda2 = new Cell(new EmptyContent(), 2);

        Bomb bomb0 = new Bomb(3);
        Bomb bomb1 = new Bomb(3);

        this.bombs = new ArrayList<>();
        bombs.add(bomb0);
        bombs.add(bomb1);

        this.cells = new ArrayList<Cell>();
        cells.add(celda0);
        cells.add(celda1);

        this.casillero = new Casillero(cells);

        this.bomberman.addPower(new ThrowSeveralBomb());
        this.bomberman.getPowers().putBomb(this.bomberman.getCell(),bombs,casillero,2);
    }

    @Then("^a bomberman throws (\\d+) bombs simultaneously$")
    public void aBombermanThrowsBombsSimultaneously(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(this.cells.get(0).getContent().isABomb());
        assertTrue(this.cells.get(1).getContent().isABomb());
    }
}
