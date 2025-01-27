package apache_echarts.beans.chart;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolTipInfoBean {

    private String trigger; // 'item' or 'axis'
    private AxisPointerBean axisPointer; // Configuration for axis pointer (if trigger is 'axis')
    private String formatter; // Tooltip format string  Format of the tooltip (e.g., '{b}: {c} ({d}%)')
    private String backgroundColor; // Background color of the tooltip
    private String borderColor; // Border color of the tooltip
    private int borderWidth; // Border width
    private List<Integer> padding; // Padding for the tooltip
    private TextStyleBean textStyle; // Text style for the tooltip
    private String extraCssText; // Extra CSS styling

}
