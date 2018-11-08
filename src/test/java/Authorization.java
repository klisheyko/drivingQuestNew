import org.apache.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Authorization {
    private WebDriver driver;
//    private String emailLogin = "klishk1@inbox.ru" ;
//    private String passwordLogin = "klisheyko123!!!!";
//    private String emailLogin = "testklish@inbox.ru" ;
//    private String passwordLogin = "klisheyko123!!!!";
    private String emailLogin = "klisheyko2@yandex.ru" ;
    private String passwordLogin = "6d30a6e1";

    public String getEmailOfUserRealPatPal() {
        return emailOfUserRealPatPal;
    }
    public String getPasswordOfReaLPayPal() {
        return passwordOfReaLPayPal;
    }

    private String emailOfUserRealPatPal = "dzurabyan-buyer@gmail.com" ;
    private String passwordOfReaLPayPal = "12345678";

    private String firstAndLastName = "KLISHK KLISHK";

    private static final org.apache.log4j.Logger log = LogManager.getRootLogger();

//    testing credit card: 4242424242424242
//                         cv = 543
//    klishk060@gmail.com

    //   LOCATORS
    By emailLoginLocator = By.xpath("//input[@id='email']");
    By passwordLoginLocator = By.xpath("//input[@id='password']");
    By buttonLoginLocator = By.xpath("//button[@type='submit']");
    By nameOfCurrentUserLocator = By.xpath("//h2[contains(text(),'Hi Oleksandr Klysheiko!')]");


    By choosePaymentThroughPayPalLocator = By.xpath("//a[@href='#paypal']");
//  By nameStudentPayPalLocator = By.xpath("//input[@name='namepaypal']");
    By nameStudentPayPalLocator = By.xpath("//*[@id='payment-formpaypal']/div[1]/div[1]/input");
    By emailPayPalLocator = By.xpath("//input[@id='emailpaypal']");
    By confirmPasswordPayPalLocator = By.xpath("//input[@id='password-confirmpaypal']");
    By checkBoxIaMleast18YearsOldLocator = By.xpath("//input[@name='agreementpaypal']");
    By checkOutWithPayPalLocator = By.xpath("//button[@id='pay-button']");

    //Constructors and Getters
    public  Authorization(WebDriver driver) {
        this.driver = driver;
    }
    public String getEmailLogin() {
        return emailLogin;
    }
    public String getPasswordLogin() {
        return passwordLogin;
    }
    public String getFirstAndLastName() {
        return firstAndLastName;
    }

    public void emailAuthorization(String emailLogin){
        WebElement loginUser = driver.findElement(emailLoginLocator);
        loginUser.click();
        log.info("make click on label Login");
        loginUser.clear();
        log.info("clean label Login");
        loginUser.sendKeys(emailLogin);
        log.info("insert test login");
    }
    public void passwordAuthorization(String passwordLogin){
        WebElement passwordUser = driver.findElement(passwordLoginLocator);
        passwordUser.click();
        log.info("make click on label Password");
        passwordUser.clear();
        log.info("clean label Password");
        passwordUser.sendKeys(passwordLogin);
        log.info("insert test Password");
    }
    public Dashboard buttonAuthorization(){
        driver.findElement(buttonLoginLocator).click();
        log.info("make click on button Login");
        Assert.assertEquals("Hi Oleksandr Klysheiko!", driver.findElement(nameOfCurrentUserLocator).getText());
    return new Dashboard(driver);
    }

    public void checkAuthorization(){
        Assert.assertEquals("Hi Oleksandr Klysheiko!", driver.findElement(nameOfCurrentUserLocator).getText());
    }
}
