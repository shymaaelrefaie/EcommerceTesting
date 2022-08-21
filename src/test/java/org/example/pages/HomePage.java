package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.example.stepDefinition.Hooks;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(className = "price")
    public List<WebElement> products;

    public void openFbNewtab() throws InterruptedException {

        Thread.sleep(3000);

        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        Hooks.driver.switchTo().window(tabs.get(1));

        System.out.println(Hooks.driver.getCurrentUrl());
        System.out.println(Hooks.driver.getTitle());

        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.facebook.com/nopCommerce");

        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));

        System.out.println(Hooks.driver.getCurrentUrl());
        System.out.println(Hooks.driver.getTitle());
    }

    public void openTwitterNewtab() throws InterruptedException {

        Thread.sleep(3000);

        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        Hooks.driver.switchTo().window(tabs.get(1));

        System.out.println(Hooks.driver.getCurrentUrl());
        System.out.println(Hooks.driver.getTitle());

        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://twitter.com/nopCommerce");

        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));

        System.out.println(Hooks.driver.getCurrentUrl());
        System.out.println(Hooks.driver.getTitle());
    }

    public void openYoutubeNewtab() throws InterruptedException {

        Thread.sleep(3000);

        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        Hooks.driver.switchTo().window(tabs.get(1));

        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.youtube.com/user/nopCommerce");

        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));

    }

    public void openRssNewtab() throws InterruptedException {

        Thread.sleep(3000);

        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        Hooks.driver.switchTo().window(tabs.get(1));

        System.out.println(Hooks.driver.getCurrentUrl());
        System.out.println(Hooks.driver.getTitle());

        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/new-online-store-is-open");

        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));

        System.out.println(Hooks.driver.getCurrentUrl());
        System.out.println(Hooks.driver.getTitle());
    }

    public void NokiaSlider() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)Hooks.driver;

        js.executeScript("arguments[0].click();", Hooks.driver.findElements(By.cssSelector("div[id=\"nivo-slider\"] [class=\"dot\"]")).get(6));
        Thread.sleep(1000);

    }

    public WebElement clickWishlistBtn() {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]"));
    }

    public WebElement clickWishListLink() {
        return Hooks.driver.findElement(By.className("wishlist-label"));
    }

    public WebElement getQtyValue() {
        return Hooks.driver.findElement(By.className("qty-input"));
    }

    public List<WebElement> getMainCategories() {
        return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
    }

    public WebElement getPageTile() {
        return Hooks.driver.findElement(By.className("page-title"));
    }


    public WebElement getSearchElement() {
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    public WebElement clickonsearchBtn() {
        return Hooks.driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button"));
    }

    public List<WebElement> SearchValues() {
        return Hooks.driver.findElements(By.className("product-title"));
    }

    public WebElement clickOnProduct() {
        return Hooks.driver.findElement(By.className("product-title"));
    }

    public WebElement assertSerial() {
        return Hooks.driver.findElement(By.className("sku"));
    }

    public WebElement SliderElement() {
        return Hooks.driver.findElement(By.id("nivo-slider"));
    }

    public void implicitWait() {
        Hooks.driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
    }

    public void implicitWaituntill(String elementpath, String elementattribute, String attributevalue) {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(30L));
        wait.until(ExpectedConditions.attributeToBe(By.xpath(elementpath), elementattribute, attributevalue));
    }
}

