package echarts.beans.yamlbeans;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LineStyle {
    private List<List<String>> gradient;
}
