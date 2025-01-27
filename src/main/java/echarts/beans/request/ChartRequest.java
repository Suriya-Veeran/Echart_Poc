package echarts.beans.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ChartRequest {
    private String chartType;
    private String title;
    private String subtitle;
    private List<String> categories;
    private List<Integer> values;
    private List<String> customColors;
    private String legendPosition;
    private String labelPosition;
    private String titlePosition;
}
