package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightDetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "passCount")
    private WebElement passangerField;

    @FindBy(name = "findFlights")
    private WebElement submitBtn;

    public FlightDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void selectPassangers(String noOfPassanger){
        this.wait.until(ExpectedConditions.elementToBeClickable(passangerField));
        Select select = new Select(passangerField);
        select.selectByValue(noOfPassanger);
    }

    public void goToFindFlightsPage(){
        this.submitBtn.click();
    }
}
