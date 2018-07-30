package com.ja.visitor_reg.model;

/**
 * 性别类型(字典)
 */

public class SexTypeItem {
    private String mName;

    public SexTypeItem(String mName) {
        this.mName = mName;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    @Override
    public String toString() {
        return "SexTypeItem{" +
                "mName='" + mName + '\'' +
                '}';
    }
}
