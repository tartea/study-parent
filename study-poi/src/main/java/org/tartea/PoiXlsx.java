package org.tartea;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PoiXlsx {

    public static void main(String[] args) throws IOException {
        String[] title = {"id", "name", "sex", "age"};
        // 创建一个工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 创建一个工作表sheet
        XSSFSheet sheet = workbook.createSheet();
        // 创建第一行
        XSSFRow row = sheet.createRow(0);
        // 创建一个单元格
        Cell cell = null;
        // 创建表头
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        long l = System.currentTimeMillis();
        // 从第二行开始追加数据
        for (int i = 1; i <= 1000000; i++) {
            // 创建第i行
            XSSFRow nextRow = sheet.createRow(i);
            // 参数代表第几列
            Cell cell2 = nextRow.createCell(0);
            cell2.setCellValue("a" + i);
            cell2 = nextRow.createCell(1);
            cell2.setCellValue("user" + i);
            cell2 = nextRow.createCell(2);
            cell2.setCellValue("男");
            cell2 = nextRow.createCell(3);
            cell2.setCellValue(123);
        }
        // 创建一个文件
        File file = new File("/Users/jiaxiansheng/develop/spring/study-parent/test.xlsx");
        file.createNewFile();
        // 打开文件流
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();

        System.out.println(System.currentTimeMillis() - l);
    }
}
