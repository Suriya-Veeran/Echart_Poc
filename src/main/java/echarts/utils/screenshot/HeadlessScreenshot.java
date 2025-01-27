package echarts.utils.screenshot;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
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

        Path destination = Paths.get(outputPath);
        WebDriver driver = WebDriverConfig.createDriver(browserType);
        File screenshotFile = null;

        try {
            driver.get(url);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            Thread.sleep(2000);

            screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            if (Files.exists(Path.of("src/main/resources/snapFiles" + File.separator + destination))) {
                Files.delete(destination); // Delete the existing file
            }
            Files.copy(screenshotFile.toPath(), Path.of("src/main/resources/snapFiles" + File.separator + destination));

        } catch (IOException  e) {
            throw new IllegalArgumentException("Error while taking screenshot: " + e.getMessage());
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Thread was interrupted while taking a screenshot", e);
        }
        finally {
            driver.quit();
        }

        return screenshotFile;

    }
}
