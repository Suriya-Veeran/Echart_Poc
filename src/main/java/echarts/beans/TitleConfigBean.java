package echarts.beans;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TitleConfigBean {

    private String text;
    private String subText;
    private String left;
    private TitleConfigFontInputBean textStyle;
    private TitleConfigFontInputBean subTextStyle;


}
