package com.mailChimp.example.pageObject;

import com.mailChimp.example.domain.Leader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sams on 7/29/2018.
 */
public class MailChimpAboutPageObject extends MailChimpPageObject {
    public final static String url = "https://mailchimp.com/about/";
    private final String leadershipDivsSelector = "body > div:nth-child(5) > article > div > section:nth-child(7) > div.row.align-left.bio_wrapper > div";

    public MailChimpAboutPageObject(WebDriver driver){
        super(driver);
    }

    public ArrayList<Leader> populateLeadershipArrayList() {
        ArrayList<Leader> leaders = new ArrayList<Leader>();
        List<WebElement> leadershipDivs = driver.findElements(By.cssSelector(leadershipDivsSelector));
        for(int i = 1; i < leadershipDivs.size() +1; i++){
            clickOnALeader(i);
            leaders.add(getLeader());
            driver.navigate().refresh();
        }
        return leaders;
    }

    private void clickOnALeader(int i) {
        scrollToElementAndClick(By.cssSelector(leadershipDivsSelector + ":nth-child("+ i + ") > a"));
        waitForPageLoad();
    }

    private Leader getLeader() {
        String leaderDivsID = "bio_view";
        String[] leaderInfo = driver.findElement(By.id(leaderDivsID)).getText().split("\n", 3);
        Leader leader = new Leader();
        leader.setName(leaderInfo[0]);
        leader.setTitle(leaderInfo[1]);
        leader.setDecscription(leaderInfo[2]);
        return leader;
    }
}
