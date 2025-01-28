package report.beans.header;

import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import lombok.*;
import report.enums.FontType;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeaderTitleInputBean {
  @Builder.Default
  private String content = ""; // Text content for the header

  @Builder.Default
  private TextAlignment textAlignment = TextAlignment.LEFT; // Text alignment for header content

  @Builder.Default
  private float rightMargin = 0.0f; // Margin for the right side

  @Builder.Default
  private float topMargin = 0.0f; // Margin for the top

  @Builder.Default
  private float leftMargin = 0.0f; // Margin for the left

  @Builder.Default
  private String backgroundColor = "#FFFFFF"; // Background color of the header

  @Builder.Default
  private int fontSize = 12; // Font size for header content

  @Builder.Default
  private VerticalAlignment verticalAlignment = VerticalAlignment.TOP; // Vertical alignment of header content

  @Builder.Default
  private FontType font = FontType.HELVETICA_BOLD; // Enum FontType for font type
}
