package org.tartea.entity;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Teacher {

    private Integer id;

    private String name;

    private Integer age;

    private Integer schoolId;

    private String schoolName;

    private SchoolType type;

}
