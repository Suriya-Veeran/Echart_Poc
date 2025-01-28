package report.beans.header;

import com.itextpdf.layout.properties.TextAlignment;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeaderAdditionalInputBean {
    @Builder.Default
    private String sectionTitle = ""; // Optional: Section title in the header (for different sections in the report)

    @Builder.Default
    private String dateFormat = "yyyy-MM-dd"; // Date format for including current date/time in the header

    @Builder.Default
    private boolean pageNumberNeeded = false; // Flag to include page number

    @Builder.Default
    private TextAlignment pageNumberAlignment = TextAlignment.LEFT; // Alignment for page number (left, center, right)

    @Builder.Default
    private String textColor = "#000000"; // Text color for header content

    @Builder.Default
    private float paddingLeft = 10.0f; // Padding for left side

    @Builder.Default
    private float paddingTop = 10.0f; // Padding for top side

    @Builder.Default
    private float paddingRight = 10.0f; // Padding for right side

    @Builder.Default
    private float paddingBottom = 10.0f; // Padding for bottom side
}
