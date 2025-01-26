package echarts.builder;

import echarts.beans.request.ChartRequest;
import echarts.beans.yamlbeans.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.ArrayList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChartConfigBuilder {

    public static ChartConfig buildChart(ChartRequest chartRequest) {
        return ChartConfig.builder()
                .title(chartRequest.getTitle())
                .subtitle(chartRequest.getSubtitle())
                .type(chartRequest.getChartType())
                .legend(createLegend(chartRequest.getLegendPosition()))
                .series(createChartSeries(chartRequest))
                .animation(createAnimation())
                .build();
    }

    // Create legend configuration
    private static Legend createLegend(String position) {
        return Legend.builder()
                .show(true)
                .position(position)
                .orient("horizontal")
                .textStyle(new TextStyle("#333", 14))  // Using TextStyle builder
                .build();
    }

    // Create series based on chart type and data
    private static List<Series> createChartSeries(ChartRequest chartRequest) {
        return switch (chartRequest.getChartType().toLowerCase()) {
            case "pie", "doughnut" -> List.of(createPieOrDoughnutSeries(chartRequest));
            case "bar" -> List.of(createBarSeries(chartRequest));
            case "gauge" -> List.of(createGaugeSeries(chartRequest));
            default -> throw new IllegalArgumentException("Unsupported chart type: " + chartRequest.getChartType());
        };
    }

    // Create Pie or Doughnut series based on request data
    private static Series createPieOrDoughnutSeries(ChartRequest chartRequest) {
        return Series.builder()
                .name("Series Name")
                .type("pie")
                .radius(getChartRadius(chartRequest))
                .data(buildPieOrDoughnutData(chartRequest))
                .label(createLabel(chartRequest))
                .build();
    }

    private static List<String> getChartRadius(ChartRequest chartRequest) {
        boolean isDoughnut = chartRequest.getChartType().equalsIgnoreCase("doughnut");
        // Set the radius based on whether it's a doughnut chart or not
        return isDoughnut ? List.of("50%", "70%") : List.of("50%");
    }

    // Build data for Pie or Doughnut charts
    private static List<Data> buildPieOrDoughnutData(ChartRequest chartRequest) {
        List<Data> dataList = new ArrayList<>();
        for (int i = 0; i < chartRequest.getCategories().size(); i++) {
            Data data = Data.builder()
                    .name(chartRequest.getCategories().get(i))
                    .value(chartRequest.getValues().get(i))
                    .itemStyle(new ItemStyle(chartRequest.getCustomColors().get(i)))
                    .build();
            dataList.add(data);
        }
        return dataList;
    }

    // Create label configuration for Pie/Doughnut/Bar charts
    private static Label createLabel(ChartRequest chartRequest) {
        return Label.builder()
                .show(true)
                .position(chartRequest.getLabelPosition())
                .fontSize(12)
                .formatter("{b}: {c} ({d}%)")
                .build();
    }

    // Create Bar chart series based on request data
    private static Series createBarSeries(ChartRequest chartRequest) {
        return Series.builder()
                .name("Bar Series")
                .type("bar")
                .data(buildBarData(chartRequest))
                .label(createLabel(chartRequest))
                .build();
    }

    // Build data for Bar charts
    private static List<Data> buildBarData(ChartRequest chartRequest) {
        List<Data> dataList = new ArrayList<>();
        for (int i = 0; i < chartRequest.getCategories().size(); i++) {
            Data data = Data.builder()
                    .name(chartRequest.getCategories().get(i))
                    .value(chartRequest.getValues().get(i))
                    .build();
            dataList.add(data);
        }
        return dataList;
    }

    // Create Gauge chart series
    private static Series createGaugeSeries(ChartRequest chartRequest) {
        return Series.builder()
                .name("Gauge Series")
                .type("gauge")
                .data(List.of(Data.builder().value(chartRequest.getValues().get(0)).build()))
                .pointer(createPointer())
                .axisLine(createGaugeAxisLine())
                .detail(createGaugeDetail())
                .build();
    }

    // Create pointer configuration for gauge chart
    private static Pointer createPointer() {
        return Pointer.builder()
                .length("60%")
                .width(8)
                .build();
    }

    // Create axis line configuration for gauge chart
    private static AxisLine createGaugeAxisLine() {
        return AxisLine.builder()
                .lineStyle(createGaugeLineStyle())
                .build();
    }

    // Create line style for gauge axis
    private static LineStyle createGaugeLineStyle() {
        return LineStyle.builder()
                .gradient(List.of(
                        List.of("0.3", "#ff0000"),
                        List.of("0.7", "#ff9900"),
                        List.of("1", "#33cc33")
                ))
                .build();
    }

    // Create detail configuration for gauge chart
    private static Detail createGaugeDetail() {
        return Detail.builder()
                .formatter("{value}%")
                .build();
    }

    // Create animation configuration
    private static Animation createAnimation() {
        return Animation.builder()
                .duration(1000)
                .easing("cubicInOut")
                .build();
    }
}
