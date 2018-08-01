import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistratioOfNewUser {

    private WebDriver driver;
    private static final org.apache.log4j.Logger log = LogManager.getRootLogger();
    public RegistratioOfNewUser(WebDriver driver) {
        this.driver = driver;
    }
    Authorization authorization = new  Authorization(driver);


    //LOCATORS
    By choosePaymentThroughPayPalLocator = By.xpath("//a[@href='#paypal']");
    //    By nameStudentPayPalLocator = By.xpath("//input[@name='namepaypal']");
    By nameStudentPayPalLocator = By.xpath("//input[@name='namepaypal']");
    By emailPayPalLocator = By.xpath("//input[@id='emailpaypal']");
    By createPasswordLocator = By.xpath("//input[@id='passwordpaypal']");
    By confirmPasswordPayPalLocator = By.xpath("//input[@id='password-confirmpaypal']");
    By checkBoxIaMleast18YearsOldLocator = By.xpath("//input[@name='agreementpaypal']");
    By checkOutWithPayPalLocator = By.xpath("//button[@id='pay-button']");


    public SandboxPaypal registerNewUserPayPal(WebDriver driver){
        this.driver.navigate().to("http://dquest.web-104.net/public/api/register/purchase/texas-teen-course?nocharge");

        WebElement choosePaymentThroughPayPal = this.driver.findElement(choosePaymentThroughPayPalLocator);
        choosePaymentThroughPayPal.click();

        WebElement studentNamePayPal = this.driver.findElement(nameStudentPayPalLocator);
        studentNamePayPal.sendKeys(authorization.getFirstAndLastName());

        WebElement emailPayPal = this.driver.findElement(emailPayPalLocator);
        emailPayPal.sendKeys(authorization.getEmailLogin());

        WebElement createPassword = this.driver.findElement(createPasswordLocator);
        createPassword.sendKeys(authorization.getPasswordLogin());

        WebElement confirmPasswordPayPal = this.driver.findElement(confirmPasswordPayPalLocator);
        confirmPasswordPayPal.sendKeys(authorization.getPasswordLogin());

        WebElement checkBoxIaMleast18YearsOld = this.driver.findElement(checkBoxIaMleast18YearsOldLocator);
        checkBoxIaMleast18YearsOld.click();

        WebElement purchesButton = this.driver.findElement(checkOutWithPayPalLocator);
        purchesButton.click();

        return new SandboxPaypal(this.driver);
    }
}
