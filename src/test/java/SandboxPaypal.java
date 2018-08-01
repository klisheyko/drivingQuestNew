import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SandboxPaypal {

    protected WebDriver driver;
    private static final org.apache.log4j.Logger log = LogManager.getRootLogger();
    Authorization authorization = new  Authorization(driver);


    public SandboxPaypal(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    By emailOfUserRealPatPalLocator = By.xpath("//input[@id='email']");
    By passwordOfReaLPayPalLocator = By.xpath("//input[@id='password']");
    By clickLoginPayPalUserLocator = By.xpath("//button[@id='btnLogin']");
    By clickPayNowPayPalLocator = By.cssSelector("#button");
    By buttonNEXTPayPalLocator = By.xpath("//button[@id='btnNext']");

    public ContractOfRegistration payThroughPayPalForRegistrationOfANewStudent(WebDriver driver)  {

        WebElement emailOfUserRealPatPal = driver.findElement(emailOfUserRealPatPalLocator);
        emailOfUserRealPatPal.clear();
        emailOfUserRealPatPal.sendKeys(authorization.getEmailOfUserRealPatPal());

        WebElement buttonNEXTPayPal = driver.findElement(buttonNEXTPayPalLocator);
        buttonNEXTPayPal.click();

        WebElement passwordOfReaLPayPal = driver.findElement(passwordOfReaLPayPalLocator);
        passwordOfReaLPayPal.sendKeys(authorization.getPasswordOfReaLPayPal());

        driver.findElement(clickLoginPayPalUserLocator).click();


        clickPayNowPayPal(driver);
        return new ContractOfRegistration(driver);
    }

    public boolean clickPayNowPayPal(WebDriver driver) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 6) {
            try {
                if (clickPayNowPayPalLocator != null ) {
                    driver.findElement(clickPayNowPayPalLocator).click();
                    result = true;
                    break;
                }
            } catch ( RuntimeException e ) {
            }
            attempts++;
        }
        return result;
    }
}
