package Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.googleSearchPage;
import pageObjects.theGuardianNewsPage;

import java.time.Duration;

import static Utilities.Helper.getDriver;

public class BaseClass {
    public theGuardianNewsPage guardianNewsPage;
    public googleSearchPage chromePage;
    public String newsHeader;
    public int matchCount;
    public static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    static Actions action = new Actions(Helper.getDriver());


    /* Method to click on the WebElement */
    public static void click(WebElement e) {
        explicitWait(e, 5);
        e.click();
    }

    /* Method to type text in the WebElement */
    public static void type(WebElement e, String text) {
        explicitWait(e, 10);
        e.sendKeys(text);
    }

    /* Method to verify if WebElement is displayed */
    public static void verifyElementDisplayed(WebElement e) {
        explicitWait(e, 10);
        Assert.assertTrue(e.isDisplayed());
    }


    /* Method to wait explicitly for WebElement for given time in Seconds */
    public static void explicitWait(WebElement e, int sec) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.visibilityOf(e));
    }
}
