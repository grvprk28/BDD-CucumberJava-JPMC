package stepDefinitions;

import Utilities.BaseClass;
import Utilities.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.googleSearchPage;
import pageObjects.theGuardianNewsPage;

import java.util.List;


public class confirmValidNewsPageDefinition extends BaseClass {

    @Given("User launches Chrome Browser")
    public void user_launches_chrome_browser() {
        guardianNewsPage = new theGuardianNewsPage(Helper.getDriver());
    }

    @When("User opens link {string}")
    public void user_opens_link(String url) {
        Helper.openPage(url);
    }

    @Then("Verify if page title is displayed as {string}")
    public void verify_if_page_title_is_displayed(String title){
            String loginPgTitle = Helper.getTitle();
            Assert.assertEquals(title, loginPgTitle);
    }


    @And("Verify the logo for The Guardian exists in the page")
    public void verify_the_logo_exists_in_the_landing_page(){
        explicitWait(guardianNewsPage.theGuardianLogo, 10);
        Assert.assertTrue(guardianNewsPage.theGuardianLogo.isDisplayed());
    }
    @And("Verify if article section is loaded successfully")
    public void verify_the_article_section_is_loaded(){
        explicitWait(guardianNewsPage.wholeArticleSection, 10);
        Assert.assertTrue(guardianNewsPage.wholeArticleSection.isDisplayed());
    }

    @When("User picks the article no {string} from The Guardian Page")
    public void pick_the_article_from_the_guardian_page(String serialNo){
        Assert.assertTrue(Helper.getDriver().findElement(By.xpath("(//a[@data-link-name='article' and not(@tabindex ='-1')])["+serialNo+"]")).isDisplayed());
        newsHeader = Helper.getDriver().findElement(By.xpath("(//a[@data-link-name='article' and not(@tabindex ='-1')])["+serialNo+"]")).getText().replace("Live\n", "");
    }


    @Then("User launches another Chrome Browser")
    public void user_launches_another_chrome_browser() {
        chromePage = new googleSearchPage(Helper.getDriver());
    }


    @And("Verify the google page is loaded")
    public void google_page_loaded(){
        explicitWait(chromePage.searchTextBox, 10);
        Assert.assertTrue(chromePage.searchTextBox.isDisplayed());
    }


    @Then("User searches the news header from The Guardian Page in Google")
    public void search_in_google(){
        chromePage.searchTextBox.sendKeys(newsHeader);
        explicitWait(chromePage.searchButton, 10);
        Assert.assertTrue(chromePage.searchButton.isDisplayed());
        chromePage.searchButton.click();
    }

    @And("Verify similar information on Google")
    public void verify_match_count(){
        List<WebElement> listOfMatches = Helper.getDriver().findElements(By.xpath("//span[text()='Top stories']//ancestor::g-section-with-header//div[@role='heading']"));
        matchCount= listOfMatches.size()-1;
    }

    @Then("Confirm the news is valid or fake")
    public void assert_valid_or_fake_news(){
        if(matchCount>=2){
            System.out.println("Valid News");
        }else{
            System.out.println("Fake News");
        }
    }

}
