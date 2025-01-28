package report.service_factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import report.implementations.header_impl.HeaderAdditionalInputImpl;
import report.implementations.header_impl.HeaderInputImpl;
import report.implementations.header_impl.HeaderTitleInputImpl;
import report.implementations.header_impl.LogoInputBeanImpl;
import report.implementations.paragraph_service_impl.ParagraphServiceImpl;
import report.implementations.pdf_service_impl.PdfServiceImpl;
import report.implementations.table_service_impl.TableServiceImpl;
import report.interfaces.archon.service_impl.ArchonServiceImpl;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReportServiceFactory {


    public static PdfServiceImpl createPdfService() {
        return new PdfServiceImpl();
    }

    public static TableServiceImpl createTableService() {
        return new TableServiceImpl();
    }

    public static ParagraphServiceImpl createParagraphService() {
        return new ParagraphServiceImpl();
    }

    public static LogoInputBeanImpl createLogoService() {
        return new LogoInputBeanImpl();
    }

    public static HeaderAdditionalInputImpl createHeaderAdditionalService() {
        return new HeaderAdditionalInputImpl();
    }

    public static HeaderTitleInputImpl createHeaderTitleService() {
        return new HeaderTitleInputImpl();
    }

    public static HeaderInputImpl createHeaderInputService() {
        return new HeaderInputImpl();
    }

    public static ArchonServiceImpl createArchonService() {
        return new ArchonServiceImpl();
    }


}
