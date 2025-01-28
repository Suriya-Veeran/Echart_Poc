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
  private String content; // Text content for the header
  private TextAlignment textAlignment; // Text alignment for header content
  private float rightMargin; // Margin for the right side
  private float topMargin; // Margin for the top
  private float leftMargin; // Margin for the left
  private String backgroundColor; // Background color of the header
  private int fontSize; // Font size for header content
  private VerticalAlignment verticalAlignment; // Vertical alignment of header content
  private FontType font; // Enum FontType for font type
}
