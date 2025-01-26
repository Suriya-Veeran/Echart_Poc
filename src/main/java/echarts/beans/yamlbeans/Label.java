package echarts.beans.yamlbeans;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Label {
    private boolean show;
    private String position;
    private int fontSize;
    private String formatter;
}
