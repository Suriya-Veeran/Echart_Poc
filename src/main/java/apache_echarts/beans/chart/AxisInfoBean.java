package apache_echarts.beans.chart;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AxisInfoBean {
    private String type;
    private List<String> data; // Only for x-axis
    private TextStyleBean textStyle;
}
