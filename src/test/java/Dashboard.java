import org.apache.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Dashboard {
    public WebDriver driver;
    private static final org.apache.log4j.Logger log = LogManager.getRootLogger();

    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }

    //   LOCATORS
    By nextSlideLocator1 = By.cssSelector("button.course-next");
    By nextSlideLocator = By.cssSelector(".course-next");


    By continueCourseButtonLocator = By.cssSelector("button.btn-course span");

    By dashboardCourseButtonLocator = By.cssSelector("#continue");

    By dashboardCourseButtonLocator1 = By.cssSelector("#wrapper > div.content-page > div.score-box > div > div > div.col-md-4.text-right > div > form > div > button");
    By startCourseLocator = By.cssSelector("button.btn.btn-course");
    By finishCourseLocator = By.xpath("//p[contains(text(),'You have completed your course. We will send you certification shortly.')]");
    By LogOutLocator = By.xpath("//a[@class='dark']");
    By backgroundGreenLocator = By.cssSelector("div[style*='background:green']");
    By submitQuizLocator = By.xpath("//button[contains(text(),'Submit Quiz')]");
    By returnToDashboardLocator = By.xpath("//a[contains(text(),'Return to dashboard')]");
    By submitVideoQuestLocator = By.xpath("//button[contains(text(),'Submit')]");
    By textChouseWayLocator = By.xpath("//p[contains(text(),'Texas requires teen students to complete 14 Hours of Behind-the-Wheel training with a Parent-Instructor or with a Driving School. How do you wish to complete these hours?')]");
    By parentTaughtLocator = By.xpath("//button[@value='PT']");
    By validationLastAnswerLocator = By.cssSelector("div[class*='answer-item']");
    By submitValidationLocator = By.xpath("//button[contains(text(),'Submit')]");
    By timeRemainingLocator = By.xpath("//span[contains(text(),'Time Remaining ')]");
    By slideNumberLocator = By.xpath("//span[@class='timer'][2]");
    By hiddenNextSlideLocator = By.cssSelector("i.hidden-xs.fa.fa-angle-right");
    By compiteCourseLocator = By.xpath("//div[@class='course-actions hidden-xs']/h4");



    public boolean actionsOnPages() {
        PageType pageType = GetPageType();

            switch (pageType){
                case Dashboard:
                    if(driver.findElement(dashboardCourseButtonLocator).isDisplayed()){
                        Assert.assertNotNull(dashboardCourseButtonLocator);
                        driver.findElement(dashboardCourseButtonLocator).click();
                        break;
                    }if (driver.findElement(compiteCourseLocator).isDisplayed()){
                         driver.findElement(LogOutLocator).click();
                }
                    break;
                case Slide:
                    driver.get(driver.getCurrentUrl() + "?notimer=1");
                    driver.navigate().forward();

                    if (driver.findElement(nextSlideLocator).isDisplayed() || driver.findElement(nextSlideLocator1).isDisplayed()){
                        driver.findElement(nextSlideLocator).click();
                    }else

                    driver.findElement(parentTaughtLocator).click();
                    break;
                case Quiz:
                    driver.get(driver.getCurrentUrl() + "?notimer=1");
                    driver.navigate().forward();
                    List<WebElement> myList=driver.findElements(backgroundGreenLocator);
                    for (WebElement aMyList : myList) {

                        aMyList.click();

                        log.debug("List of answer choices in the test Quiz");
                    }

                    driver.findElement(submitQuizLocator).click();
                    log.info("Submit Quiz Button");
                    Assert.assertNotNull(returnToDashboardLocator);
                    driver.findElement(returnToDashboardLocator).click();
                    log.info("Return after Quiz test");
                    break;
                case Video:
                    driver.get(driver.getCurrentUrl() + "?notimer=1");
                    driver.navigate().forward();
                    List<WebElement> myList2=driver.findElements(backgroundGreenLocator);
                    for (WebElement aMyList2 : myList2) {
                        aMyList2.click();
                    Assert.assertNotNull(submitVideoQuestLocator);
                    driver.findElement(submitVideoQuestLocator).click();
                    log.info("Return after Video test");
                    }
                    break;
                case SaveQuiz:
                    Assert.assertNotNull(parentTaughtLocator);
                    driver.findElement(parentTaughtLocator).click();
                    log.info("chose his parent to practice");
                    break;
                case Validation:
                    driver.navigate().refresh();
                    driver.get(driver.getCurrentUrl() + "?notimer=1");
                    List<WebElement> myList1=driver.findElements(validationLastAnswerLocator);
                    myList1.get(myList1.size() - 1).click();
                    Assert.assertNotNull(submitValidationLocator);
                    driver.findElement(submitValidationLocator).click();
                    log.info("answered the validation question");
                    break;
                case Start:
                    Assert.assertNotNull(startCourseLocator);
                    driver.findElement(startCourseLocator).click();
                    log.info("Beginning of the training course. Press the 'start course'");
                    break;
                case Finish:
                    Assert.assertNotNull(LogOutLocator);
                    driver.findElement(LogOutLocator).click();
                    log.info("The course is over. Press the 'Sign Out'");
                    break;
                default:
                    try {
                        wait(1200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.error("WAIT");
                    break;
            }
        return actionsOnPages();
    }

    public PageType GetPageType() {
        try {
                if (driver.getCurrentUrl().contains("slide")) {
                    return PageType.Slide;
                }else if (driver.getCurrentUrl().contains("quiz")) {
                    return PageType.Quiz;
                }else
                if (driver.getCurrentUrl().contains("videoquest")) {
                    return PageType.Video;
                }else
                if (driver.getCurrentUrl().contains("savequiz")) {
                    return PageType.SaveQuiz;
                }else
                if (driver.getCurrentUrl().contains("validation")) {
                    return PageType.Validation;
                } else if(driver.getCurrentUrl().contains("dashboard")){
                    return PageType.Dashboard;
                }else if (driver.findElement(finishCourseLocator) != null) {
                return PageType.Finish;
                } else if (driver.findElement(startCourseLocator) != null) {
                return PageType.Start;
                }
                 return PageType.Unknown;
           }
            catch(Exception ex){
                // write exception to log file
                return PageType.Unknown;
                }
            }
}











