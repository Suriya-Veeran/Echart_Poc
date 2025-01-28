package runner;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;

import java.io.File;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import report.beans.header.HeaderInputBean;
import report.implementations.paragraph_service_impl.ParagraphServiceImpl;
import report.implementations.pdf_service_impl.PdfServiceImpl;
import report.interfaces.archon.service_impl.ArchonServiceImpl;
import report.service_factory.ReportServiceFactory;
import report.utils.YamlMapper;
import report.utils.chart.ChartUtils;

@Slf4j
public class Sample {

    public static void main(String[] args) throws IOException {
        String outputPath = "src/main/resources/Pdf_Files/Test.pdf";
        File outputFile = new File(outputPath);
        if (!outputFile.exists()) {
            log.info("file creation status : {}", outputFile.createNewFile());
        }

        HeaderInputBean headerInputBean =
                YamlMapper.parseYaml(
                        "/home/p3/IdeaProjects/Echarts_Poc/src/main/resources/YamlFiles/InputYaml.yml");

        PdfServiceImpl pdfService = ReportServiceFactory.createPdfService();
        ArchonServiceImpl archonService = ReportServiceFactory.createArchonService();
        ParagraphServiceImpl paragraphService = ReportServiceFactory.createParagraphService();

        ChartUtils chartUtils = new ChartUtils();
        Document document = pdfService.createDocument(outputPath, PageSize.A4);
        Image image = chartUtils.chartCreation();
        image.scaleToFit(200, 200);
        pdfService.addParagraphIntoDocument(
                document, paragraphService.createParagraph(image));
        archonService.addHeader(document, headerInputBean);
        pdfService.documentClose(document);
    }
}
