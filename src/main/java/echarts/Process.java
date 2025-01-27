package echarts;

import echarts.beans.yamlbeans.ChartConfig;
import echarts.beans.request.ChartRequest;
import echarts.builder.ChartConfigBuilder;
import echarts.chartgenerator.HtmlGenerator;
import echarts.utils.screenshot.HeadlessScreenshot;
import echarts.utils.yaml.YamlFileReader;
import echarts.utils.yaml.YamlFileWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Process {
    private static final Logger log = LoggerFactory.getLogger(Process.class);

    public static void main(String[] args) throws IOException {
        ChartRequest chartRequest = ChartRequest
                .builder()
                .title("Sample Chart")
                .subtitle("")
                .chartType("doughnut")
                .labelPosition("outside")
                .categories(List.of("Category1", "Category2", "Category3"))
                .values(List.of(10, 20, 30))
                .customColors(List.of("#FF0000", "#00FF00", "#0000FF"))
                .legendPosition("center")
                .titlePosition("center")
                        .build();

        ChartConfig chartConfig = ChartConfigBuilder.buildChart(chartRequest);

        YamlFileWriter.writeYamlToFile(chartConfig,"src/main/resources/YamlFiles", "YamlFiles.yml");

        ChartConfig chartConfigByType = YamlFileReader.findChartConfigByType("doughnut", "src/main/resources/YamlFiles/YamlFiles.yml");

        String htmlOutputPath = "src/main/resources/HtmlFiles/chart.html";
        File chartHtmlFile = HtmlGenerator.generateHtmlFromChartConfig(chartConfigByType, htmlOutputPath);

        File file = HeadlessScreenshot.takeScreenshot(chartHtmlFile.toURI().toString(), "Snap.png", "chrome");

        log.info("file was created {}",file.getAbsolutePath());
    }
}
