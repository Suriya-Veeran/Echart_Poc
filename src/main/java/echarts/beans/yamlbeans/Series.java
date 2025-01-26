package echarts.beans.yamlbeans;

import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Series {
    private String name;
    private String type;
    private List<Data> data;
    private Label label;
    private List<String> radius;
    private Pointer pointer;
    private AxisLine axisLine;
    private Detail detail;
}
