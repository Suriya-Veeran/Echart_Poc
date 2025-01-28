package report.implementations.header_impl;

import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import lombok.Getter;
import lombok.Setter;
import report.interfaces.header.LogoInput;

@Getter
@Setter
public class LogoInputBeanImpl implements LogoInput {

  private boolean isLogoNeeded;
  private String imagePath;
  private float fitWidth;
  private float fitHeight;
  private float logoWidth;
  private float logoHeight;
  private TextAlignment logoTextAlignment;
  private VerticalAlignment logoVerticalAlignment;

  @Override
  public void setLogoNeeded(boolean isLogoNeeded) {
    this.isLogoNeeded = isLogoNeeded;
  }

  @Override
  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  @Override
  public void setFitWidth(float fitWidth) {
    this.fitWidth = fitWidth;
  }

  @Override
  public void setFitHeight(float fitHeight) {
    this.fitHeight = fitHeight;
  }

  @Override
  public void setLogoWidth(float logoWidth) {
    this.logoWidth = logoWidth;
  }

  @Override
  public void setLogoHeight(float logoHeight) {
    this.logoHeight = logoHeight;
  }

  @Override
  public void setLogoTextAlignment(TextAlignment logoTextAlignment) {
    this.logoTextAlignment = logoTextAlignment;
  }

  @Override
  public void setLogoVerticalAlignment(VerticalAlignment logoVerticalAlignment) {
    this.logoVerticalAlignment = logoVerticalAlignment;
  }
}
