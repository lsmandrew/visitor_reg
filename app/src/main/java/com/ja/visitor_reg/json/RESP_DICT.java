package com.ja.visitor_reg.json;

import java.util.List;

/**
 * 字典回复
 * ===========================
 * {"msg":"success","code":0,
 * "list":
 * [{"code":"2",
 * "delFlag":0,
 * "id":3999,
 * "name":"政务",
 * "orderNum":0,
 * "parentId":27,
 * "remark":null,
 * "type":"causeofvisit",
 * "value":"2"},
 * {"code":"VISIT_CAUSE_001",
 * "delFlag":0,
 * "id":28,
 * "name":"项目",
 * "orderNum":0,
 * "parentId":27,
 * "remark":"来访事由",
 * "type":"causeofvisit",
 * "value":"1"}]}
 * ================================
 */
public class RESP_DICT {
    private String msg;
    private Long code;
    private List<ListItem> list;

    public class ListItem{
        private String code;
        private Long delFlag;
        private Long id;
        private String name;
        private Long orderNum;
        private Long parentId;
        private String remark;
        private String type;
        private String value;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Long getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(Long delFlag) {
            this.delFlag = delFlag;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(Long orderNum) {
            this.orderNum = orderNum;
        }

        public Long getParentId() {
            return parentId;
        }

        public void setParentId(Long parentId) {
            this.parentId = parentId;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ListItem{" +
                    "code='" + code + '\'' +
                    ", delFlag=" + delFlag +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", orderNum=" + orderNum +
                    ", parentId=" + parentId +
                    ", remark='" + remark + '\'' +
                    ", type='" + type + '\'' +
                    ", value='" + value + '\'' +
                    '}';
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

    @Override
    public String toString() {
        return "RESP_DICT{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", list=" + list +
                '}';
    }

}
