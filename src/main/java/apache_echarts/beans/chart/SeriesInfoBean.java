package apache_echarts.beans.chart;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeriesInfoBean {
  private String name; // Name of the series (e.g., 'pie', 'bar', etc.)
  private String type; // Type of the chart (e.g., 'pie', 'bar', 'gauge')
  private List<DataInfoBean> data; // Data points in the series
  private LabelInfoBean label; // Label configuration
  private List<String> radius; // Radius for pie or doughnut chart (Optional)
}
