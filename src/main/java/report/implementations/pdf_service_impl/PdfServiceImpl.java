package report.implementations.pdf_service_impl;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import java.io.FileNotFoundException;
import java.io.IOException;
import lombok.Getter;
import lombok.Setter;
import report.interfaces.pdf.PdfService;

@Getter
@Setter
public class PdfServiceImpl implements PdfService {
  @Override
  public PdfWriter createPdfWriter(String location) throws FileNotFoundException {
    return new PdfWriter(location);
  }

  @Override
  public void pdfWriterClose(PdfWriter pdfWriter) throws IOException {
    if (pdfWriter != null) {
      pdfWriter.close();
    }
  }

  @Override
  public void pdfWriterFlush(PdfWriter pdfWriter) throws IOException {
    if (pdfWriter != null) {
      pdfWriter.flush();
    }
  }

  @Override
  public PdfDocument createPdfDocument(String location) throws FileNotFoundException {
    PdfWriter pdfWriter = createPdfWriter(location);
    return new PdfDocument(pdfWriter);
  }

  @Override
  public PdfDocument createPdfDocument(PdfWriter pdfWriter) {
    return new PdfDocument(pdfWriter);
  }

  @Override
  public void documentPdfClose(PdfDocument pdfDocument) {
    if (pdfDocument != null) {
      pdfDocument.close();
    }
  }

  @Override
  public void documentClose(Document document) {
    if (document != null) {
      document.close();
    }
  }

  @Override
  public Document createDocument(PdfDocument pdfDocument) {
    return new Document(pdfDocument);
  }

  @Override
  public Document createDocument(String location) throws FileNotFoundException {
    return new Document(createPdfDocument(location), PageSize.A4, false);
  }

  @Override
  public Document createDocument(String location, PageSize pageSize) throws FileNotFoundException {
    return new Document(createPdfDocument(location), pageSize, false);
  }

  @Override
  public void addParagraphIntoDocument(Document document, Paragraph paragraph) {
    if (document != null && paragraph != null) {
      document.add(paragraph); // Adds the paragraph to the document
    }
  }

  @Override
  public void showTextAligned(
      Document document, Paragraph paragraph, float x, float y, TextAlignment textAlignment) {
    if (document != null && paragraph != null) {
      document.showTextAligned(paragraph, x, y, textAlignment);
    }
  }

  @Override
  public void showTextAligned(
      Document document,
      Paragraph paragraph,
      float x,
      float y,
      TextAlignment textAlignment,
      VerticalAlignment verticalAlignment) {
    if (document != null && paragraph != null) {
      document.showTextAligned(paragraph, x, y, textAlignment, verticalAlignment);
    }
  }
}
