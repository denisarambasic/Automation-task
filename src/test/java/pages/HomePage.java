package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
    WebDriver driver = null;

    @FindBy(id = "searchInput")
    WebElement searchInputField;

    @FindBy(id = "ca-history")
    WebElement historyTab;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void search(String searchTerm) {
        searchInputField.sendKeys(searchTerm);
        searchInputField.sendKeys(Keys.RETURN);
    }

    public void clickOnHistoryTab() {
        historyTab.click();
    }

}
