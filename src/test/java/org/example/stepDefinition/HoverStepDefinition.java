package org.example.stepDefinition;

import org.example.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoverStepDefinition {

    SoftAssert soft = new SoftAssert();
    HomePage HP = new HomePage();
    SoftAssert softassert = new SoftAssert();
    Actions actions;
    public static int selectedCategory;
    int NOselectedSubCategory;
    List<WebElement> subCategoryLinks;
    List<WebElement> mainCategories;
    String locator;
    String selectsubCategoryText;
    String selectedMainCategoryText;

    public HoverStepDefinition() {
        this.actions = new Actions(Hooks.driver);
    }

    @Given("user hover on one category")
    public void hoverMainCategories() throws InterruptedException {
        mainCategories = HP.getMainCategories();
        int count = mainCategories.size();
        int min = 0;
        int max = count - 1;
        selectedCategory = (int)Math.floor(Math.random() * (double)(max - min + 1) + (double)min);
        actions.moveToElement((WebElement)mainCategories.get(selectedCategory)).perform();
        selectedMainCategoryText = ((WebElement)mainCategories.get(selectedCategory)).getText();
        System.out.println("Main category is selected:   " + this.selectedMainCategoryText);
        Thread.sleep(2000L);
    }

    @When("user can view sub-category")
    public void SubCategory() {
        ++selectedCategory;
        this.locator = "(//ul[@class='top-menu notmobile']//ul)[" + selectedCategory + "]/li";
        this.subCategoryLinks = Hooks.driver.findElements(By.xpath(this.locator));
        Hooks.driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
    }

    @Then("user can select sub category")
    public void slectSubcategory() throws InterruptedException {
        if (selectedCategory > 0 && selectedCategory <= 3) {
            int count = this.subCategoryLinks.size();
            int min = 0;
            int max = count - 1;
            NOselectedSubCategory = (int)Math.floor(Math.random() * (double)(max - min + 1) + (double)min);
            this.actions.moveToElement((WebElement)this.subCategoryLinks.get(this.NOselectedSubCategory)).perform();
            this.selectsubCategoryText = ((WebElement)this.subCategoryLinks.get(this.NOselectedSubCategory)).getText();
            System.out.println("Sub category is selected:   " + this.selectsubCategoryText);
            Thread.sleep(1000L);
            ((WebElement)this.subCategoryLinks.get(this.NOselectedSubCategory)).click();
            this.softassert.assertEquals(HP.getPageTile().getText().toLowerCase().trim(), this.selectsubCategoryText.toLowerCase().trim());
            this.softassert.assertAll();
        } else {
            ((WebElement)this.mainCategories.get(selectedCategory - 1)).click();
            this.softassert.assertEquals(HP.getPageTile().getText().toLowerCase().trim(), this.selectedMainCategoryText.toLowerCase().trim());
            this.softassert.assertAll();
        }

        Hooks.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
    }

}
