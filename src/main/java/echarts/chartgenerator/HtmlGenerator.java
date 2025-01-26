package echarts.chartgenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import echarts.beans.yamlbeans.ChartConfig;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HtmlGenerator {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static File generateHtmlFromChartConfig(ChartConfig chartConfig,
                                                   String outputPath) throws IOException {
        // Generate chart-specific JavaScript based on chartType
        String chartScript = generateChartScript(chartConfig);

        // HTML template with StringBuilder for efficiency
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>").append(chartConfig.getTitle()).append("</title>")
                .append("<script src=\"https://cdn.jsdelivr.net/npm/echarts/dist/echarts.min.js\"></script>")
                .append("</head>")
                .append("<body>")
                .append("<div id=\"chart\" style=\"width: 600px; height: 400px;\"></div>")
                .append("<script>")
                .append(chartScript)
                .append("</script>")
                .append("</body>")
                .append("</html>");

        File outputFile = new File(outputPath);

        // Write the HTML to the specified file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(htmlContent.toString());
        }
        return outputFile;
    }

    private static String generateChartScript(ChartConfig chartConfig) throws IOException {
        // Base chart configuration as JSON
        String baseConfigJson = objectMapper.writeValueAsString(chartConfig);

        // Dynamically handle chartType
        return switch (chartConfig.getType().toLowerCase()) {
            case "pie" -> generatePieChartScript(baseConfigJson);
            case "bar" -> generateBarChartScript(baseConfigJson);
            case "gauge" -> generateGaugeChartScript(baseConfigJson);
            default -> throw new IllegalArgumentException("Unsupported chart type: " + chartConfig.getType());
        };
    }

    private static String generatePieChartScript(String baseConfigJson) {
        StringBuilder script = new StringBuilder();
        script.append("var chart = echarts.init(document.getElementById('chart'));")
                .append("var options = ").append(baseConfigJson).append(";")
                .append("chart.setOption({")
                .append("title: { text: options.title, subtext: options.subtitle },")
                .append("tooltip: { trigger: 'item' },")
                .append("legend: options.legend,")
                .append("series: [{")
                .append("name: 'Data',")
                .append("type: 'pie',")
                .append("radius: '50%',")
                .append("data: options.series[0].data,")
                .append("emphasis: {")
                .append("itemStyle: {")
                .append("shadowBlur: 10,")
                .append("shadowOffsetX: 0,")
                .append("shadowColor: 'rgba(0, 0, 0, 0.5)'")
                .append("}")
                .append("}")
                .append("}]")
                .append("});");

        return script.toString();
    }

    private static String generateBarChartScript(String baseConfigJson) {
        StringBuilder script = new StringBuilder();
        script.append("var chart = echarts.init(document.getElementById('chart'));")
                .append("var options = ").append(baseConfigJson).append(";")
                .append("chart.setOption({")
                .append("title: { text: options.title, subtext: options.subtitle },")
                .append("tooltip: { trigger: 'axis' },")
                .append("legend: options.legend,")
                .append("xAxis: { type: 'category', data: options.series[0].data.map(d => d.name) },")
                .append("yAxis: { type: 'value' },")
                .append("series: [{")
                .append("name: 'Data',")
                .append("type: 'bar',")
                .append("data: options.series[0].data.map(d => d.value)")
                .append("}]")
                .append("});");

        return script.toString();
    }

    private static String generateGaugeChartScript(String baseConfigJson) {
        StringBuilder script = new StringBuilder();
        script.append("var chart = echarts.init(document.getElementById('chart'));")
                .append("var options = ").append(baseConfigJson).append(";")
                .append("chart.setOption({")
                .append("title: { text: options.title, subtext: options.subtitle },")
                .append("tooltip: { formatter: '{a} <br/>{b} : {c}%' },")
                .append("series: [{")
                .append("name: 'Data',")
                .append("type: 'gauge',")
                .append("detail: { formatter: '{value}%' },")
                .append("data: options.series[0].data")
                .append("}]")
                .append("});");

        return script.toString();
    }
}
