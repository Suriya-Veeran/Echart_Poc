package report.implementations.paragraph_service_impl;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import report.enums.FontType;
import report.interfaces.paragraph.ParagraphService;

import java.io.IOException;

public class ParagraphServiceImpl implements ParagraphService {
  private static final int DEFAULT_FONT_SIZE = 12;
  private static final Color DEFAULT_COLOR = new DeviceRgb(0, 0, 0);
  private static final TextAlignment DEFAULT_TEXT_ALIGNMENT = TextAlignment.LEFT;
  private static final VerticalAlignment DEFAULT_VERTICAL_ALIGNMENT = VerticalAlignment.BOTTOM;
  private static final FontType DEFAULT_FONT_TYPE = FontType.HELVETICA_BOLD;
  private static final Color DEFAULT_BACKGROUND_COLOR = new DeviceRgb(255, 255, 255); // White color;

  @Override
  public Paragraph createParagraph(String content) throws IOException {
    return new Paragraph(content)
        .setFontSize(DEFAULT_FONT_SIZE)
        .setFontColor(DEFAULT_COLOR)
        .setTextAlignment(DEFAULT_TEXT_ALIGNMENT)
        .setVerticalAlignment(DEFAULT_VERTICAL_ALIGNMENT)
        .setFont(PdfFontFactory.createFont(DEFAULT_FONT_TYPE.getFontName()));
  }

  @Override
  public Paragraph createParagraph(String content, int fontSize) throws IOException {
    return new Paragraph(content)
        .setFontSize(fontSize)
        .setFontColor(DEFAULT_COLOR)
        .setTextAlignment(DEFAULT_TEXT_ALIGNMENT)
        .setVerticalAlignment(DEFAULT_VERTICAL_ALIGNMENT)
        .setFont(PdfFontFactory.createFont(DEFAULT_FONT_TYPE.getFontName()));
  }

  @Override
  public Paragraph createParagraph(String content, int fontSize, Color color) throws IOException {
    return new Paragraph(content)
        .setFontSize(fontSize)
        .setFontColor(color)
        .setTextAlignment(DEFAULT_TEXT_ALIGNMENT)
        .setVerticalAlignment(DEFAULT_VERTICAL_ALIGNMENT)
        .setFont(PdfFontFactory.createFont(DEFAULT_FONT_TYPE.getFontName()));
  }

  @Override
  public Paragraph createParagraph(String content, int fontSize, FontType fontType)
      throws IOException {
    return new Paragraph(content)
        .setFontSize(fontSize)
        .setFont(PdfFontFactory.createFont(fontType.getFontName()))
        .setFontColor(DEFAULT_COLOR)
        .setTextAlignment(DEFAULT_TEXT_ALIGNMENT)
        .setVerticalAlignment(DEFAULT_VERTICAL_ALIGNMENT);
  }

  @Override
  public Paragraph createParagraph(
      String content, int fontSize, Color color, TextAlignment textAlignment) throws IOException {
    return new Paragraph(content)
        .setFontSize(fontSize)
        .setFontColor(color)
        .setTextAlignment(textAlignment != null ? textAlignment : DEFAULT_TEXT_ALIGNMENT)
        .setVerticalAlignment(DEFAULT_VERTICAL_ALIGNMENT)
        .setFont(PdfFontFactory.createFont(DEFAULT_FONT_TYPE.getFontName()));
  }

  @Override
  public Paragraph createParagraph(
      String content,
      int fontSize,
      Color color,
      TextAlignment textAlignment,
      VerticalAlignment verticalAlignment) throws IOException {
    return new Paragraph(content)
        .setFontSize(fontSize)
        .setFontColor(color)
        .setTextAlignment(textAlignment != null ? textAlignment : DEFAULT_TEXT_ALIGNMENT)
        .setVerticalAlignment(
            verticalAlignment != null ? verticalAlignment : DEFAULT_VERTICAL_ALIGNMENT)
        .setFont(PdfFontFactory.createFont(DEFAULT_FONT_TYPE.getFontName()));
  }

  @Override
  public Paragraph createParagraph(
      String content,
      int fontSize,
      Color color,
      TextAlignment textAlignment,
      VerticalAlignment verticalAlignment,
      FontType fontType)
      throws IOException {
    return new Paragraph(content)
        .setFontSize(fontSize)
        .setFontColor(color)
        .setTextAlignment(textAlignment != null ? textAlignment : DEFAULT_TEXT_ALIGNMENT)
        .setVerticalAlignment(
            verticalAlignment != null ? verticalAlignment : DEFAULT_VERTICAL_ALIGNMENT)
        .setFont(PdfFontFactory.createFont(fontType.getFontName()));
  }

  @Override
  public Paragraph createParagraph(
      String content,
      int fontSize,
      VerticalAlignment verticalAlignment,
      FontType fontType,
      Color backgroundColor)
      throws IOException {
    return new Paragraph(content)
        .setFont(PdfFontFactory.createFont(fontType.getFontName()))
        .setFontColor(backgroundColor != null ? backgroundColor : DEFAULT_BACKGROUND_COLOR)
        .setFontSize(fontSize != 0 ? fontSize : DEFAULT_FONT_SIZE)
        .setVerticalAlignment(
            verticalAlignment != null ? verticalAlignment : DEFAULT_VERTICAL_ALIGNMENT);
  }

  @Override
  public void addParagraph(Document document, Paragraph paragraph) {
    if (document != null && paragraph != null) {
      document.add(paragraph);
    }
  }

  @Override
  public Paragraph createParagraph(Image image) {
    Paragraph paragraph = new Paragraph();
    return paragraph.add(image);
  }
}
