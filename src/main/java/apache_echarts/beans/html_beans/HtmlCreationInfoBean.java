package apache_echarts.beans.html_beans;

import apache_echarts.beans.chart.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HtmlCreationInfoBean {

    private ChartBasicInfo chartBasicInfo;
    private TitleInfoBean titleInfoBean;
    private ToolTipInfoBean toolTipInfoBean;
    private LegendInfoBean legendInfoBean;
    private AxisInfoBean xaxisInfoBean;
    private AxisInfoBean yaxisInfoBean;
    private SeriesInfoBean seriesInfoBean;


}
