package reusableCode;

import managers.FileReaderManager;
import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumHelper {
    WebDriver driver;
    WebDriverWait wait;
    int EXPLICIT_WAIT= FileReaderManager.getConfigFileReader().getExplicitWait();

    private static JLanguageTool tool = new JLanguageTool(new BritishEnglish());

    public SeleniumHelper(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
    }

    public void elementToVisibility(By loc){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
    }
    public void elementToClickable(By loc){
        wait.until(ExpectedConditions.elementToBeClickable(loc));
    }
    public void enterText(By loc, String text){
        driver.findElement(loc).sendKeys(text);
    }
    public void click(By loc){
        driver.findElement(loc).click();
    }

    public static boolean isTextCorrect(String text) throws Exception {

        List<RuleMatch> matches = tool.check(text);

        if (!matches.isEmpty()) {
            for (RuleMatch match : matches) {
                System.out.println("Error: " + match.getMessage());
                System.out.println("Suggestions: " + match.getSuggestedReplacements());

                System.out.println("Some Changes to push");

                System.out.println("New line");


                System.out.println("Branch first");
            }
            return false;
        }
        return true;
    }

}
