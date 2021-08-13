package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HistoryPage;
import pages.HomePage;
import utils.Helper;
import utils.MyReport;

import java.util.Date;


public class Search {
    WebDriver driver;
    String url = "https://www.wikipedia.org";
    HomePage homePage;
    HistoryPage historyPage;
    MyReport myReport = new MyReport();
    Date start;
    Date end;
    String browsers = "Chrome";

    @Before
    public void setUp() {
        start = new Date();
        WebDriverManager.chromedriver().setup();

        if(Helper.isHeadlessMode()){
            browsers = "Headless";
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }else{
            driver = new ChromeDriver();
        }

        homePage = new HomePage(driver);
        historyPage = new HistoryPage(driver);
        myReport = new MyReport();
        driver.manage().window().maximize();

    }

    @Given("^user is on homepage$")
    public void user_is_on_homepage(){
        driver.get(url);
    }

    @When("^user enters search term as (.+) and confirms search$")
    public void searchBySearchTerm(String searchterm) {
        homePage.search(searchterm);
    }

    @And("^user clicks on History tab to open the History page$")
    public void openHistoryPage() {
        homePage.clickOnHistoryTab();
    }

    @And("^user clicks on the filter tab to open the filter section$")
    public void openFilterSection() {
        historyPage.openFilterSection();
    }

    @And("^user enters filter date as (.+) and confirms search$")
    public void filterByDate(String filterDate) {
        historyPage.filterByDate(filterDate);
    }


    @Then("^first search result timestamp matches expected timestamp as (.+)$")
    public void first_search_result_timestamp_matches_expected_timestamp_as(String expectedTimestamp) {
        Assert.assertEquals(expectedTimestamp, historyPage.getFirstResultDate());
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "");
        }

        end = new Date();
        myReport.generateReport(start, end, browsers);

        Helper.sleep(1000);
        driver.quit();
    }

}
