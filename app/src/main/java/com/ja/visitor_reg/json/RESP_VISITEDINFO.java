package com.ja.visitor_reg.json;

import java.util.List;

public class RESP_VISITEDINFO {
    private String msg;//结果
    private Long code;
    private List<ListItem> list;
    public class ListItem {
        private String createTime;
        private Long deptId;
        private String email;
        private String mobile;
        private String officePhone;
        private String password;
        private String realName;
        private String salt;
        private Long status;
        private Long userId;
        private String username;
        private String workerNum;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Long getDeptId() {
            return deptId;
        }

        public void setDeptId(Long deptId) {
            this.deptId = deptId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getOfficePhone() {
            return officePhone;
        }

        public void setOfficePhone(String officePhone) {
            this.officePhone = officePhone;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public Long getStatus() {
            return status;
        }

        public void setStatus(Long status) {
            this.status = status;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getWorkerNum() {
            return workerNum;
        }

        public void setWorkerNum(String workerNum) {
            this.workerNum = workerNum;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public List<ListItem> getList() {
        return list;
    }

    public void setList(List<ListItem> list) {
        this.list = list;
    }

    /**
     * "list":
     * [{"createTime":"2016-11-11 11:11:11",
     * "deptId":1,
     * "email":"root@iots.io",
     * "mobile":"13612345678",
     * "officePhone":"811",
     * "password":"e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b",
     * "realName":"任盈盈",
     * "salt":"YzcmCZNvbXocrsz9dm8e",
     * "status":1,
     * "userId":1,
     * "username":"admin","workerNum":"M20180101"}]}
     */
}
