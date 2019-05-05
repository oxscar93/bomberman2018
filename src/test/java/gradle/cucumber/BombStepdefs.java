package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class BombStepdefs {

    private Bomb bomb;
    private Wall melaninWall;
    private Casillero casillero;
    private Enemy enemigo;

    @Given("^As a bomb with a time of 3 seconds")
    public void as_a_bomb_with_3_seconds() throws Throwable {
        this.bomb = new Bomb(3);
        this.bomb.setCell( new Cell(this.bomb, 0));
    }

    @When("^it explodes and there are melanin walls$")
    public void it_explode_and_there_are_melanin_walls() throws Throwable {

        List<Cell> cells = new ArrayList<Cell>();

        cells.add(new Cell(new Melanin(), 1));
        cells.add(new Cell(new Melanin(), 2));
        cells.add(new Cell(new Melanin(),3));

        this.casillero= new Casillero(cells);

        this.bomb.explode(this.casillero);
    }

    @Then("^destroy 3 walls of melanin$")
    public void destroy_3_walls_of_melanin() throws Throwable {
        for (Cell cell : casillero.getCells()) {
            Assert.assertTrue(cell.getContent().getStatus().isDestroyed());
        }
    }

    //   Scenario: A bomb is lauched with a time of 3 second and destroy an enemy

    @When("^it explodes and there is an enemy$")
    public void it_explode_and_there_is_an_enemy() throws Throwable {
        List<Cell> cells = new ArrayList<Cell>();
        this.enemigo = new ProtoMaxJr();
        Cell celda = new Cell(this.enemigo,2);
        this.enemigo.setCell(celda);
        cells.add(new Cell(this.enemigo,2));

        this.casillero = new Casillero(cells);

        this.bomb.explode(this.casillero);
    }

    @Then("^kill the enemy by the blast  wave$")
    public void kill_the_enemy_by_the_blast_waves() throws Throwable {
            Assert.assertTrue(this.casillero.getCells().get(0).getContent().getStatus().isDestroyed());

    }

    //   Scenario: A bomb is lauched with a time of 3 second and there is a metal wall

    @When("^it explodes and there are metal walls$")
    public void it_explode_and_there_are_metal_walls() throws Throwable {
        List<Cell> cells = new ArrayList<Cell>();

        cells.add(new Cell(new Metal(),2));

        this.casillero = new Casillero(cells);

        this.bomb.explode(this.casillero);
    }

    @Then("^it does not destroy the metal wall$")
    public void it_does_not_destroy_the_metal_walls() throws Throwable {
        Assert.assertFalse(this.casillero.getCells().get(0).getContent().getStatus().isDestroyed());

    }

}
