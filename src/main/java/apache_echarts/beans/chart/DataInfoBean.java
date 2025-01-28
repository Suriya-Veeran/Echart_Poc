package apache_echarts.beans.chart;

import echarts.beans.yamlbeans.ItemStyle;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataInfoBean {
    @Builder.Default
    private String name = "Default";
    @Builder.Default
    private int value = 0;
    @Builder.Default
    private ItemStyle itemStyle = new ItemStyle();
}
