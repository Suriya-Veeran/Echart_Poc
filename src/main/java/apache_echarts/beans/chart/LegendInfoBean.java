package apache_echarts.beans.chart;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LegendInfoBean {
    @Builder.Default
    private String orient = "horizontal"; // 'vertical' or 'horizontal'

    @Builder.Default
    private String left = "center"; // Position of the legend (e.g., 'left', 'right', 'center', 'top', 'bottom')

    @Builder.Default
    private String bottom = "auto"; // Position of the legend (optional if using 'top', 'bottom', 'center', etc.)

    @Builder.Default
    private TextStyleBean textStyle = new TextStyleBean(); // Text style for the legend

    @Builder.Default
    private List<String> data = List.of("Item 1", "Item 2", "Item 3"); // Legend items, which are the names for each data series

}
