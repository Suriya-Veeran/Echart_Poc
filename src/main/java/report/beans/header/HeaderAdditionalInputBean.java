package report.beans.header;

import com.itextpdf.layout.properties.TextAlignment;
import lombok.*;

import java.awt.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeaderAdditionalInputBean {
  private String sectionTitle; // Optional: Section title in the header (for different sections in the report)
  private String dateFormat; // Date format for including current date/time in the header
  private boolean pageNumberNeeded; // Flag to include page number
  private TextAlignment pageNumberAlignment; // Alignment for page number (left, center, right)
  private String textColor; // Text color for header content
  private float paddingLeft; // Padding for left side
  private float paddingTop; // Padding for top side
  private float paddingRight; // Padding for right side
  private float paddingBottom; // Padding for bottom side
}
