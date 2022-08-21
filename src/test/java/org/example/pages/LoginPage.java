package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.example.stepDefinition.Hooks;

public class LoginPage {

    public LoginPage()
    {
        PageFactory.initElements(Hooks.driver, this);
    }


    public WebElement emailPOM () { return Hooks.driver.findElement(By.id("Email")); }

    public WebElement passwordPOM () { return Hooks.driver.findElement(By.id("Password")); }

    public void loginsteps(String username, String password)
    {
        emailPOM().sendKeys(username);
        passwordPOM().sendKeys(password);
        passwordPOM().sendKeys(Keys.ENTER);
    }

    public void invalidloginsteps(String username, String password)
    {
        emailPOM().sendKeys(username);
        passwordPOM().sendKeys(password);
        passwordPOM().sendKeys(Keys.ENTER);
    }
}
