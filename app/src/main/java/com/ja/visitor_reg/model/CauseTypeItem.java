package com.ja.visitor_reg.model;

public class CauseTypeItem {
    private String name;//类型名称
    private String code;//编码

    public CauseTypeItem() {
    }

    public CauseTypeItem(String name, String code) {
        this.name = name;
        this.code = code;
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
        return "CauseTypeItem{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
