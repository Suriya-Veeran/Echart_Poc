package report.interfaces.table;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;

public interface TableService {
  // Table operations
  Table createTable(int numColumns);

  void addCellToTable(Table table, Cell cell);

  void addTable(Document document, Table table);
}
