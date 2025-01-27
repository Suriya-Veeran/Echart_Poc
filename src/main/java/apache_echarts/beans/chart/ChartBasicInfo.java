package apache_echarts.beans.chart;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChartBasicInfo {

    private String language;  // language of the html page
    private String charSet;   // charset like UTF
    private String title;     // title of the page
    private String chartWidth; // chart width
    private String chartHeight; // chart height
    private String chartType;  // chartType


}
