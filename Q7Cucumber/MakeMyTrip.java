package com.cucumber.makemytrip;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MakeMyTrip {

    private WebDriver driver;

    @Given("I am on the MakeMyTrip homepage")
    public void navigateToMakeMyTripHomepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
	  driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
    }

    @When("I select ROUND TROP")
    public void selectRoundTrip() {
        driver.findElement(By.xpath("//span[text()='Round Trip']").click();
    }

    @When("I enter {fromLocation} as the from location")
    public void enterFromLocation(String fromLocation) {
        driver.findElement(By.id("from_typeahead")).sendKeys(fromLocation);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[1]").click();
    }

    @When("I enter {toLocation} as the to location")
    public void enterToLocation(String toLocation) {
        driver.findElement(By.id("to_typeahead")).sendKeys(toLocation);
        driver.findElement(By.xpath("//ul[@id='ui-id-2']/li[1]").click();
    }

    @When("I select a departure date")
    public void selectDepartureDate() {
        driver.findElement(By.id("dep_date")).click();
        driver.findElement(By.xpath("//a[@title='Today']").click();
    }

    @When("I select a return date")
    public void selectReturnDate() {
        driver.findElement(By.id("ret_date")).click();
        driver.findElement(By.xpath("//a[@title='Today + 7 Days']").click();
    }

    @When("I click on the search button")
    public void clickSearchButton() {
        driver.findElement(By.xpath("//button[text()='Search']").click();
    }

    @Then("I should see the search page displayed as expected")
    public void verifySearchPage() {
        Assert.assertEquals(driver.getTitle(), "Flight Search Results | Book Cheap Flights Online | MakeMyTrip.com");
    }

}
