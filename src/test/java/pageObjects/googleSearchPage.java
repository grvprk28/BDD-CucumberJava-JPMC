package pageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class googleSearchPage extends BaseClass {

    public googleSearchPage(WebDriver webDriver)
    {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//textarea[@title='Search']")
    @CacheLookup
    public
    WebElement searchTextBox;

    @FindBy(xpath = "(//input[@value='Google Search'])[2]")
    @CacheLookup
    public
    WebElement searchButton;


}
