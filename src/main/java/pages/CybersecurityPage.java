package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Urls;

import static org.junit.Assert.*;

public class CybersecurityPage implements Page {
    private final WebDriver driver;

    @FindBy(css = "a[class=\"button-ui bg-color-light-blue standard\"][data-gtm-action=\"click\"]")
    private WebElement exploreOurWorkBtn;

    @FindBy(css = "a[class=\"footer__links-item\"][href=\"/privacy-policy\"]")
    private WebElement privacyPolicyBtn;

    @FindBy(css = "a[href=\"/about\"]")
    private WebElement about;

    @FindBy(css = "button[class=\"header-search__button header__icon\"]")
    private WebElement searchBtn;

    public CybersecurityPage(WebDriver driver){
        this.driver = driver;
        Page.setTimeouts(this.driver);
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
        driver.navigate().to(Urls.SECURITY_PAGE.toString());
    }

    // region Test 4
    public void clickExploreWork() {
        Actions actions = new Actions(driver);
        actions.moveToElement(exploreOurWorkBtn).click().build().perform();
    }
    // endregion

    // region Test 5
    public void clickPrivacyPolicy() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", privacyPolicyBtn);
    }
    // endregion

    // region Test 6
    public void faqClick() {
        Actions action = new Actions(driver);
        action.moveToElement(about).build().perform();
        driver.findElement(By.cssSelector("a[href=\"/about/investors/faq\"]")).click();
    }
    // endregion

    // region Test 7
    public void searchClick() {
        searchBtn.click();
    }
    // endregion

}
