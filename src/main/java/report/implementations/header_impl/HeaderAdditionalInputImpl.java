package report.implementations.header_impl;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.layout.properties.TextAlignment;
import lombok.Getter;
import lombok.Setter;
import report.interfaces.header.HeaderAdditionalInput;

@Getter
@Setter
public class HeaderAdditionalInputImpl implements HeaderAdditionalInput {

  private String sectionTitle;
  private String dateFormat;
  private boolean isPageNumberNeeded;
  private TextAlignment pageNumberAlignment;
  private Color textColor;
  private float paddingLeft;
  private float paddingRight;
  private float paddingTop;
  private float paddingBottom;

  @Override
  public void setSectionTitle(String sectionTitle) {
    this.sectionTitle = sectionTitle;
  }

  @Override
  public void setDateFormat(String dateFormat) {
    this.dateFormat = dateFormat;
  }

  @Override
  public void setPageNumberNeeded(boolean isPageNumberNeeded) {
    this.isPageNumberNeeded = isPageNumberNeeded;
  }

  @Override
  public void setPageNumberAlignment(TextAlignment pageNumberAlignment) {
    this.pageNumberAlignment = pageNumberAlignment;
  }

  @Override
  public void setTextColor(Color textColor) {
    this.textColor = textColor;
  }

  @Override
  public void setPaddingLeft(float paddingLeft) {
    this.paddingLeft = paddingLeft;
  }

  @Override
  public void setPaddingTop(float paddingTop) {
    this.paddingTop = paddingTop;
  }

  @Override
  public void setPaddingRight(float paddingRight) {
    this.paddingRight = paddingRight;
  }

  @Override
  public void setPaddingBottom(float paddingBottom) {
    this.paddingBottom = paddingBottom;
  }
}
