package org.tartea;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.util.ArrayList;
import java.util.List;

public class EasyExcelTest {

    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        String fileName = "/Users/jiaxiansheng/develop/spring/study-parent/easy.xlsx";
        ExcelWriter excelWriter = null;
        try {
            // 这里 需要指定写用哪个class去写
            excelWriter = EasyExcel.write(fileName, User.class).build();
            // 这里注意 如果同一个sheet只要创建一次

            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
            for (int i = 0; i < 10; i++) {
                WriteSheet writeSheet = EasyExcel.writerSheet("模板" + i).build();
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<User> data = data();
                excelWriter.write(data, writeSheet);
            }
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
        System.out.println(System.currentTimeMillis() - l);
    }

    private static List<User> data() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            userList.add(new User(String.valueOf(i), "jia", 12d, 12d));
        }
        return userList;
    }
}
