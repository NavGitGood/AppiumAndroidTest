package org.appiumdemo.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.appiumdemo.screens.EmptyGlassScreen;
import org.appiumdemo.screens.LemonScreen;
import org.appiumdemo.screens.LemonTreeScreen;
import org.appiumdemo.screens.LemonadeScreen;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseSteps extends UIInteractionSteps {

    @Steps
    EmptyGlassScreen emptyGlassScreen;
    LemonTreeScreen lemonTreeScreen;
    LemonScreen lemonScreen;
    LemonadeScreen lemonadeScreen;

    @Then("I am on glass screen")
    public void iAmOnGlassScreen() {
        assertThat(emptyGlassScreen.isEmptyGlassDisplayed())
                .isTrue();
    }

    @When("I click on glass")
    public void iClickOnGlass() {
        emptyGlassScreen.clickEmptyGlass();
    }

    @When("I click on tree")
    public void iClickOnTree() {
        lemonTreeScreen.clickLemonTree();
    }

    @When("I click on lemon")
    public void iClickOnLemon() {
        lemonScreen.clickLemonFullSqueeze();
    }

    @When("I click on lemonade")
    public void iClickOnLemonade() {
        lemonadeScreen.clickLemonade();
    }

    @Given("I am on lemon tree screen")
    public void iAmOnLemonTreeScreen() {
        assertThat(lemonTreeScreen.isLemonTreeVisible())
                .isTrue();
    }

    @When("I click on lemon tree")
    public void iClickOnLemonTree() {
        lemonTreeScreen.clickLemonTree();
    }

    @Then("lemons should be available")
    public void lemonsShouldBeAvailable() {
        assertThat(lemonScreen.isLemonVisible())
                .isTrue();
    }

    @When("I click on lemon for full squeeze")
    public void iClickOnLemonForFullSqueeze() {
        lemonScreen.clickLemonFullSqueeze();
    }

    @Then("lemonade should be available")
    public void lemonadeShouldBeAvailable() {
        assertThat(lemonadeScreen.isLemonadeVisible())
                .isTrue();
    }

    @When("I click on lemonade to drink")
    public void iClickOnLemonadeToDrink() {
        lemonadeScreen.clickLemonade();
    }

    @Then("glass should be empty")
    public void glassShouldBeEmpty() {
        assertThat(emptyGlassScreen.isEmptyGlassDisplayed())
                .isTrue();
    }
}
