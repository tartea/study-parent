package org.tartea.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class School {

    private Integer id;

    private String name;

    private String type;
}
