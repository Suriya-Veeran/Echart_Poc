package echarts;

import echarts.beans.yamlbeans.ChartConfig;
import echarts.beans.request.ChartRequest;
import echarts.builder.ChartConfigBuilder;
import echarts.chartgenerator.HtmlGenerator;
import echarts.utils.screenshot.HeadlessScreenshot;
import echarts.utils.yamlUtils.YamlFileReader;
import echarts.utils.yamlUtils.YamlFileWriter;
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
                .subtitle("This is a sample subtitle")
                .chartType("pie")
                .labelPosition("top")
                .categories(List.of("Category1", "Category2", "Category3"))
                .values(List.of(10, 20, 30))
                .customColors(List.of("#FF0000", "#00FF00", "#0000FF"))
                .labelPosition("center")
                        .build();

        ChartConfig chartConfig = ChartConfigBuilder.buildChart(chartRequest);

        YamlFileWriter.writeYamlToFile(chartConfig,"src/main/resources/YamlFiles", "YamlFiles.yml");

        ChartConfig chartConfigByType = YamlFileReader.findChartConfigByType("pie", "src/main/resources/YamlFiles/YamlFiles.yml");

        String htmlOutputPath = "src/main/resources/HtmlFiles/chart.html";
        File chartHtmlFile = HtmlGenerator.generateHtmlFromChartConfig(chartConfigByType, htmlOutputPath);

        File file = HeadlessScreenshot.takeScreenshot(chartHtmlFile.toURI().toString(), "Snap.png", "chrome");

        log.info("file was created {}",file.getAbsolutePath());
    }
}
