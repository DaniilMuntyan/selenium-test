package selenium;

import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CareersPage;
import pages.CybersecurityPage;
import pages.EventPage;
import pages.MainPage;

import static org.junit.Assert.*;


public class SeleniumTester {
    private WebDriver driver = null;
    private MainPage mainPage = null;
    private EventPage eventPage = null;
    private CybersecurityPage cybersecurityPage = null;
    private CareersPage careersPage = null;

    private void createDriver() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        eventPage = new EventPage(driver);
        cybersecurityPage = new CybersecurityPage(driver);
        careersPage = new CareersPage(driver);
    }

    @After
    public void closeBrowser(){
        System.out.println("AFTER!!!");
        driver.quit();
    }

    @Given("I am on the main web page")
    public void mainPage() {
        createDriver();
        mainPage.navigate();
    }

    @When("^I change location by clicking on Global \\(Polska\\)$")
    public void changeLocationToPolska() {
        mainPage.toPoland();
    }

    @Then("^I should see page was translated$")
    public void expectPolska() {
        System.out.println(this.driver.getCurrentUrl() + "\t" + Urls.POLSKA);
        assertEquals(Urls.POLSKA.toString(), this.driver.getCurrentUrl());
    }

    @When("^I click \"contact us\" button$")
    public void contactUsBtn() {
        mainPage.clickContactUs();
    }

    @Then("^I should get redirected to the contact us page$")
    public void contactUsRedirect() {
        assertEquals(Urls.CONTACT_US.toString(), this.driver.getCurrentUrl());
    }

    @Given("^About-who-we-are page opened$")
    public void eventsPage() {
        createDriver();
        eventPage.navigate();
    }

    @When("^I click on \"meet us\"$")
    public void iClickOnMeetUs() {
        eventPage.clickOnMeetUs();
    }

    @Then("^I should get all information about the event$")
    public void meetUsRedirect() {
        WebElement details = driver.findElement(By.cssSelector("div[class=\"container event-details-page__container\"]"));
        assertNotNull(details);
    }

    @Given("^Cybersecurity web page opened$")
    public void cybersecurityPage() {
        createDriver();
        cybersecurityPage.navigate();
    }

    @When("^I click on \"EXPLORE OUR LATEST WORK\"$")
    public void clickExploreWork() throws InterruptedException {
        cybersecurityPage.clickExploreWork();
    }

    @Then("^I should see several links to the pages with text describing the work$")
    public void latestWorkRedirect() {
        WebElement latestWorks = driver.findElement(By.className("featured-content-grid-ui"));
        assertNotNull(latestWorks);
    }

    @When("^I click on privacy policy link$")
    public void clickPrivacyPolicy() {
        cybersecurityPage.clickPrivacyPolicy();
    }

    @Then("^I should be redirected to Privacy policy page$")
    public void policyRedirect() {
        assertEquals(Urls.POLICY.toString(), driver.getCurrentUrl());
    }

    @When("^I click on FAQ$")
    public void faqClick() {
        cybersecurityPage.faqClick();
    }

    @Then("^I should be redirected to the FAQ page$")
    public void faqRedirect() {
        assertEquals(Urls.FAQ.toString(), driver.getCurrentUrl());
    }

    @When("^I click on search symbol$")
    public void searchClick() {
        cybersecurityPage.searchClick();
    }

    @Then("^I should see search input box$")
    public void searchInput() {
        WebElement element = driver.findElement(By.cssSelector("button[class=\"header-search__submit\"]"));
        assertTrue(element.isDisplayed());
    }

    @Given("^Careers page opened in By location$")
    public void byCareersPage() {
        createDriver();
        careersPage.navigate();
    }

    @When("^I go to contacts of the company$")
    public void companyContact() {
        careersPage.clickCompanyContact();
    }

    @Then("^I should be able to find the mail of company$")
    public void findMail() {
        WebElement element = driver.findElement(By.cssSelector("a[href=\"mailto:jobs_by@epam.com\"]"));
        assertNotNull(element);
    }
}
