package stepDefinition;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.LoginPage;
import utils.BaseTest;
import utils.TestContestStepUp;

import static java.sql.DriverManager.getDriver;

public class TestNGAnnotationsDemo extends BaseTest {

    TestContestStepUp testContestStepUp;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        initializer(); // Initializes ThreadLocal driver
        testContestStepUp = new TestContestStepUp(getDriver());
        loginPage = testContestStepUp.pageObjectManager.getLoginPage();
    }

    @Test(priority = 1)
    public void loginApp() throws Exception {
        loginPage.enterNameAndPassword();
        loginPage.loginBtn();
        Thread.sleep(5000);

    }

    @AfterMethod
    public void tearDown() {
        quitDriver(); // Quits ThreadLocal driver
    }

//    @Test(priority = 2)
//    public void login2App() {
//        loginPage.enterNameAndPassword();
//    }
}
