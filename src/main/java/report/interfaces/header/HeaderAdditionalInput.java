package report.interfaces.header;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.layout.properties.TextAlignment;

public interface HeaderAdditionalInput {
  void setSectionTitle(String sectionTitle);

  void setDateFormat(String dateFormat);

  void setPageNumberNeeded(boolean isPageNumberNeeded);

  void setPageNumberAlignment(TextAlignment pageNumberAlignment);

  void setTextColor(Color textColor);

  void setPaddingLeft(float paddingLeft);

  void setPaddingTop(float paddingTop);

  void setPaddingRight(float paddingRight);

  void setPaddingBottom(float paddingBottom);
}
