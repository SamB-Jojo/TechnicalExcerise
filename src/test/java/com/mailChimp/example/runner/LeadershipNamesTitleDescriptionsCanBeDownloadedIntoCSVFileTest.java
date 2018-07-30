package com.mailChimp.example.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by sams on 7/24/2018.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue="classpath:com/mailChimp/example/steps")
public class LeadershipNamesTitleDescriptionsCanBeDownloadedIntoCSVFileTest {
}
