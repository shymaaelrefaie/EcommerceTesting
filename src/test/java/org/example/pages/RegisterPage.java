package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.stepDefinition.Hooks;

public class RegisterPage {


    public RegisterPage()
    {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(id="gender")
    WebElement genderPF;

     public WebElement genderPOM()
    {
        WebElement gendarelement = Hooks.driver.findElement(By.id("gender-female"));

        return gendarelement;
    }

    public WebElement FirstNamePOM () { return Hooks.driver.findElement(By.id("FirstName")); }

    public WebElement LastNamePOM () { return Hooks.driver.findElement(By.id("LastName")); }

    public WebElement DateBirthDayPOM () { return Hooks.driver.findElement(By.name("DateOfBirthDay")); }

    public WebElement DateBirthMonthPOM () { return Hooks.driver.findElement(By.name("DateOfBirthMonth")); }

    public WebElement DateBirthYearPOM () { return Hooks.driver.findElement(By.name("DateOfBirthYear")); }

    public WebElement EmailPOM () { return Hooks.driver.findElement(By.name("Email")); }

    public WebElement CompanyPOM () { return Hooks.driver.findElement(By.name("Company")); }

    public WebElement PasswordPOM () { return Hooks.driver.findElement(By.name("Password")); }

    public WebElement ConfirmPasswordPOM () { return Hooks.driver.findElement(By.name("ConfirmPassword")); }

    public void RegisterSteps(String gender, String firstName, String lastName, String day, String month, String year,
                              String email, String company,
                              String password, String confirmpass)
    {
        genderPOM().click();
        FirstNamePOM().sendKeys(firstName);
        LastNamePOM().sendKeys(lastName);
        DateBirthDayPOM().sendKeys(day);
        DateBirthMonthPOM().sendKeys(month);
        DateBirthYearPOM().sendKeys(year);
        EmailPOM().sendKeys(email);
        CompanyPOM().sendKeys(company);
        PasswordPOM().sendKeys(password);
        ConfirmPasswordPOM().sendKeys(confirmpass);

    }

    public void RegisterButton()
    {
        Hooks.driver.findElement(By.id("register-button")).sendKeys(Keys.ENTER);
    }




}
