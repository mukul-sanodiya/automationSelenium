package utils;

import managers.FileReaderManager;
import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public void initializer() {

        String browser = FileReaderManager.getConfigFileReader().getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        getDriver().manage().window().maximize();
        getDriver().get(FileReaderManager.getConfigFileReader().getUrl());

        int implicitWait = FileReaderManager.getConfigFileReader().getImplicitWait();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
    }


    public void quitDriver() {
        getDriver().quit();
        driver.remove(); // Important to clean up ThreadLocal
    }
}
