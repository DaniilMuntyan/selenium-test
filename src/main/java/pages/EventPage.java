package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Urls;

public final class EventPage implements Page{
    private final WebDriver driver;

    @FindBy(className = "upcoming-event__link")
    private WebElement upcomingEventLink;

    public EventPage(WebDriver driver){
        this.driver = driver;
        Page.setTimeouts(this.driver);
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
        driver.navigate().to(Urls.EVENT_PAGE.toString());
    }

    // region Test 3
    public void clickOnMeetUs() {
        Actions actions = new Actions(driver);
        actions.moveToElement(upcomingEventLink).click().build().perform();
    }
    // endregion

}
