package org.example.stepDefinition;

import org.example.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class WishlistStepDefinition {

    HomePage HP = new HomePage();
    SoftAssert soft = new SoftAssert();


    @Given("Navigate to products on homepage")
    public void scrollproducts()
    {
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("window.scrollBy(0,-350)", "");
    }

    @When("user click on wish button of product")
    public void pressWishicon() throws InterruptedException {

        List<WebElement> wishlistbtns = Hooks.driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
        wishlistbtns.get(2).click();
        Thread.sleep(3000);
    }

    @Then("Success message displayed")
    public void displaymessage()
    {
        String expectedmsg = "The product has been added to your wishlist";
        String actualmsg = Hooks.driver.findElement(By.className("content")).getText();

        soft.assertEquals(actualmsg,expectedmsg);
    }

    @And("Message background color should be green")
    public void message_green()
    {
        String msgcolor = Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]")).getCssValue("background-color");
        System.out.println(msgcolor);
        String expectedcolor = "rgba(75, 176, 122, 1)";
        soft.assertEquals(msgcolor,expectedcolor);
        soft.assertAll();
    }

    @And("user open wishlist page")
    public void openWishlistpage() throws InterruptedException {
        Thread.sleep(5000L);
        HP.clickWishListLink().click();
    }

    @Then("user can check the product Qty")
    public void validateProductQty() throws InterruptedException {
        Thread.sleep(2000L);
        String QtyValue = HP.getQtyValue().getAttribute("value");
        System.out.println(QtyValue);
        soft.assertNotEquals(QtyValue, "0");
        soft.assertAll();
    }


}
