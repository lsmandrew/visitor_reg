package com.ja.visitor_reg.json;

import java.util.List;

public class RESP_VISITEDINFO {
    private String msg;//结果
    private Long code;
    private List<ListItem> list;
    class ListItem {
        private String createTime;
        private Long deptId;
        private String email;
        private String officePhone;
        private String password;
        private String realName;
        private String salt;
        private Long status;
        private Long userId;
        private String username;
        private String workerNum;
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
