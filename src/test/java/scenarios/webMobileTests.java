package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;
import utils.ResourceManager;

import static org.testng.Assert.assertFalse;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Check that there are search query results in Google")
    public void simpleWebTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getDriver().get(ResourceManager.getProperty("url")); // open Google homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        WebElement searchField = getPo().getWelement("searchField");
        searchField.sendKeys(ResourceManager.getProperty("query"));
        searchField.sendKeys(Keys.ENTER);

        assertFalse(
                getPo().getWelements("results").isEmpty(),
                "No founded results"
        );

        // Log that test finished
        System.out.println("Site opening done");
    }

}
