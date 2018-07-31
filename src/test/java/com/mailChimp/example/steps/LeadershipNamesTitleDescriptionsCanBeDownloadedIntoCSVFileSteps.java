package com.mailChimp.example.steps;

import com.mailChimp.example.domain.Leader;
import com.mailChimp.example.pageObject.MailChimpAboutPageObject;
import com.mailChimp.example.pageObject.MailChimpPageObject;
import com.mailChimp.example.util.WriteToCSVFile;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by sams on 7/24/2018.
 */

public class LeadershipNamesTitleDescriptionsCanBeDownloadedIntoCSVFileSteps {
    private WebDriver driver;

    private ArrayList<Leader> leadership;
    private MailChimpPageObject page;
    private MailChimpAboutPageObject aboutPage;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        page = new MailChimpPageObject(driver);
    }
    @Given("^the MailChimp website opens$")
    public void the_MailChimp_website_opens()  {
       page.navigateToMailChimpHomepage();
        page.waitForPageLoad();
       Assert.assertThat(driver.getCurrentUrl(),is(MailChimpPageObject.url));
    }

    @Given("^the user can navigate to about MailChimp$")
    public void the_user_can_navigate_to_about_MailChimp(){
        page.clickAboutLink();
        aboutPage = new MailChimpAboutPageObject(driver);
        aboutPage.waitForPageLoad();
        Assert.assertThat(driver.getCurrentUrl(), is(MailChimpAboutPageObject.url) );
    }

    @When("^the user extracts the leadership name, title, and description$")
    public void the_user_extracts_the_leadership_name_title_and_description() {
        leadership = aboutPage.populateLeadershipArrayList();
        Assert.assertTrue("No leaderhip members we populated from webpage", !leadership.isEmpty());
    }

    @Then("^information can be stored to a csv file$")
    public void information_can_be_stored_to_a_csv_file()  {
        WriteToCSVFile.writeLeadershipInfoToFile(leadership);
    }

    @After
    public void closeDriver(){
        if(driver != null){
            driver.close();
        }
    }
}
