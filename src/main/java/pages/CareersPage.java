package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Urls;

import static org.junit.Assert.assertNotNull;

public class CareersPage implements Page {
    private final WebDriver driver;

    @FindBy(css = "a[href=\"/request-information\"]")
    private WebElement companyContact;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        Page.setTimeouts(this.driver);
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
        driver.navigate().to(Urls.BY_CAREERS.toString());
    }

    // region Test 8
    public void clickCompanyContact() {
        companyContact.click();
    }
    // endregion
}