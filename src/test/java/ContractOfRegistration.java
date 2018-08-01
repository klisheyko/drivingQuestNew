import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContractOfRegistration {

    private WebDriver driver;
    private static final org.apache.log4j.Logger log = LogManager.getRootLogger();
    Authorization authorization = new Authorization(driver);

    public ContractOfRegistration(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    By firstNameContractLocator = By.xpath("//input[@name='first_name']");
    By lastNameContractLocator = By.xpath("//input[@name='last_name']");
    By addressContractLocator = By.xpath("//input[@name='address_street']");
    By addressCityContractLocator = By.xpath("//input[@name='address_city']']");
    By StateContractLocator = By.xpath("/html/body/div[2]/div/div[2]/div/form/div[1]/div[3]/div[1]/div/select/option[39]");
    By zipCodeContractLocator = By.xpath("//input[@name='address_zip']");
    By dateOfBirthContractLocator = By.xpath("//input[@name='date_of_birth']");
    By maleSexInputContractLocator = By.xpath("/html/body/div[2]/div/div[2]/div/form/div[1]/div[3]/div[4]/div/div/label[1]/input");
    By studentPhoneContractLocator = By.xpath("//input[@name='student_phone']");
    By studentEmailContractLocator = By.xpath("//input[@name='student_email']");
    By paretentSNameContractLocator = By.xpath("//input[@name='parent_name']");
    By paretentSEmailContractLocator = By.xpath("//input[@name='parent_email']");

    By checkBoxContractLocator = By.xpath("//input[@name='agreement']");
    By cheButtonNEXTContractLocator = By.cssSelector("button.button.green.submit");

    By clickPayNowPayPalLocator = By.cssSelector("#confirmButtonTop");

    public FirstValidation formOfContracts(WebDriver driver)  {


        WebElement firstNameContract = this.driver.findElement(firstNameContractLocator);
        firstNameContract.clear();
        firstNameContract.sendKeys("KLISHK");

        WebElement lastNameContract = this.driver.findElement(lastNameContractLocator);
        lastNameContract.clear();
        lastNameContract.sendKeys("KLISHK");

        WebElement addressContract = this.driver.findElement(addressContractLocator);
        addressContract.clear();
        addressContract.sendKeys("1111 Bustleton Avenue");

        WebElement addressCityContract = this.driver.findElement(addressCityContractLocator);
        addressCityContract.clear();
        addressCityContract.sendKeys("Philadelphia");

        WebElement StateContract = this.driver.findElement(StateContractLocator);
        StateContract.click();
        StateContract.sendKeys("PA");
        StateContract.click();

        WebElement zipCodeContract = this.driver.findElement(zipCodeContractLocator);
        zipCodeContract.clear();
        zipCodeContract.sendKeys("19115");

        WebElement dateOfBirthContract = this.driver.findElement(dateOfBirthContractLocator);
        dateOfBirthContract.clear();
        dateOfBirthContract.sendKeys("10201982");

        WebElement maleSexInputContract = this.driver.findElement(maleSexInputContractLocator);
        maleSexInputContract.click();

        WebElement studentPhoneContract = this.driver.findElement(studentPhoneContractLocator);
        studentPhoneContract.clear();
        studentPhoneContract.sendKeys("2671234567");

        WebElement studentEmailContract = this.driver.findElement(studentEmailContractLocator);
        studentEmailContract.clear();
        studentEmailContract.sendKeys(authorization.getEmailLogin());

        WebElement paretentSNameContract = this.driver.findElement(paretentSNameContractLocator);
        paretentSNameContract.clear();
        paretentSNameContract.sendKeys("MyFather");

        WebElement paretentSEmailContract = this.driver.findElement(paretentSEmailContractLocator);
        paretentSEmailContract.clear();
        paretentSEmailContract.sendKeys("klisheyko2@gmail.com");

        WebElement checkBoxContract = this.driver.findElement(checkBoxContractLocator);
        checkBoxContract.click();

        WebElement cheButtonNEXTContract = this.driver.findElement(cheButtonNEXTContractLocator);
        cheButtonNEXTContract.click();

        return new FirstValidation(this.driver);
    }

}


