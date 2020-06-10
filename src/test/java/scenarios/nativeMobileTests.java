package scenarios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.imagecomparison.OccurrenceMatchingResult;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;
import utils.ResourceManager;
import utils.ScreenshotAnalysis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.apache.commons.codec.binary.Base64.encodeBase64String;
import static org.testng.Assert.assertTrue;
import static utils.ResourceManager.getProperty;


public class nativeMobileTests extends BaseTest {
    @Test(groups = {"native", "nativeCloud"}, description = "Check that user is on the Budget Activity page after login")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        String email = ResourceManager.getProperty("email");
        String password = ResourceManager.getProperty("password");

        getPo().getWelement("registerBtn").click();
        getPo().getWelement("email").sendKeys(email);
        getPo().getWelement("username").sendKeys(ResourceManager.getProperty("username"));
        getPo().getWelement("password").sendKeys(password);
        getPo().getWelement("confirmPassword").sendKeys(password);
        getPo().getWelement("agreamentsBtn").click();
        getPo().getWelement("registerAccountBtn").click();
        getPo().getWelement("loginEmail").sendKeys(email);
        getPo().getWelement("loginPassword").sendKeys(password);
        getPo().getWelement("signInBtn").click();

        assertTrue(
                getPo().getWelements("navigationBarElements").stream()
                        .anyMatch(we -> we.getText().contains(getProperty("nameOfOpenedPage"))),
                "There is no Budget in title"
        );

        // Log that test finished
        System.out.println("Simplest Android native test done");
    }

    @Test(groups = {"native"}, description = "Check that there is an error message after sign in with empty fields")
    public void nativeWithAutoCompleteTextViewTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException, IOException {
        getPo().getWelement("signInBtn").click();

        byte[] errorMessageImage = Files.readAllBytes(Paths.get(getProperty("pathToImageWithErrorMessage")));
        new WebDriverWait(getDriver(), 10)
                .until(wd -> ((AppiumDriver) wd).findElementByImage(encodeBase64String(errorMessageImage)).isDisplayed());

        OccurrenceMatchingResult analysisResult = ScreenshotAnalysis.findImageOnScreenshot(getDriver(), errorMessageImage);
        Assert.assertNotNull(analysisResult.getRect(), "No error message");

        // Log that test finished
        System.out.println("Android native test with AutoCompleteTextView done");
    }
}
