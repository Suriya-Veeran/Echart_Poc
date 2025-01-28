package report.interfaces.paragraph;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import report.enums.FontType;

import java.io.IOException;

public interface ParagraphService {

  // Paragraph operations
  Paragraph createParagraph(String content) throws IOException;

  Paragraph createParagraph(String content, int fontSize) throws IOException;

  Paragraph createParagraph(String content, int fontSize, Color color) throws IOException;

  Paragraph createParagraph(String content, int fontSize, FontType fontType) throws IOException;

  Paragraph createParagraph(
      String content,
      int fontSize,
      Color color,
      TextAlignment textAlignment,
      VerticalAlignment verticalAlignment)
      throws IOException;

  Paragraph createParagraph(String content, int fontSize, Color color, TextAlignment textAlignment)
      throws IOException;

  Paragraph createParagraph(
      String content,
      int fontSize,
      Color color,
      TextAlignment textAlignment,
      VerticalAlignment verticalAlignment,
      FontType fontType)
      throws IOException;

  Paragraph createParagraph(
      String content,
      int fontSize,
      VerticalAlignment verticalAlignment,
      FontType fontType,
      Color backgroundColor)
      throws IOException;

  void addParagraph(Document document, Paragraph paragraph);

  Paragraph createParagraph(Image image);
}
