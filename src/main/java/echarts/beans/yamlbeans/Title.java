package echarts.beans.yamlbeans;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Title {
  private String text; // Title text
  private String subtext; // Subtitle text
  private String left; // Position of the title (left, center, right)
}
