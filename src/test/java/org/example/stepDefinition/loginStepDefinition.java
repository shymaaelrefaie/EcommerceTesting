package org.example.stepDefinition;

import org.example.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class loginStepDefinition {

    LoginPage login = new LoginPage();
    SoftAssert soft = new SoftAssert();

    @Given("user navigates to login page")
    public void user_naviagtes()
    {
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/login");
    }

    @When("user enter valid username and password")
    public void valid_data()
    {
            login.loginsteps("shymaa2@test.com","test!123");
    }

    @Then("user could login successfully")
    public void logeedScreen()
    {
        soft.assertEquals("https://demo.nopcommerce.com/", Hooks.driver.getCurrentUrl());
    }

    @And("Myaccount menu displayed")
    public void checkMyAccount()
    {
        soft.assertTrue(Hooks.driver.findElement(By.className("ico-account")).isDisplayed());

        soft.assertAll();

    }

    @When("user enter invalid username and password")
    public void invalid_data()
    {
        login.invalidloginsteps("shym@test.com","test!123");
    }

    @Then("user can not login")
    public void unsuccessfullogin()
    {
        soft.assertEquals("https://demo.nopcommerce.com/login", Hooks.driver.getCurrentUrl());
    }

    @And("error message displayed")
    public void error_msg()
    {
        String expectedmsg = "Login was unsuccessful. Please correct the errors and try again.";
        String actualmsg = Hooks.driver.findElement(By.className("message-error")).getText();

        soft.assertTrue(expectedmsg.contains(actualmsg));

    }

    @And("error message is red")
    public void Redmsg()
    {
        String msgcolor = Hooks.driver.findElement(By.className("message-error")).getCssValue("color");
        System.out.println(msgcolor);
        String expectedcolor = "rgba(228, 67, 75, 1)";
        soft.assertEquals(msgcolor,expectedcolor);

    }

}
