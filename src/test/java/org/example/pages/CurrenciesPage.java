package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.example.stepDefinition.Hooks;

import java.util.List;

public class CurrenciesPage {

    public CurrenciesPage()
    {
        PageFactory.initElements(Hooks.driver, this);
    }

    private static List<WebElement> elements = null;

    public void selectcurrency(String currencyname) {
        elements = Hooks.driver.findElements(By.cssSelector("item-grid"));
        for (WebElement element : elements) {
            String myText = element.findElement(By.cssSelector("price")).getText();
            if (myText.contains("€")) {
                System.out.println(myText);
                //return element;
            }
        }
    }

}
