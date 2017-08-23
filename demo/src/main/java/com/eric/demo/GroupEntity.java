package com.eric.demo;

import java.io.Serializable;

/**
 * Created by eric on 2017/8/23.
 */

public class GroupEntity implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
