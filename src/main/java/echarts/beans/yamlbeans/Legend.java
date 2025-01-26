package echarts.beans.yamlbeans;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Legend {
    private boolean show;
    private String position;
    private String orient;
    private TextStyle textStyle;
}
