package selenium;

import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CareersPage;
import pages.CybersecurityPage;
import pages.EventPage;
import pages.MainPage;


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

    @Given("I am on https://www\\.epam\\.com/")
    public void mainPage() {
        createDriver();
        mainPage.navigate();
    }

    @When("^I change location by clicking on Global \\(Polska\\)$")
    public void changeLocationToPolska() {
        mainPage.toPoland();
    }

    @Then("I should see page was translated")
    public void expectPolska() {
        mainPage.checkPoland();
    }

    @When("^I click \"contact us\" button$")
    public void contactUsBtn() {
        mainPage.clickContactUs();
    }

    @Then("^I should get redirected to the contact us page$")
    public void contactUsRedirect() {
        mainPage.checkContactUs();
    }

    @Given("^I am on https://www\\.epam\\.com/about/who-we-are/events$")
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
        eventPage.checkMeetUs();
    }

    @Given("^I am on https://www\\.epam\\.com/services/consult-and-design/enterprise-technology-and-operations-transformation/cybersecurity$")
    public void cybersecurityPage() throws InterruptedException {
        createDriver();
        cybersecurityPage.navigate();
    }

    @When("^I click on \"EXPLORE OUR LATEST WORK\"$")
    public void clickExploreWork() throws InterruptedException {
        cybersecurityPage.clickExploreWork();
    }

    @Then("^I should see several links to the pages with text describing the work$")
    public void latestWorkRedirect() {
        cybersecurityPage.checkExploreWork();
    }

    @When("^I click on privacy policy link$")
    public void clickPrivacyPolicy() {
        cybersecurityPage.clickPrivacyPolicy();
    }

    @Then("^I should be redirected to Privacy policy page$")
    public void policyRedirect() {
        cybersecurityPage.checkPrivatePolicyRedirect();
    }

    @When("^I click on FAQ$")
    public void faqClick() {
        cybersecurityPage.faqClick();
    }

    @Then("^I should be redirected to the FAQ page$")
    public void faqRedirect() {
        cybersecurityPage.checkFaqRedirect();
    }

    @When("^I click on search symbol$")
    public void searchClick() {
        cybersecurityPage.searchClick();
    }

    @Then("^I should see search input box$")
    public void searchInput() {
        cybersecurityPage.checkSearchInput();
    }

    @Given("^I am on https://careers\\.epam\\.by/$")
    public void byCareersPage() {
        createDriver();
        careersPage.navigate();
    }

    @When("^I go to contacts of the company$")
    public void companyContact() {
        careersPage.clickCompanyContact();
    }

    @Then("^I should be able to find mail jobs_by@epam\\.com$")
    public void findMail() {
        careersPage.findMail();
    }
}
