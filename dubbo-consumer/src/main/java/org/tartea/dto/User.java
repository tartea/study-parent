package org.tartea.dto;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -7518658808692242651L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
