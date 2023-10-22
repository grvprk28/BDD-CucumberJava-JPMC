package pageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class theGuardianNewsPage extends BaseClass {

    public theGuardianNewsPage(WebDriver webDriver)
    {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[@class='fc-container--rolled-up-hide fc-container__body']")
    @CacheLookup
    public
    WebElement wholeArticleSection;

    @FindBy(xpath = "//span[@class='inline-the-guardian-logo inline-logo ']")
    @CacheLookup
    public
    WebElement theGuardianLogo;


}
