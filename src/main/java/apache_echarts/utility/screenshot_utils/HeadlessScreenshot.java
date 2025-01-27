package apache_echarts.utility.screenshot_utils;

import apache_echarts.utility.webdriver.WebDriverConfig;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

import static apache_echarts.constants.FileFormatConstants.PNG_WITH_EXTENSION;
import static apache_echarts.constants.FileNameConstants.SNAP;
import static apache_echarts.constants.JavaScriptConstants.BODY_TAG_NAME;
import static apache_echarts.constants.JavaScriptConstants.SCROLL_SCRIPT;
import static apache_echarts.constants.PathConstants.*;
import static apache_echarts.constants.SpecialCharacterConstants.HYPHEN;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HeadlessScreenshot {

  public static void takeScreenshot(String url, String browserType, String chartType) {

    File screenshotFile;
    WebDriver driver = WebDriverConfig.getInstance(browserType);
    try {
      driver.get(url);
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(BODY_TAG_NAME)));
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript(SCROLL_SCRIPT);
      Thread.sleep(2000);
      screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      Files.copy(
          screenshotFile.toPath(),
          Path.of(SNAP_FILES + File.separator + SNAP + HYPHEN + chartType + PNG_WITH_EXTENSION));
    } catch (IOException e) {
      throw new IllegalArgumentException("Error while taking screenshot: " + e.getMessage());
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new IllegalStateException("Thread was interrupted while taking a screenshot", e);
    } finally {
      driver.quit();
    }
  }
}
