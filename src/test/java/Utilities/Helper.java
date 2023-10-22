package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Helper {

    private static Helper Helper;
    private static WebDriver driver ;
    public final static int TIMEOUT = 10;

    /* Constructor to initiate Chrome Browser and maximize window */
    private Helper() {
//        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
//        driver = new ChromeDriver();
        driver = new EdgeDriver();
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
    }


    /* Method to launch the URL */
    public static void openPage(String url) {
        driver.get(url);
    }

    /* Method to getTitle of the Webpage */
    public static String getTitle() {
        return driver.getTitle();
    }

    /* Method to return driver object */
    public static WebDriver getDriver() {
        return driver;
    }

    /* Method to initiate helper object, call constructor to launch browser */
    public static void setUpDriver() {
        if (Helper==null) {
            Helper = new Helper();
        }
    }

    /* Method to close browser */
    public static void tearDown() {
        if(driver!=null) {
            driver.quit();
        }
        Helper = null;
    }

}
