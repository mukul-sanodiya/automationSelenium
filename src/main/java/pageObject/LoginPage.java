package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import reusableCode.SeleniumHelper;

public class LoginPage extends SeleniumHelper {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    By UserName=By.xpath("//input[@name=\"username\"]");
    By Password=By.xpath("//input[@name=\"password\"]");
    By LoginBtn=By.xpath("//button[text()=\" Login \"]");

    public void enterNameAndPassword(){
       // elementToClickable(UserName);
        elementToVisibility(UserName);
        enterText(UserName,"Admin");
       // elementToClickable(Password);
        elementToVisibility(Password);
        enterText(Password,"admin123");
    }
    public void loginBtn() throws Exception {
       // elementToClickable(LoginBtn);
        elementToVisibility(LoginBtn);
        click(LoginBtn);
        Thread.sleep(5000);
        System.out.println("Hello...");
        boolean result = SeleniumHelper.isTextCorrect("He go to office every day");

        Assert.assertTrue(result, "Grammar issues found on page!");

        Thread.sleep(5000);
    }

}
