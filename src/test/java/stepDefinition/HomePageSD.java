package stepDefinition;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import runnerTest.webPage.HomePage;
import util.BasePage;

public class HomePageSD {

    private HomePage homePage= new HomePage();

    @Given("^I am on Darksky HomePage$")

     public void verifyTitle(){
        Assert.assertEquals(BasePage.get().getTitle(),"Dark Sky - Broadway, New York, NY");
    }
    @When("^I click on today area on homepage$")
        public void clickToday(){
        homePage.temperature();
        }
    @And("^I get temperatures on homepage$")
    public void getTemperature(){
        System.out.println(homePage.getTempList());
    }
    @And("^I get min temperatures on homepage$")
    public void getMinTemp(){
        System.out.println(homePage.minTemp());
    }
    @And("^I get max temperatures on homepage$")
    public void getMaxTemp(){
        System.out.println(homePage.maxTemp());
    }
    @Then("^I verify min temperature on homepage$")
    public void verifyminTemp(){
        boolean result = homePage.verifyMin() == homePage.minTemp();
        Assert.assertFalse("Different values", result);
    }
    @Then("^I verify max temperature on homepage$")
    public void verifyMaxTemp(){
        Assert.assertEquals(homePage.verifyMax(),homePage.maxTemp());
    }
}

