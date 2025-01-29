package echarts.beans.yamlbeans;

import apache_echarts.beans.chart.ItemStyle;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    private String name;
    private int value;
    private ItemStyle itemStyle;
}
