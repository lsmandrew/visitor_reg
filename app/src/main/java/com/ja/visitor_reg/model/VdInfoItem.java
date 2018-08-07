package com.ja.visitor_reg.model;

public class VdInfoItem {
    private String department;
    private String name;
    private String workPhone;
    private boolean isAgree;
    private Long  id;//用戶標識

    public VdInfoItem() {
    }

    public VdInfoItem(String department, String name, String workPhone, boolean isAgree, Long id) {
        this.department = department;
        this.name = name;
        this.workPhone = workPhone;
        this.isAgree = isAgree;
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public boolean isAgree() {
        return isAgree;
    }

    public void setAgree(boolean agree) {
        isAgree = agree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "VdInfoItem{" +
                "department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", isAgree=" + isAgree +
                '}';
    }
}
