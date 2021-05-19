package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Urls;

import static org.junit.Assert.*;

public final class MainPage implements Page {
    private final WebDriver driver;

    @FindBy(className = "location-selector__button")
    private WebElement locationSelectorBtn;

    @FindBy(css = "a[href=\"https://careers.epam-poland.pl\"]")
    private WebElement toPolandPage;

    @FindBy(className = "cta-button__text")
    private WebElement contactUs;

    public MainPage(WebDriver driver){
        this.driver = driver;
        Page.setTimeouts(this.driver);
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
        driver.navigate().to(Urls.MAIN.toString());
    }

    // region Test 1
    public void toPoland() {
        this.locationSelectorBtn.click();
        this.toPolandPage.click();
    }

    public void checkPoland() {
        System.out.println(this.driver.getCurrentUrl() + "\t" + Urls.POLSKA);
        assertEquals(Urls.POLSKA.toString(), this.driver.getCurrentUrl());
    }
    // endregion

    // region Test 2
    public void clickContactUs() {
        contactUs.click();
    }

    public void checkContactUs() {
        assertEquals(Urls.CONTACT_US.toString(), this.driver.getCurrentUrl());
    }
    // endregion
}
