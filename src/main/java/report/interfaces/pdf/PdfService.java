package report.interfaces.pdf;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface PdfService {

  // PDF Writer operations
  PdfWriter createPdfWriter(String location) throws FileNotFoundException;

  void pdfWriterClose(PdfWriter pdfWriter) throws IOException;

  void pdfWriterFlush(PdfWriter pdfWriter) throws IOException;

  // PDF Document operations
  PdfDocument createPdfDocument(String location) throws FileNotFoundException;

  PdfDocument createPdfDocument(PdfWriter pdfWriter);

  void documentPdfClose(PdfDocument pdfDocument);

  // Document operations
  Document createDocument(String location) throws FileNotFoundException;

  Document createDocument(PdfDocument pdfDocument);

  Document createDocument(String location, PageSize pageSize) throws FileNotFoundException;

  void documentClose(Document document);

  void addParagraphIntoDocument(Document document, Paragraph paragraph);

  void showTextAligned(Document document, Paragraph paragraph, float x, float y, TextAlignment textAlignment);

  void showTextAligned(Document document, Paragraph paragraph, float x, float y, TextAlignment textAlignment, VerticalAlignment verticalAlignment);


}
