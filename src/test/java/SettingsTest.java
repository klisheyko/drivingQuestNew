import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class SettingsTest {
    //    private static final Logger log = LogManager.getRootLogger();
    static Logger log = Logger.getLogger(String.valueOf(SettingsTest.class));
    public WebDriver driver;


    @Before
    public void setUpTest(){
        DOMConfigurator.configure("log4j.xml");
        System.out.println("Set Up Method");
        log.info("New Test");
        log.info("Set Up Method");
        System.setProperty("webdriver.chrome.driver","/home/ytka/IdeaProjects/drivingQuestNew/src/main/resources/chromedriver");
        driver = new ChromeDriver();
//      driver.get("http://gym.web-102.net/public/api/login");
       driver.get("http://dquest.web-104.net/public/api/login");
        log.info("Open Web App");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @After
    public void tearDownTest(){
        if (driver != null){
//           System.out.println("Tear Down Method");
//           log.info("Tear Down Method");
//           driver.close();
        }
    }
}
