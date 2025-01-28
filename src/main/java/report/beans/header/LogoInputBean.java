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
    @Builder.Default
    private boolean logoNeeded = false; // If logo is needed

    @Builder.Default
    private String imagePath = ""; // Path to the logo image

    @Builder.Default
    private float fitWidth = 0.0f; // Logo fit width

    @Builder.Default
    private float fitHeight = 0.0f; // Logo fit height

    @Builder.Default
    private float logoWidth = 0.0f; // Width of the logo

    @Builder.Default
    private float logoHeight = 0.0f; // Height of the logo

    @Builder.Default
    private TextAlignment logoTextAlignment = TextAlignment.LEFT; // Logo text alignment

    @Builder.Default
    private VerticalAlignment logoVerticalAlignment = VerticalAlignment.TOP; // Logo vertical alignment
}
