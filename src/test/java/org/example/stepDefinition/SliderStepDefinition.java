package org.example.stepDefinition;

import org.example.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

public class SliderStepDefinition {

    HomePage sliderHP = new HomePage();
    SoftAssert soft = new SoftAssert();

    @Given("user click on slider nokia")
    public void clickFirstSliderURL() {
        sliderHP.SliderElement().click();
        sliderHP.implicitWait();
    }

    @Then("^system should open in new tab in URL \"(.*)\"$")
    public void assertCurrentURL(String URL) {
        switch (URL) {
            case "Nokia1020":
                soft.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/nokia-lumia-1020");
                soft.assertAll();
                break;
            case "Iphone":
                soft.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/iphone-6");
                soft.assertAll();
        }

    }

    @Given("user click on slider iphone")
    public void clickSecondURL() {
        sliderHP.implicitWaituntill("//*[@id=\"nivo-slider\"]/a[1]", "style", "display: none;");
        sliderHP.SliderElement().click();
        sliderHP.implicitWait();
    }

}
