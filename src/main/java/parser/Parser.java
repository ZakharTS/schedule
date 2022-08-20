package parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

public class Parser {
    public static String parseFile(InputStream fileContent) throws IOException {
        String output = "";
        try (Workbook workbook = WorkbookFactory.create(fileContent)) {
            Sheet sheet = workbook.getSheetAt(0);
            Cell cell1 = sheet.getRow(21).getCell(3);
            output += cell1.getStringCellValue() + "<br>";
            cell1 = sheet.getRow(21).getCell(4);
            output += cell1.getStringCellValue() + "<br>";

            Iterator<Row> rowIterator = sheet.rowIterator();
            output += "<table border=\"1px solid black\">";
            while (rowIterator.hasNext()) {
                output += "<tr>";
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String cellData = null;
                    int cellRow = cell.getRowIndex();
                    int cellColumn = cell.getColumnIndex();
                    cell = findMerge(cell, sheet);
                    if (cell.getCellType() == CellType.STRING) {
                        cellData = cell.getStringCellValue();
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        cellData = String.valueOf((int)cell.getNumericCellValue());
                    }
                    if (cellData == null) continue;
                    System.out.println(cellData);
                    output += "<td>" + cellData + "</td>";
                }
                output += "</tr>";
            }
            output += "</table>";
        }
        return output;
    }
    private static Cell findMerge(Cell cell, Sheet sheet) {
        int cellRow = cell.getRowIndex();
        int cellColumn = cell.getColumnIndex();
        for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
            CellRangeAddress region = sheet.getMergedRegion(i);
            if (cellRow >= region.getFirstRow() && cellRow <= region.getLastRow()
                    && cellColumn >= region.getFirstColumn() && cellColumn <= region.getLastColumn()) {
                cell = sheet.getRow(region.getFirstRow()).getCell(region.getFirstColumn());
                break;
            }
        }
        return cell;
    }
}
