package echarts.beans.yamlbeans;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Animation {
    private int duration;
    private String easing;
}
