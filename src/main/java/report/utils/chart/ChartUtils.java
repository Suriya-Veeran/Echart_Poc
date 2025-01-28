package report.utils.chart;

import apache_echarts.beans.html_beans.HtmlCreationInfoBean;
import apache_echarts.enums.BrowserTypes;
import apache_echarts.utility.html.HtmlFileGenerator;
import apache_echarts.utility.screenshot_utils.HeadlessScreenshot;
import apache_echarts.utility.yaml.YamlMapper;
import com.itextpdf.layout.element.Image;

import java.io.File;
import java.io.IOException;

import static apache_echarts.constants.PathConstants.CONFIG_YAML;

public class ChartUtils {

  public Image chartCreation() throws IOException {
    HtmlCreationInfoBean htmlCreationInfoBean = YamlMapper.parseYaml(CONFIG_YAML);

    File htmlFile = HtmlFileGenerator.generateHtml(htmlCreationInfoBean);

     return HeadlessScreenshot.takeScreenshot(
        htmlFile.toURI().toString(),
        BrowserTypes.CHROME.getValue(),
        htmlCreationInfoBean.getChartBasicInfo().getChartType());
  }
}
