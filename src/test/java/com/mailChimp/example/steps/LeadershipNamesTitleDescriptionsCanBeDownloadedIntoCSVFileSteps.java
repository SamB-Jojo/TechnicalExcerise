package com.mailChimp.example.steps;

import com.mailChimp.example.domain.Leader;
import com.mailChimp.example.pageObject.MailChimpAboutPageObject;
import com.mailChimp.example.pageObject.MailChimpPageObject;
import cucumber.api.Pending;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by sams on 7/24/2018.
 */

public class LeadershipNamesTitleDescriptionsCanBeDownloadedIntoCSVFileSteps {
    WebDriver driver;

    ArrayList<Leader> leadership;
    MailChimpPageObject page;
    MailChimpAboutPageObject aboutPage;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sams\\Documents\\TechnicalExcerise\\src\\test\\resources\\tools\\chromedriver.exe");
         driver = new ChromeDriver();
        leadership = new ArrayList<Leader>();
        page = new MailChimpPageObject(driver);
    }
    @Given("^the MailChimp website opens$")
    public void the_MailChimp_website_opens()  {
       page.navigateToMailChimpHomepage();
        page.waitForPageLoad();
       Assert.assertThat(driver.getCurrentUrl(),is(MailChimpPageObject.url));
    }

    @Given("^the user can navigate to  about MailChimp$")
    public void the_user_can_navigate_to_about_MailChimp() throws Throwable {
        page.clickAboutLink();
        aboutPage = new MailChimpAboutPageObject(driver);
        aboutPage.waitForPageLoad();
        Assert.assertThat(driver.getCurrentUrl(), is(MailChimpAboutPageObject.url) );
    }

    @When("^the user extracts the leadership name, title, and description$")
    public void the_user_extracts_the_leadership_name_title_and_description() throws Throwable {
        leadership = aboutPage.populateLeadershipArrayList();
        Assert.assertTrue("No leaderhip members we populated from webpage", !leadership.isEmpty());
    }

    @Then("^information can be stored to a csv file$")
    public void information_can_be_stored_to_a_csv_file() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @After
    public void closeDriver(){
        if(driver != null){
            driver.close();
        }
    }
}
