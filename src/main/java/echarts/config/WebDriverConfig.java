package echarts.config;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Locale;

import static echarts.constants.WebDriverConfigConstants.*;

@UtilityClass
public class WebDriverConfig {

    public static WebDriver createDriver(String browserType) {
        browserType = browserType.toLowerCase(Locale.ROOT);

        return switch (browserType) {
            case "chrome" -> createChromeDriver();
            case "firefox" -> createFirefoxDriver();
            case "edge" -> createEdgeDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserType);
        };
    }

    private WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(HEADLESS_MODE);
        options.addArguments(DISABLE_GPU);
        options.addArguments(WINDOW_SIZE);
        return new ChromeDriver(options);
    }

    private WebDriver createFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(HEADLESS_MODE);
        return new FirefoxDriver(options);
    }

    private WebDriver createEdgeDriver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments(HEADLESS_MODE);
        options.addArguments(DISABLE_GPU);
        options.addArguments(WINDOW_SIZE);
        return new EdgeDriver(options);
    }


}
