package report.implementations.header_impl;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import lombok.Getter;
import lombok.Setter;
import report.enums.FontType;
import report.interfaces.header.HeaderTitleInput;

@Getter
@Setter
public class HeaderTitleInputImpl implements HeaderTitleInput {

  private String content;
  private TextAlignment textAlignment;
  private float rightMargin;
  private float topMargin;
  private float leftMargin;
  private Color backgroundColor;
  private int fontSize;
  private VerticalAlignment verticalAlignment;
  private FontType fontType;

  @Override
  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public void setTextAlignment(TextAlignment textAlignment) {
    this.textAlignment = textAlignment;
  }

  @Override
  public void setRightMargin(float rightMargin) {
    this.rightMargin = rightMargin;
  }

  @Override
  public void setLeftMargin(float leftMargin){
    this.leftMargin = leftMargin;
  }

  @Override
  public void setTopMargin(float topMargin) {
    this.topMargin = topMargin;
  }

  @Override
  public void setBackgroundColor(Color backgroundColor) {
    this.backgroundColor = backgroundColor;
  }

  @Override
  public void setFontSize(int fontSize) {
    this.fontSize = fontSize;
  }

  @Override
  public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
    this.verticalAlignment = verticalAlignment;
  }

  @Override
  public void setFont(FontType font) {
    this.fontType = font;
  }
}
