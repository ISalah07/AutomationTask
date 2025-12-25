package StepDefinitions;

import Pages.HomePage;
import Utils.webActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class MainSteps extends webActions {


    public MainSteps() {
        super(Hooks.driver);
    }

    @Given("the user is on the Google homepage \\(https:\\/\\/www.google.com).")
    public void the_user_is_on_the_google_homepage_https_www_google_com() {
        new HomePage(Hooks.driver).openPage();
    }

    @When("the user Enters a search query, e.g., {string}")
    public void the_user_enters_a_search_query_e_g(String string) {
        new HomePage(Hooks.driver).searchFor("test automation");    }



    @When("Submit The Search")
    public void submitTheSearch() {
        new HomePage(Hooks.driver).submitSearch();
    }

    @Then("the user should see that the search results page")
    public void the_user_should_see_that_the_search_results_page() {
        new HomePage(Hooks.driver)
                .verifyCurrentUrl("test automation");
    }
    @Then("contains relevant results for the query.")
    public void contains_relevant_results_for_the_query() {
        new HomePage(Hooks.driver).verifySearchResults("test automation");
    }

}
