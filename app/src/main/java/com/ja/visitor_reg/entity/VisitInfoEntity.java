package com.ja.visitor_reg.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;


/**
 * 来访登记表
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
        nameInDb = "VisitInfo_Table",

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

public class VisitInfoEntity {
    @Id(autoincrement = true)
    private Long id;//主键
    private String visitor_name;//来访者名
    private Long visit_event_id;//来访事件id
    private String id_numer;//证件号
    private String sex;//性别
    private String book_phone;//预约电话
    private String deparment;//单位
    private String goods;//携带物品(文字描述)
    private String car_plate;//车牌
    private String img_head;//头像(图片名)
    private String img_portrait;//人像(图片名)
    private String img_goods;//携带物品(图片名)
    private Date in_time;//登记时间
    private Date out_time;//签退时间
    private String system_id;//记录标识
    private Integer is_upload_in;//登记是否上传(0未,1已)
    private Integer is_upload_out;//退出是否上传(0未,1已)

    @Generated(hash = 2122041397)
    public VisitInfoEntity(Long id, String visitor_name, Long visit_event_id, String id_numer, String sex,
            String book_phone, String deparment, String goods, String car_plate, String img_head,
            String img_portrait, String img_goods, Date in_time, Date out_time, String system_id,
            Integer is_upload_in, Integer is_upload_out) {
        this.id = id;
        this.visitor_name = visitor_name;
        this.visit_event_id = visit_event_id;
        this.id_numer = id_numer;
        this.sex = sex;
        this.book_phone = book_phone;
        this.deparment = deparment;
        this.goods = goods;
        this.car_plate = car_plate;
        this.img_head = img_head;
        this.img_portrait = img_portrait;
        this.img_goods = img_goods;
        this.in_time = in_time;
        this.out_time = out_time;
        this.system_id = system_id;
        this.is_upload_in = is_upload_in;
        this.is_upload_out = is_upload_out;
    }

    @Generated(hash = 1676749005)
    public VisitInfoEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisitor_name() {
        return this.visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public Long getVisit_event_id() {
        return this.visit_event_id;
    }

    public void setVisit_event_id(Long visit_event_id) {
        this.visit_event_id = visit_event_id;
    }

    public String getId_numer() {
        return this.id_numer;
    }

    public void setId_numer(String id_numer) {
        this.id_numer = id_numer;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBook_phone() {
        return this.book_phone;
    }

    public void setBook_phone(String book_phone) {
        this.book_phone = book_phone;
    }

    public String getDeparment() {
        return this.deparment;
    }

    public void setDeparment(String deparment) {
        this.deparment = deparment;
    }

    public String getGoods() {
        return this.goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getImg_head() {
        return this.img_head;
    }

    public void setImg_head(String img_head) {
        this.img_head = img_head;
    }

    public String getImg_portrait() {
        return this.img_portrait;
    }

    public void setImg_portrait(String img_portrait) {
        this.img_portrait = img_portrait;
    }

    public String getImg_goods() {
        return this.img_goods;
    }

    public void setImg_goods(String img_goods) {
        this.img_goods = img_goods;
    }

    public Date getIn_time() {
        return this.in_time;
    }

    public void setIn_time(Date in_time) {
        this.in_time = in_time;
    }

    public Date getOut_time() {
        return this.out_time;
    }

    public void setOut_time(Date out_time) {
        this.out_time = out_time;
    }

    public String getSystem_id() {
        return this.system_id;
    }

    public void setSystem_id(String system_id) {
        this.system_id = system_id;
    }

    public Integer getIs_upload_in() {
        return this.is_upload_in;
    }

    public void setIs_upload_in(Integer is_upload_in) {
        this.is_upload_in = is_upload_in;
    }

    public Integer getIs_upload_out() {
        return this.is_upload_out;
    }

    public void setIs_upload_out(Integer is_upload_out) {
        this.is_upload_out = is_upload_out;
    }

    @Override
    public String toString() {
        return "VisitInfoEntity{" +
                "id=" + id +
                ", visitor_name='" + visitor_name + '\'' +
                ", visit_event_id=" + visit_event_id +
                ", id_numer='" + id_numer + '\'' +
                ", sex='" + sex + '\'' +
                ", book_phone='" + book_phone + '\'' +
                ", deparment='" + deparment + '\'' +
                ", goods='" + goods + '\'' +
                ", img_head='" + img_head + '\'' +
                ", img_portrait='" + img_portrait + '\'' +
                ", img_goods='" + img_goods + '\'' +
                ", in_time=" + in_time +
                ", out_time=" + out_time +
                ", system_id='" + system_id + '\'' +
                ", is_upload_in=" + is_upload_in +
                ", is_upload_out=" + is_upload_out +
                '}';
    }

    public String getCar_plate() {
        return this.car_plate;
    }

    public void setCar_plate(String car_plate) {
        this.car_plate = car_plate;
    }
}
