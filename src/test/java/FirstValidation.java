import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FirstValidation {
    private WebDriver driver;
    private static final org.apache.log4j.Logger log = LogManager.getRootLogger();
    Authorization authorization = new  Authorization(driver);

    public FirstValidation(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    By listOfQuestionsNewValidationLocator = By.cssSelector("form.form-section.validation-form");
    By clickButtonNEXTNewValidationLocator = By.cssSelector("button.button.green.submit");


    public StartCourse newValidation(WebDriver driver){

        List<WebElement> myList1=driver.findElements(listOfQuestionsNewValidationLocator);
        log.debug("A list of answers to the question of NeW Validation is collected");
        myList1.get(myList1.size() - 1).click();
        driver.findElement(listOfQuestionsNewValidationLocator).click();
        log.debug("The last answer option is selected in the list and clicked on it - test Validation");
        driver.findElement(clickButtonNEXTNewValidationLocator).click();

        return new StartCourse(driver);
    }

}
