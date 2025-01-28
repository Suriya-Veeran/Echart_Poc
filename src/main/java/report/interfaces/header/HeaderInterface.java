package report.interfaces.header;

import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;

public interface HeaderInterface {

  void setContent(String content);

  void setTextAlignment(TextAlignment textAlignment);

  void setVerticalAlignment(VerticalAlignment verticalAlignment);

  void setRightMargin(float rightMargin);

  void setLeftMargin(float leftMargin);

  void setFontSize(int fontSize);
}
