package apache_echarts.beans.chart;

import echarts.beans.yamlbeans.ItemStyle;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataInfoBean {
    private String name;
    private int value;
    private ItemStyle itemStyle;
}
