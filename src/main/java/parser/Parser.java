package parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

public class Parser {
    public static String parseFile(InputStream fileContent) throws IOException {
        String output = "";
        Map<String, List<Lesson>> lessonsByGroups = new HashMap<>();
        try (Workbook workbook = WorkbookFactory.create(fileContent)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();
            boolean isGroupRowPassed = false;
            int groupRowIndex;
//            output += "<table border=\"1px solid black\">";
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (!isGroupRowPassed) {
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        String cellData = getCellData(cell, sheet);

                        if (!Lesson.isGroupName(cellData)) {
                            if (Lesson.isDay(cellData)) {
                                isGroupRowPassed = true;
                            }
                            break;
                        }
                        groupRowIndex = cell.getRowIndex();
                        cellData = Lesson.formatGroupName(cellData);

                        if (!lessonsByGroups.containsKey(cellData)) {
                            List<Lesson> tmpList = new ArrayList<>();
                            lessonsByGroups.put(cellData, tmpList);
                        }
//                    if (cellData == null) continue;
                    }
                } else {
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();

                    }
                }
            }
//            output += "</table>";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    protected static String getCellData(Cell cell, Sheet sheet) {
        String cellData = null;
        cell = findMerge(cell, sheet);
        switch (cell.getCellType()) {
            case STRING:
                cellData = cell.getStringCellValue();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    cellData = String.valueOf(cell.getDateCellValue());
                } else {
                    cellData = String.valueOf((int) cell.getNumericCellValue());
                }
                break;

            case BOOLEAN:
                cellData = String.valueOf(cell.getBooleanCellValue());
                break;

            case FORMULA:
                cellData = String.valueOf(cell.getCellFormula());
                break;
        }

        return cellData;
    }

    protected static Cell findMerge(Cell cell, Sheet sheet) {
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
