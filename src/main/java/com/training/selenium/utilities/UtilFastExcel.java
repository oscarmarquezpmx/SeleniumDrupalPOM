package com.training.selenium.utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;
import java.io.InputStream;

import org.dhatim.fastexcel.reader.Cell;
import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;
//import org.junit.jupiter.api.parallel.Resources;

public class UtilFastExcel {

     public List<ArrayList<String>> readAllRows(int index) throws IOException {
        File initialFile = new File("src/test/resources/TestData.xlsx");
        InputStream targetStream = new FileInputStream(initialFile);
        List<ArrayList<String>> output = new ArrayList<>();
        try (ReadableWorkbook wb = new ReadableWorkbook(targetStream)) {
        AtomicInteger rowCount = new AtomicInteger();

            Optional<Sheet> sheet = wb.getSheet(index);

            sheet.ifPresent(sheetValid -> {
                try (Stream<Row> rows = sheetValid.openStream()) {
                    Iterator<Row> rowsIt = rows.iterator();
                    while (rowsIt.hasNext()) {
                        if(rowCount.get() == 0) {  // skip header
                            rowsIt.next();
                        } else {
                            Iterator<Cell> cellIt = rowsIt.next().iterator();
                            ArrayList<String> InnerArray = new ArrayList<>();
                            while (cellIt.hasNext()) {
                                Cell cell = cellIt.next();
                                //System.out.println(cell.getValue());
                                InnerArray.add(cell.getValue().toString());
                            }

                            output.add(InnerArray);
                        }
                        rowCount.getAndIncrement();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return output;
    }

    List<String> readRow(int sheet,int row) throws IOException {
        //UtilFastExcel excel = new UtilFastExcel();
        List<ArrayList<String>> values = readAllRows(sheet);
        List<String> rowContent = values.get(row).stream().collect(Collectors.toList());

        return rowContent;
    }

    void readRowTest() throws IOException {
        UtilFastExcel util = new UtilFastExcel();
        List<String> content = util.readRow(0,1);
        content.stream().forEach(System.out::println);
    }
}

