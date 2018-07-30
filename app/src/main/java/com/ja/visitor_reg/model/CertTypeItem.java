package com.ja.visitor_reg.model;

/**
 * 证件类型（字典）
 */
public class CertTypeItem {
    private String mName;

    public CertTypeItem(String mName) {
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
        return "CertTypeItem{" +
                "mName='" + mName + '\'' +
                '}';
    }
}
