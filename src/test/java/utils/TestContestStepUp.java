package utils;

import org.openqa.selenium.WebDriver;
import managers.PageObjectManager;

public class TestContestStepUp {
    public PageObjectManager pageObjectManager;

    public TestContestStepUp(WebDriver driver) {
        pageObjectManager = new PageObjectManager(driver);
    }
}
