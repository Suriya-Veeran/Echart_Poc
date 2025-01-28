package report.interfaces.header;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import report.enums.FontType;

public interface HeaderTitleInput {
  void setContent(String content);

  void setTextAlignment(TextAlignment textAlignment);

  void setRightMargin(float rightMargin);

  void setLeftMargin(float leftMargin);

  void setTopMargin(float topMargin);

  void setBackgroundColor(Color backgroundColor);

  void setFontSize(int fontSize);

  void setVerticalAlignment(VerticalAlignment verticalAlignment);

  void setFont(FontType font);
}
