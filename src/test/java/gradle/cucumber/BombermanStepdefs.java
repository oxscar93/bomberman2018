package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;


public class BombermanStepdefs {

    private Bomberman bomberman;
    private Cell cell;
    private Included enemy;

    //   Scenario: Bomberman can move to empty cell

    @Given("^As a bomberman")
    public void as_a_bomberman() throws Throwable {
        this.bomberman = new Bomberman();
    }

    @When("^I see an empty cell$")
    public void i_see_empty_cell() throws Throwable {
        this.cell = new Cell(new EmptyContent());
    }

    @Then("^I can move to that cell$")
    public void i_can_move_cell() throws Throwable {
        assertTrue(this.bomberman.canMove(this.cell));
    }

    //     Scenario: Bomberman can't move to cell with a wall

    @When("^I see a cell with a wall$")
    public void iSeeACellWithAWall() throws Throwable {
        this.cell = new Cell(new Wall());
    }

    @Then("^I can't move to that cell$")
    public void iCanTMoveToThatCell() throws Throwable {
        assertFalse(this.bomberman.canMove(this.cell));
    }

    // Scenario: Bomberman dies when he tries to move to a cell with an enemy

    @When("^I see a cell with an enemy$")
    public void iMoveToACellWithAnEnemy() throws Throwable {
        this.cell = new Cell(new ProtoMaxJr());
        this.bomberman.move(this.cell);
    }

    @Then("^I die$")
    public void bombermanDies() throws Throwable {
       assertTrue(this.bomberman.isDead());
    }

    @When("^I move to that cell$")
    public void iMoveToThatCell() throws Throwable {
       this.bomberman.move(this.cell);
    }

    @Then("^bomberman is in an empty cell$")
    public void bombermanIsInAnEmptyCell() throws Throwable {
        assertTrue(this.bomberman.isInAnEmptyCell());
    }

    @When("^I see a cell with a power$")
    public void iSeeACellWithAPower() throws Throwable {
        this.cell = new Cell(new ThrowBomb());
    }

    @Then("^I get the power$")
    public void iGetThePower() throws Throwable {
        assertTrue(this.bomberman.powerIncluded(new ThrowBomb()));
    }
}
