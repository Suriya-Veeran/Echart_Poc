package apache_echarts.beans.chart;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AxisPointerBean {
    private String type; // 'line', 'shadow', 'cross'
}
