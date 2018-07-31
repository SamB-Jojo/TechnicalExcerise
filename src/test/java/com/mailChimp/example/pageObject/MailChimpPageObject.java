package com.mailChimp.example.pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sams on 7/29/2018.
 */
public class MailChimpPageObject {
    private final static String footerSelector = "body > footer > div > div.col.footer-logo-container.\\31 of1.align-left > a";
    private final static String aboutSelector = "body > footer > div > div.block.span1of1.align-left > div:nth-child(4) > ul > li:nth-child(1) > a";
    public final static String url = "https://mailchimp.com/";
    WebDriver driver;
    public MailChimpPageObject(){
        driver = null;
    }

    public MailChimpPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickAboutLink(){
        scrollToElementAndClick(By.cssSelector(aboutSelector));
    }
    void scrollToElementAndClick(By element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", driver.findElement(element));
        waitForPageLoad();
        try {
            driver.findElement(element).click();
        }catch(WebDriverException e){
            System.out.println("Error Clicking element : " + element.toString()+
                    "\n Trying again");
            driver.findElement(element).click();
        }
    }
    protected void scrollToElementAndClick(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
        waitForPageLoad();
        try {
            element.click();
        }catch(WebDriverException e){
            System.out.println("Error Clicking element : " + element.toString()+
                    "\n Trying again");
            element.click();
        }
    }

    public void waitForPageLoad(){
        WebDriverWait wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(footerSelector)));
    }
    public void navigateToMailChimpHomepage(){
        driver.get(url);
    }
}
