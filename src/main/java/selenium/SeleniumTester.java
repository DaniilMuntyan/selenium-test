package selenium;

import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.Assert.*;

public class SeleniumTester {
    WebDriver driver = null;

    private void createDriver() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @After
    public void closeBrowser(){
        System.out.println("AFTER!!!");
        driver.quit();
    }

    @Given("I am on https://www\\.epam\\.com/")
    public void mainPage() throws InterruptedException {
        createDriver();
        driver.navigate().to(Urls.MAIN.toString());
        Thread.sleep(600);
    }

    @When("^I change location by clicking on Global \\(Polska\\)$")
    public void changeLocationToPolska() throws InterruptedException {
        System.out.println("before changeLocationToPolska");
        driver.findElement(By.className("location-selector__button")).click();
        Thread.sleep(400);
        driver.findElement(By.cssSelector("a[href=\"https://careers.epam-poland.pl\"]")).click();
        Thread.sleep(400);
        System.out.println("after changeLocationToPolska");
    }

    @Then("I should see page was translated")
    public void expectPolska() throws InterruptedException {
        Thread.sleep(500);
        System.out.println(driver.getCurrentUrl() + "\t" + Urls.POLSKA);
        assertEquals(Urls.POLSKA.toString(), driver.getCurrentUrl());
    }


    @When("^I click \"contact us\" button$")
    public void contactUsBtn() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.className("cta-button__text")).click();
    }

    @Then("^I should get redirected to the contact us page$")
    public void contactUsRedirect() throws InterruptedException {
        Thread.sleep(500);
        assertEquals(Urls.CONTACT_US.toString(), driver.getCurrentUrl());
    }

    @Given("^I am on https://www\\.epam\\.com/about/who-we-are/events$")
    public void eventsPage() throws InterruptedException {
        createDriver();
        driver.navigate().to(Urls.EVENT_PAGE.toString());
        Thread.sleep(500);
    }

    @When("^I click on \"meet us\"$")
    public void iClickOn() throws InterruptedException {
        WebElement element = driver.findElement(By.className("upcoming-event__link"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        Thread.sleep(500);
    }

    @Then("^I should get all information about the event$")
    public void meetUsRedirect() throws InterruptedException {
        Thread.sleep(800);
        WebElement details = driver.findElement(By.cssSelector("div[class=\"container event-details-page__container\"]"));
        assertNotNull(details);
    }

    @Given("^I am on https://www\\.epam\\.com/services/consult-and-design/enterprise-technology-and-operations-transformation/cybersecurity$")
    public void cybersecurityPage() throws InterruptedException {
        createDriver();
        driver.navigate().to(Urls.SECURITY_PAGE.toString());
        Thread.sleep(500);
    }

    @When("^I click on \"EXPLORE OUR LATEST WORK\"$")
    public void clickExploreWork() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector("a[class=\"button-ui bg-color-light-blue standard\"][data-gtm-action=\"click\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        Thread.sleep(200);
    }

    @Then("^I should see several links to the pages with text describing the work$")
    public void latestWorkRedirect() {
        WebElement latestWorks = driver.findElement(By.className("featured-content-grid-ui"));
        assertNotNull(latestWorks);
    }

    @When("^I click on privacy policy link$")
    public void clickPrivacyPolicy() throws InterruptedException {
        Thread.sleep(500);
        WebElement element = driver.findElement(By.cssSelector("a[class=\"footer__links-item\"][href=\"/privacy-policy\"]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(600);
    }

    @Then("^I should be redirected to Privacy policy page$")
    public void policyRedirect() {
        assertEquals(Urls.POLICY.toString(), driver.getCurrentUrl());
    }

    @When("^I click on FAQ$")
    public void faqClick() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector("a[href=\"/about\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.findElement(By.cssSelector("a[href=\"/about/investors/faq\"]")).click();
        Thread.sleep(500);
    }

    @Then("^I should be redirected to the FAQ page$")
    public void faqRedirect() {
        assertEquals(Urls.FAQ.toString(), driver.getCurrentUrl());
    }

    @When("^I click on search symbol$")
    public void searchClick() throws InterruptedException {
        driver.findElement(By.cssSelector("button[class=\"header-search__button header__icon\"]")).click();
        Thread.sleep(500);
    }

    @Then("^I should see search input box$")
    public void searchInput() {
        WebElement element = driver.findElement(By.cssSelector("button[class=\"header-search__submit\"]"));
        assertTrue(element.isDisplayed());
    }

    @Given("^I am on https://careers\\.epam\\.by/$")
    public void byCareersPage() throws InterruptedException {
        createDriver();
        driver.navigate().to(Urls.BY_CAREERS.toString());
        Thread.sleep(500);
    }

    @When("^I go to contacts of the company$")
    public void companyContact() throws InterruptedException {
        driver.findElement(By.cssSelector("a[href=\"/request-information\"]")).click();
        Thread.sleep(500);
    }

    @Then("^I should be able to find mail jobs_by@epam\\.com$")
    public void findMail() {
        WebElement element = driver.findElement(By.cssSelector("a[href=\"mailto:jobs_by@epam.com\"]"));
        assertNotNull(element);
    }
}
