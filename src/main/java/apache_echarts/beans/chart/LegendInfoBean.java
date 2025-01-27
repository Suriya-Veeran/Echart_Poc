package apache_echarts.beans.chart;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LegendInfoBean {
    private String orient; // 'vertical' or 'horizontal'
    private String left; // Position of the legend (e.g., 'left', 'right', 'center', 'top', 'bottom')
    private String bottom; // Position of the legend (optional if using 'top', 'bottom', 'center', etc.)
    private TextStyleBean textStyle; // Text style for the legend
    private List<String> data; // Legend items, which are the names for each data series

}
