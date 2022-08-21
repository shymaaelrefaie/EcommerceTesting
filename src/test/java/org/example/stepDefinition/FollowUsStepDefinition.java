package org.example.stepDefinition;

import org.example.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class FollowUsStepDefinition {

    HomePage HP = new HomePage();
    SoftAssert soft = new SoftAssert();

    //Facebook
    @When("user click on facebook icon")
    public void clickFB()
    {
        Hooks.driver.findElement(By.className("facebook")).click();
    }

    @Then("facebook page will open in new tab")
    public void openFbNewtab() throws InterruptedException {
        HP.openFbNewtab();
    }

    //Twitter
    @When("user click on twitter icon")
    public void clickTwitter()
    {
        Hooks.driver.findElement(By.className("twitter")).click();
    }

    @Then("twitter page will open in new tab")
    public void opentwitterNewtab() throws InterruptedException {
        HP.openTwitterNewtab();
    }

    //Rss
    @When("user click on Rss icon")
    public void clickRss()
    {
        Hooks.driver.findElement(By.className("rss")).click();
    }

    @Then("Rss page will open in new tab")
    public void openRssNewtab() throws InterruptedException {
        HP.openRssNewtab();
    }


    //Youtube
    @When("user click on Youtube icon")
    public void clickYoutube()
    {
        Hooks.driver.findElement(By.className("youtube")).click();
    }

    @Then("Youtube page will open in new tab")
    public void openYoutubeNewtab() throws InterruptedException {
        HP.openYoutubeNewtab();


    }

}
