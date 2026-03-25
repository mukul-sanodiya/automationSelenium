package managers;

import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;

public class PageObjectManager {
    WebDriver driver;
    LoginPage loginPage;

    public PageObjectManager(WebDriver driver){

        this.driver=driver;
    }

    public LoginPage getLoginPage() {
         loginPage=new LoginPage(driver);
         return loginPage;
    }
}
