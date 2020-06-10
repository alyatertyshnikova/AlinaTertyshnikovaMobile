package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.imagecomparison.OccurrenceMatchingOptions;
import io.appium.java_client.imagecomparison.OccurrenceMatchingResult;
import org.openqa.selenium.OutputType;

import static org.apache.commons.codec.binary.Base64.encodeBase64;

public class ScreenshotAnalysis {
    public static OccurrenceMatchingResult findImageOnScreenshot(AppiumDriver driver, byte[] image) {
        byte[] screenshot = encodeBase64(driver.getScreenshotAs(OutputType.BYTES));
        return driver.findImageOccurrence(
                screenshot, encodeBase64(image),
                new OccurrenceMatchingOptions()
                        .withThreshold(0.8)
                        .withEnabledVisualization()
        );
    }
}
