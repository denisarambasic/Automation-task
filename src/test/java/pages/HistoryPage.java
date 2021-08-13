package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HistoryPage {
    WebDriver driver = null;

    @FindBy(id = "mw-history-search")
    WebElement filterTab;

    @FindBy(id = "mw-input-date-range-to")
    WebElement dateField;

    @FindBy(xpath = "(//input[@class='oo-ui-inputWidget-input'])[1]")
    WebElement dateInputField;

    @FindBy(xpath = "//ul[@id='pagehistory']/li[1]/a")
    WebElement firstResultDate;

    public HistoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void openFilterSection() {
        filterTab.click();
    }

    public void filterByDate(String filterDate) {
        dateField.click();

        dateInputField.sendKeys(filterDate);

        dateInputField.sendKeys(Keys.RETURN);
    }

    public String getFirstResultDate() {
        return firstResultDate.getText();
    }

}
