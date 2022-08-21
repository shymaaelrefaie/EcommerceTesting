package org.example.stepDefinition;

import org.example.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class RegisterStepDefinition {


    RegisterPage register = new RegisterPage();
    SoftAssert soft = new SoftAssert();

    @Given("user navigates to register page")
    public void user_naviagtes()
    {
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/register");
    }

    @When("user enter all valid data")
    public void valid_data()
    {
        register.RegisterSteps("", "Shymaa", "hamed", "17", "05", "1988", "shymaa2356@test.com",
                "assert", "test@123", "test@123");
    }

    @And("user click on register button")
    public void register_button()
    {
        register.RegisterButton();
    }

    @Then("Confirmation Screen displayed")
    public void confirmationScreen()
    {
        soft.assertEquals("https://demo.nopcommerce.com/registerresult/1", Hooks.driver.getCurrentUrl());
    }

    @And ("success message displayed")
    public void success_message()
    {
        String expectedmsg = "Your registration completed";
        String actualmsg = Hooks.driver.findElement(By.className("result")).getText();

        soft.assertEquals(actualmsg,expectedmsg);

    }

    @And ("success message color is green")
    public void success_color()
    {
        String msgcolor = Hooks.driver.findElement(By.className("result")).getCssValue("color");
        String expectedcolor = "rgba(76, 177, 124, 1)";
        soft.assertEquals(msgcolor,expectedcolor);

        soft.assertAll();
    }
}
