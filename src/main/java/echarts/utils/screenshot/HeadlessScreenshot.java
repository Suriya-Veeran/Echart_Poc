package echarts.utils.screenshot;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import echarts.config.WebDriverConfig;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HeadlessScreenshot {

    public static File takeScreenshot(String url,
                                      String outputPath,
                                      String browserType) {

        WebDriver driver = WebDriverConfig.createDriver(browserType);  // Use WebDriverConfig to get the appropriate driver
        File screenshotFile = null;

        try {
            driver.get(url);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

            // Scroll to the bottom of the page
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Wait for page to load fully
            Thread.sleep(2000);

            // Take the screenshot
            screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define the destination path
            Path destination = Paths.get(outputPath);
            Files.copy(screenshotFile.toPath(), Path.of("src/main/resources/snapFiles" + File.separator + destination));

        } catch (Exception e) {
            throw new IllegalArgumentException("Error while taking screenshot: " + e.getMessage());
        } finally {
            driver.quit();
        }

        return screenshotFile;

    }
}
