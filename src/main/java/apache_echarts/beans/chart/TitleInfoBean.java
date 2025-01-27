package apache_echarts.beans.chart;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TitleInfoBean {

    private String text;  // title
    private String subText; // subTitle
    private String left;   // left values -> center , right , top , ''
    private String bottom; // bottom values -> bottom , center , right , top , ''
    private String top; // adjust the position of the text
    private TextStyleBean textStyle;
    private TextStyleBean subTextStyle;


}
