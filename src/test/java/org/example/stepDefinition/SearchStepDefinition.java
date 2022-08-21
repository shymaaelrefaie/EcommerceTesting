package org.example.stepDefinition;

import org.example.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;
import java.util.List;

public class SearchStepDefinition {

    HomePage SearchHP = new HomePage();
    SoftAssert soft = new SoftAssert();

    public SearchStepDefinition() {
    }

    //user search with "<Keyword>" and get search result
    @Given("^user search with \"([^\"]*)\" and get search result$")
    public void Searchkeyword(String keyword) throws InterruptedException {
        SearchHP.getSearchElement().sendKeys(new CharSequence[]{keyword});
        SearchHP.clickonsearchBtn().click();
        Thread.sleep(2000L);
    }

    //user get search result on valid page
    @When("user get search result on valid page")
    public void validateSearchPageURL() {
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
        soft.assertAll();
    }

    //user find each result contains the search word by keyword "<Keyword>"
    @Then("^user find each result contains the search word by keyword \"([^\"]*)\"$")
    public void validateSearchResultValues(String word) {
        List<WebElement> searchkeyword = SearchHP.SearchValues();
        Iterator var3 = searchkeyword.iterator();

        while (var3.hasNext()) {
            WebElement element = (WebElement) var3.next();
            soft.assertTrue(element.getText().toLowerCase().contains(word));
            soft.assertAll();
            System.out.println(element.getText());
        }
    }

    @When("user click on product in search result")
    public void clickOnProduct() {
        SearchHP.clickOnProduct().click();
    }

    @Then("^user find each result contains word by sku \"([^\"]*)\"$")
    public void validateSearchResultValuesWithSku(String skuword) {
        System.out.println("Serial Full value: " + SearchHP.assertSerial().getText());
        String Skuvalue = SearchHP.assertSerial().getText();
        String[] Skuvalueplited = Skuvalue.split(": ");
        System.out.println("Sku Value: " + Skuvalueplited[1].trim());
        Assert.assertTrue(SearchHP.assertSerial().getText().contains(skuword));
        Assert.assertEquals(Skuvalueplited[1].trim(), skuword);
    }


}
