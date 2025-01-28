package report.beans.header;

import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogoInputBean {
    private boolean logoNeeded;  // If logo is needed
    private String imagePath;  // Path to the logo image
    private float fitWidth;  // Logo fit width
    private float fitHeight;  // Logo fit height
    private float logoWidth;  // Width of the logo
    private float logoHeight;  // Height of the logo
    private TextAlignment logoTextAlignment;  // Logo text alignment
    private VerticalAlignment logoVerticalAlignment;  // Logo vertical alignment
}
