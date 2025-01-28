package report.implementations.table_service_impl;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import report.interfaces.table.TableService;

public class TableServiceImpl implements TableService {
  @Override
  public Table createTable(int numColumns) {
    return new Table(numColumns);
  }

  @Override
  public void addCellToTable(Table table, Cell cell) {
    if (table != null && cell != null) {
      table.addCell(cell);
    }
  }

  @Override
  public void addTable(Document document, Table table) {
    if (document != null && table != null) {
      document.add(table);
    }
  }
}
