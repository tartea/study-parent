package org.tartea;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class User {


    @ExcelProperty("用户id")
    private String id;

    @ExcelProperty("用户名称")
    private String username;

    @ExcelProperty("年龄")
    private Double age;

    @ExcelProperty("性别")
    private Double sex;

}
