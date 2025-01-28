package report.interfaces.header;

import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;

public interface LogoInput {
  void setLogoNeeded(boolean isLogoNeeded);

  void setImagePath(String imagePath);

  void setFitWidth(float fitWidth);

  void setFitHeight(float fitHeight);

  void setLogoWidth(float logoWidth);

  void setLogoHeight(float logoHeight);

  void setLogoTextAlignment(TextAlignment logoTextAlignment);

  void setLogoVerticalAlignment(VerticalAlignment logoVerticalAlignment);
}
