package echarts.beans.yamlbeans;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChartConfig {

    private String title;
    private String subtitle;
    private String type;
    private Legend legend;
    private List<Series> series;
    private Animation animation;


}
