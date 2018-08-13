package com.ja.visitor_reg.model;

/**
 * 性别类型(字典)
 */

public class SexTypeItem {
    private String name;
    private String code;

    public SexTypeItem() {
    }

    public SexTypeItem(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public SexTypeItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "SexTypeItem{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
