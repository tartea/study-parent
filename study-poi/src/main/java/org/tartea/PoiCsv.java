package org.tartea;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class PoiCsv {


    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("/Users/jiaxiansheng/develop/spring/study-parent/test.csv");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF8");

        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("姓名", "年龄", "家乡", "性别");
        CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

        long l = System.currentTimeMillis();
        // 第二种方式设置头部信息
//        csvPrinter = CSVFormat.DEFAULT.withHeader("姓名", "年龄", "家乡", "性别").print(osw);

        for (int i = 0; i < 1000000; i++) {
            csvPrinter.printRecord("张三", 20, "上海", "男");
        }
        csvPrinter.flush();
        csvPrinter.close();
        System.out.println(System.currentTimeMillis() - l);
    }
}
