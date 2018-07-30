package com.ja.visitor_reg.model;

public class CauseTypeItem {
    private String mNmae;

    public String getNmae() {
        return mNmae;
    }

    public void setNmae(String mNmae) {
        this.mNmae = mNmae;
    }

    public CauseTypeItem(String mNmae) {
        this.mNmae = mNmae;
    }

    @Override
    public String toString() {
        return "CauseTypeItem{" +
                "mNmae='" + mNmae + '\'' +
                '}';
    }
}
