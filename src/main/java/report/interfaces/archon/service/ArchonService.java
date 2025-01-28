package report.interfaces.archon.service;

import com.itextpdf.layout.Document;
import report.beans.header.HeaderInputBean;

import java.io.IOException;

public interface ArchonService {

  void addHeader(Document document, HeaderInputBean headerInputBean) throws IOException;
}
