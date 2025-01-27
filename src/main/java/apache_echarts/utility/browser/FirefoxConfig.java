package apache_echarts.utility.browser;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static apache_echarts.constants.WebDriverConfigConstants.*;

@UtilityClass
public class FirefoxConfig {
  public WebDriver createFirefoxDriver() {
    FirefoxOptions options = new FirefoxOptions();
    options.addArguments(HEADLESS_MODE);
    return new FirefoxDriver(options);
  }
}
