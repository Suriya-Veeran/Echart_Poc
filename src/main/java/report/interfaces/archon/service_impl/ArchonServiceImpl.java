package report.interfaces.archon.service_impl;

import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import lombok.extern.slf4j.Slf4j;
import report.beans.header.HeaderInputBean;
import report.implementations.paragraph_service_impl.ParagraphServiceImpl;
import report.implementations.pdf_service_impl.PdfServiceImpl;
import report.interfaces.archon.service.ArchonService;
import report.utils.image.ImageUtils;

import java.io.IOException;

@Slf4j
public class ArchonServiceImpl implements ArchonService {

  private Document document;
  private final ParagraphServiceImpl paragraphService = new ParagraphServiceImpl();
  private final ImageUtils imageUtils = new ImageUtils();
  private final PdfServiceImpl pdfService = new PdfServiceImpl();

  @Override
  public void addHeader(Document document, HeaderInputBean headerInputBean) throws IOException {
    if (headerInputBean == null || document == null) {
      log.warn("HeaderInputBean or document is null. Header addition skipped.");
      return;
    }

    this.document = document;
    int numberOfPages = document.getPdfDocument().getNumberOfPages();

    for (int i = 1; i <= numberOfPages; i++) {
      addHeaderToPage(headerInputBean, i);
    }
  }

  private void addHeaderToPage(HeaderInputBean headerInputBean, int pageIndex) throws IOException {

    Rectangle pageSize = document.getPdfDocument().getPage(pageIndex).getPageSize();
    float width = pageSize.getWidth();
    float height = pageSize.getHeight();

    Paragraph paragraph =
        paragraphService.createParagraph(headerInputBean.getHeaderTitleInputBean().getContent());

    pdfService.showTextAligned(
        document,
        paragraph,
        headerInputBean.getHeaderTitleInputBean().getLeftMargin(),
        height - headerInputBean.getHeaderTitleInputBean().getTopMargin(),
        headerInputBean.getHeaderTitleInputBean().getTextAlignment());

    if (headerInputBean.getLogoInputBean().isLogoNeeded()) {
      Image logoImage =
          imageUtils.loadImage(
              headerInputBean.getLogoInputBean().getImagePath(),
              headerInputBean.getLogoInputBean().getFitWidth(),
              headerInputBean.getLogoInputBean().getFitHeight());

      if (logoImage != null) {
        document.showTextAligned(
            paragraphService.createParagraph(logoImage),
            width - headerInputBean.getLogoInputBean().getFitWidth() - 17,
            height - headerInputBean.getLogoInputBean().getLogoHeight(),
            headerInputBean.getLogoInputBean().getLogoTextAlignment());
      }
    }
  }
}
