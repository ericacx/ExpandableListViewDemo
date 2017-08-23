package com.eric.demo;

import java.io.Serializable;

/**
 * Created by eric on 2017/8/23.
 */

public class ChildEntity implements Serializable{

    private String itemName;
    private String itemPoint;
    private String itemNameVip;
    private String itemPointUsed;


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPoint() {
        return itemPoint;
    }

    public void setItemPoint(String itemPoint) {
        this.itemPoint = itemPoint;
    }

    public String getItemNameVip() {
        return itemNameVip;
    }

    public void setItemNameVip(String itemNameVip) {
        this.itemNameVip = itemNameVip;
    }

    public String getItemPointUsed() {
        return itemPointUsed;
    }

    public void setItemPointUsed(String itemPointUsed) {
        this.itemPointUsed = itemPointUsed;
    }
}
