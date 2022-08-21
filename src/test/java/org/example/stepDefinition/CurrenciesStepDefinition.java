package org.example.stepDefinition;

import org.example.pages.CurrenciesPage;
import org.example.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class CurrenciesStepDefinition {


    CurrenciesPage currency = new CurrenciesPage();
    HomePage HP = new HomePage();
    SoftAssert soft = new SoftAssert();

    @Given("user navigates to home page")
    public void user_navigates()
    {
        Hooks.driver.navigate().to("https://demo.nopcommerce.com");
    }


    @When("user select euro from dropdownlist")
    public void selectEuro()
    {
        Select currency = new Select(Hooks.driver.findElement(By.id("customerCurrency")));
        currency.selectByVisibleText("Euro");
    }

    @Then("user display item with euro currency")
    public void displayItems()
    {
         boolean EuroFlag = true;
        for(int i=0; i<4; i++)
        {
            if(HP.products.get(i).getText().contains("€") == false)
            {
                EuroFlag = false;
                break;
            }
        }

        soft.assertTrue(EuroFlag);
        soft.assertAll();
    }
}
