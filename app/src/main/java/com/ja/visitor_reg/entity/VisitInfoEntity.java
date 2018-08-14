package com.ja.visitor_reg.entity;

import com.ja.visitor_reg.greendao.DaoSession;
import com.ja.visitor_reg.greendao.VisitEventEntityDao;
import com.ja.visitor_reg.greendao.VisitInfoEntityDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

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
 *
 * @Id :主键 Long型，可以通过@Id(autoincrement = true)设置自增长
 * @Property：设置一个非默认关系映射所对应的列名，默认是的使用字段名 举例：@Property (nameInDb="name")
 * @NotNul：设置数据库表当前列不能为空
 * @Transient ：添加次标记之后不会生成数据库表的列
 * 3.索引注解
 * @Index：使用@Index作为一个属性来创建一个索引，通过name设置索引别名，也可以通过unique给索引添加约束
 * @Unique：向数据库列添加了一个唯一的约束 4.关系注解
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
    private Long visit_event_id;//来访事件id
    private Long server_id;//服务器返回id(用于标识)
    private String visitor_name;//来访者名
    private String sex_type;//性别
    private Date birthday;//出生日期
    private String adress;//地址
    private String nation;//民族
    private String cert_type;//证件类型
    private String id_numer;//证件号
    private String phone;//预约电话
    private String company;//单位
    private String goods;//携带物品(文字描述)
    private String car_number;//车牌
    private String img_head;//头像(图片名)
    private String img_portrait;//人像(图片名)
    private String img_cert;//证件照片(图片名)
    private String img_goods;//携带物品(图片名)
    private String ic_number;//ic卡号(二维码为虚拟ic卡：ic-4byte后面补零 QR-5byte后面补零)
    private String physics_number;//二代证物理卡号(8byte16位)
    private Date in_time;//登记时间
    private Date out_time;//签退时间
    private String system_id;//记录标识
    private Integer is_upload_in;//登记是否上传(0未,1已)
    private Integer is_upload_out;//退出是否上传(0未,1已)
    @ToOne(joinProperty = "visit_event_id")
    VisitEventEntity visitEvent;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1560708088)
    private transient VisitInfoEntityDao myDao;

    @Generated(hash = 746256291)
    public VisitInfoEntity(Long id, Long visit_event_id, Long server_id,
                           String visitor_name, String sex_type, Date birthday, String adress,
                           String nation, String cert_type, String id_numer, String phone,
                           String company, String goods, String car_number, String img_head,
                           String img_portrait, String img_cert, String img_goods,
                           String ic_number, String physics_number, Date in_time, Date out_time,
                           String system_id, Integer is_upload_in, Integer is_upload_out) {
        this.id = id;
        this.visit_event_id = visit_event_id;
        this.server_id = server_id;
        this.visitor_name = visitor_name;
        this.sex_type = sex_type;
        this.birthday = birthday;
        this.adress = adress;
        this.nation = nation;
        this.cert_type = cert_type;
        this.id_numer = id_numer;
        this.phone = phone;
        this.company = company;
        this.goods = goods;
        this.car_number = car_number;
        this.img_head = img_head;
        this.img_portrait = img_portrait;
        this.img_cert = img_cert;
        this.img_goods = img_goods;
        this.ic_number = ic_number;
        this.physics_number = physics_number;
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

    public Long getVisit_event_id() {
        return this.visit_event_id;
    }

    public void setVisit_event_id(Long visit_event_id) {
        this.visit_event_id = visit_event_id;
    }

    public Long getServer_id() {
        return this.server_id;
    }

    public void setServer_id(Long server_id) {
        this.server_id = server_id;
    }

    public String getVisitor_name() {
        return this.visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public String getSex_type() {
        return this.sex_type;
    }

    public void setSex_type(String sex_type) {
        this.sex_type = sex_type;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNation() {
        return this.nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCert_type() {
        return this.cert_type;
    }

    public void setCert_type(String cert_type) {
        this.cert_type = cert_type;
    }

    public String getId_numer() {
        return this.id_numer;
    }

    public void setId_numer(String id_numer) {
        this.id_numer = id_numer;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGoods() {
        return this.goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getCar_number() {
        return this.car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
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

    public String getImg_cert() {
        return this.img_cert;
    }

    public void setImg_cert(String img_cert) {
        this.img_cert = img_cert;
    }

    public String getImg_goods() {
        return this.img_goods;
    }

    public void setImg_goods(String img_goods) {
        this.img_goods = img_goods;
    }

    public String getIc_number() {
        return this.ic_number;
    }

    public void setIc_number(String ic_number) {
        this.ic_number = ic_number;
    }

    public String getPhysics_number() {
        return this.physics_number;
    }

    public void setPhysics_number(String physics_number) {
        this.physics_number = physics_number;
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

    @Generated(hash = 19551344)
    private transient Long visitEvent__resolvedKey;

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 37586733)
    public VisitEventEntity getVisitEvent() {
        Long __key = this.visit_event_id;
        if (visitEvent__resolvedKey == null
                || !visitEvent__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            VisitEventEntityDao targetDao = daoSession.getVisitEventEntityDao();
            VisitEventEntity visitEventNew = targetDao.load(__key);
            synchronized (this) {
                visitEvent = visitEventNew;
                visitEvent__resolvedKey = __key;
            }
        }
        return visitEvent;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 697922519)
    public void setVisitEvent(VisitEventEntity visitEvent) {
        synchronized (this) {
            this.visitEvent = visitEvent;
            visit_event_id = visitEvent == null ? null : visitEvent.getId();
            visitEvent__resolvedKey = visit_event_id;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 7777357)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getVisitInfoEntityDao() : null;
    }


}
