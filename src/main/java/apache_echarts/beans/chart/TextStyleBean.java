package apache_echarts.beans.chart;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextStyleBean {

    private int fontSize;
    private String fontFamily;
    private String fontWeight;
    private String color;
}
