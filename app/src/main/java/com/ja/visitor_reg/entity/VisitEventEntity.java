package com.ja.visitor_reg.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;

/**
 * 来访事件表
 *
 * 1.实体@Entity注解
 * schema：告知GreenDao当前实体属于哪个schema
 * active：标记一个实体处于活动状态，活动实体有更新、删除和刷新方法
 * nameInDb：在数据中使用的别名，默认使用的是实体的类名
 * indexes：定义索引，可以跨越多个列
 * createInDb：标记创建数据库表
 * 2.基础属性注解
 * @Id :主键 Long型，可以通过@Id(autoincrement = true)设置自增长
 * @Property：设置一个非默认关系映射所对应的列名，默认是的使用字段名 举例：@Property (nameInDb="name")
 * @NotNul：设置数据库表当前列不能为空
 * @Transient ：添加次标记之后不会生成数据库表的列
 * 3.索引注解
 * @Index：使用@Index作为一个属性来创建一个索引，通过name设置索引别名，也可以通过unique给索引添加约束
 * @Unique：向数据库列添加了一个唯一的约束
 * 4.关系注解
 * @ToOne：定义与另一个实体（一个实体对象）的关系
 * @ToMany：定义与多个实体对象的关系
 */

@Entity(
        //告知GreenDao当前实体属于哪个schema
//        schema = "myschema",

        //标记一个实体处于活动状态，活动实体有更新、删除和刷新方法
//        active = true,

        //在数据中使用的别名，默认使用的是实体的类名(表名)
        nameInDb = "VisitEvent_Table",

        //定义索引，可以跨越多个列
//        indexes = {
//                @Index(value = "name DESC", unique = true)
//        },

        //标记创建数据库表
//        createInDb = false,

        //是否生成所有构造函数
        generateConstructors = true,

        //是否生成get and set 方法
        generateGettersSetters = true
)

public class VisitEventEntity {
    @Id(autoincrement = true)
    private Long id;//主键
    private Long causeId;//来访事由id
    private Long intervieweeId;//受访者id
    private Long shifitId;//班次id(保安)
    private Long deviceId;//登记设备
    private Integer visitorCount;//来访人数
    private Date insetTime;//事件时间
    private Integer is_upload;//是否已上传(0未,1已)

    public VisitEventEntity() {
    }

    @Generated(hash = 549618020)
    public VisitEventEntity(Long id, Long causeId, Long intervieweeId, Long shifitId,
            Long deviceId, Integer visitorCount, Date insetTime, Integer is_upload) {
        this.id = id;
        this.causeId = causeId;
        this.intervieweeId = intervieweeId;
        this.shifitId = shifitId;
        this.deviceId = deviceId;
        this.visitorCount = visitorCount;
        this.insetTime = insetTime;
        this.is_upload = is_upload;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCauseId() {
        return this.causeId;
    }

    public void setCauseId(Long causeId) {
        this.causeId = causeId;
    }

    public Long getIntervieweeId() {
        return this.intervieweeId;
    }

    public void setIntervieweeId(Long intervieweeId) {
        this.intervieweeId = intervieweeId;
    }

    public Long getShifitId() {
        return this.shifitId;
    }

    public void setShifitId(Long shifitId) {
        this.shifitId = shifitId;
    }

    public Long getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getVisitorCount() {
        return this.visitorCount;
    }

    public void setVisitorCount(Integer visitorCount) {
        this.visitorCount = visitorCount;
    }

    public Date getInsetTime() {
        return this.insetTime;
    }

    public void setInsetTime(Date insetTime) {
        this.insetTime = insetTime;
    }

    public Integer getIs_upload() {
        return this.is_upload;
    }

    public void setIs_upload(Integer is_upload) {
        this.is_upload = is_upload;
    }

    @Override
    public String toString() {
        return "VisitEventEntity{" +
                "id=" + id +
                ", causeId=" + causeId +
                ", intervieweeId=" + intervieweeId +
                ", shifitId=" + shifitId +
                ", deviceId=" + deviceId +
                ", visitorCount=" + visitorCount +
                ", insetTime=" + insetTime +
                ", is_upload=" + is_upload +
                '}';
    }
}
