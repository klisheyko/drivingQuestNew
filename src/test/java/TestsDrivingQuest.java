import org.junit.Test;

public class TestsDrivingQuest extends SettingsTest {

    @Test
    public void authorizationTest() {
        Authorization authorization = new Authorization(driver);
        authorization.emailAuthorization(authorization.getEmailLogin());
        authorization.passwordAuthorization(authorization.getPasswordLogin());
        authorization.buttonAuthorization();
        authorization.checkAuthorization();
    }
    @Test
    public void trainingOfTheTestUser() {
        Dashboard dashboard = new Dashboard(driver);
        authorizationTest();
        dashboard.actionsOnPages();
    }
    @Test
    public void purshedOfNewStudent()  {
        SandboxPaypal sendbox = new SandboxPaypal(driver);
        ContractOfRegistration contractOfRegistration = new ContractOfRegistration(driver);
        RegistratioOfNewUser registratioOfNewUser = new RegistratioOfNewUser(driver);
        FirstValidation firstValidation = new FirstValidation(driver);
        StartCourse startCourse = new StartCourse(driver);

        registratioOfNewUser.registerNewUserPayPal(driver);
        sendbox.payThroughPayPalForRegistrationOfANewStudent(driver);
        contractOfRegistration.formOfContracts(driver);
        firstValidation.newValidation(driver);
        startCourse.startCoursButtonClick(driver);
    }
}
