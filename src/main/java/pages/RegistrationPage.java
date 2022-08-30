package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstNameField;

    @FindBy(name = "lastName")
    private WebElement lastNameField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(name = "register")
    private WebElement buttonRegister;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameField));
    }

    public void enterUserDetails(String firstName, String lastName){
        this.firstNameField.sendKeys(firstName);
        this.firstNameField.sendKeys(lastName);
    }

    public void enterUserCredentials(String username, String password){
        this.emailField.sendKeys(username);
        this.passwordField.sendKeys(password);
        this.confirmPasswordField.sendKeys(password);
    }

    public void submitButton(){
        this.buttonRegister.click();
    }
}
