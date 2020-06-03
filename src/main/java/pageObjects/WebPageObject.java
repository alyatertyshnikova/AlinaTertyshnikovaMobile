package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebPageObject {
    @FindBy(xpath = "//input[@name='q']")
    WebElement searchField;

    @FindBy(xpath = "//div[@class='mnr-c xpd O9g5cc uUPGi']")
    List<WebElement> results;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }
}
