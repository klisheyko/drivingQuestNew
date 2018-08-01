import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartCourse {

    private WebDriver driver;
    private static final org.apache.log4j.Logger log = LogManager.getRootLogger();
    Authorization authorization = new  Authorization(driver);

    public StartCourse(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS

    By contractOfNewUserDONE = By.xpath("//h1");   // Для Assert проверка
    By startCourseClickButton = By.cssSelector("button.button.green.submit");

    public Dashboard startCoursButtonClick(WebDriver driver){
        driver.findElement(startCourseClickButton).click();

        return new Dashboard(driver);
    }
}
