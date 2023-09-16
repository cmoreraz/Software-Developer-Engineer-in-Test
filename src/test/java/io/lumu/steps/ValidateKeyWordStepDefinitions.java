package io.lumu.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.lumu.tasks.EnterTextField;
import io.lumu.tasks.KeywordDensity;
import io.lumu.tasks.LeftCount;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

import static io.lumu.tasks.LeftCount.count;

public class ValidateKeyWordStepDefinitions {

    @When("{actor} fills the text field {string}")
    public static void fillsTextField(Actor actor, String value){
        actor.attemptsTo(
                EnterTextField.enterField(value)
        );
    }

    @And("{actor} validate number of words and characters")
    public static void numberWordsAndCharacters(Actor actor){
        actor.attemptsTo(
                count()
        );
    }

    @Then("{actor} validate the 3 most repeated words with the number of repetitions")
    public static void validateMostRepeatedWords(Actor actor){
        actor.attemptsTo(
                KeywordDensity.density()
        );
    }
}
