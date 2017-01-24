package skeleton;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class Stepdefs {

    private Solution solution = new Solution();

    @Given("^Astronauts (\\d+) and (\\d+) from the same country$")
    public void astronauts_and_from_the_same_country(int firstAstronaut, int secondAstronaut) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //   throw new PendingException();
        solution.addPairFromTheSameCountry(firstAstronaut, secondAstronaut);
    }

    @Given("^(\\d+) astronauts$")
    public void astronauts(int numberOfAllAstronauts) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        solution.setNumberOfAllAstronauts(numberOfAllAstronauts);
    }

    @When("^compute in how many ways they can pick a pair of astronauts belonging to different countries$")
    public void compute_in_how_many_ways_they_can_pick_a_pair_of_astronauts_belonging_to_different_countries() throws Throwable {
        // run algorithms
        solution.computeSolution();
    }

    @Then("^Found (\\d+) ways$")
    public void found_ways(int ways_as_solution) throws Throwable {
        long result = solution.getResult();
        assertEquals(ways_as_solution, result);
    }

}
