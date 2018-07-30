package com.mailChimp.example.pageObject;

import com.mailChimp.example.domain.Leader;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 * Created by sams on 7/29/2018.
 */
public class MailChimpAboutPageObject extends MailChimpPageObject {
    public final static String url = "https://mailchimp.com/about/";
    public MailChimpAboutPageObject(WebDriver driver){
        super(driver);
    }

    public ArrayList<Leader> populateLeadershipArrayList() {
        return null;
    }
}
