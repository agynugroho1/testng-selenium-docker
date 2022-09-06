package booking.flights.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import tests.BaseTest;

public class BookingFlightTest extends BaseTest {

    private String noOfPassangers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassangers", "expectedPrice"})
    public void setupParameters(String noOfPassangers, String expectedPrice){
        this.noOfPassangers = noOfPassangers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void regisPageTest(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterUserCredentials("selenium", "docker");
        registrationPage.submitButton();
    }

    @Test(dependsOnMethods = "regisPageTest")
    public void regisConfirmTest(){
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "regisConfirmTest")
    public void flightDetailsTest(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassangers(noOfPassangers);
        flightDetailsPage.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsTest")
    public void finfFlightTest(){
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.submitFindFlightPage();
        findFlightPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "finfFlightTest")
    public void flightConfrimTest(){
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.getPrices();
        Assert.assertEquals(actualPrice, expectedPrice);
    }
}
