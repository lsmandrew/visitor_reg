package com.ja.visitor_reg.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.ja.visitor_reg.entity.VisitInfoEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "VisitInfo_Table".
*/
public class VisitInfoEntityDao extends AbstractDao<VisitInfoEntity, Long> {

    public static final String TABLENAME = "VisitInfo_Table";

    /**
     * Properties of entity VisitInfoEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Visitor_name = new Property(1, String.class, "visitor_name", false, "VISITOR_NAME");
        public final static Property Visit_event_id = new Property(2, Long.class, "visit_event_id", false, "VISIT_EVENT_ID");
        public final static Property Id_numer = new Property(3, String.class, "id_numer", false, "ID_NUMER");
        public final static Property Sex = new Property(4, String.class, "sex", false, "SEX");
        public final static Property Book_phone = new Property(5, String.class, "book_phone", false, "BOOK_PHONE");
        public final static Property Deparment = new Property(6, String.class, "deparment", false, "DEPARMENT");
        public final static Property Goods = new Property(7, String.class, "goods", false, "GOODS");
        public final static Property Img_head = new Property(8, String.class, "img_head", false, "IMG_HEAD");
        public final static Property Img_portrait = new Property(9, String.class, "img_portrait", false, "IMG_PORTRAIT");
        public final static Property Img_goods = new Property(10, String.class, "img_goods", false, "IMG_GOODS");
        public final static Property In_time = new Property(11, java.util.Date.class, "in_time", false, "IN_TIME");
        public final static Property Out_time = new Property(12, java.util.Date.class, "out_time", false, "OUT_TIME");
        public final static Property System_id = new Property(13, String.class, "system_id", false, "SYSTEM_ID");
        public final static Property Is_upload_in = new Property(14, Integer.class, "is_upload_in", false, "IS_UPLOAD_IN");
        public final static Property Is_upload_out = new Property(15, Integer.class, "is_upload_out", false, "IS_UPLOAD_OUT");
    }


    public VisitInfoEntityDao(DaoConfig config) {
        super(config);
    }
    
    public VisitInfoEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"VisitInfo_Table\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"VISITOR_NAME\" TEXT," + // 1: visitor_name
                "\"VISIT_EVENT_ID\" INTEGER," + // 2: visit_event_id
                "\"ID_NUMER\" TEXT," + // 3: id_numer
                "\"SEX\" TEXT," + // 4: sex
                "\"BOOK_PHONE\" TEXT," + // 5: book_phone
                "\"DEPARMENT\" TEXT," + // 6: deparment
                "\"GOODS\" TEXT," + // 7: goods
                "\"IMG_HEAD\" TEXT," + // 8: img_head
                "\"IMG_PORTRAIT\" TEXT," + // 9: img_portrait
                "\"IMG_GOODS\" TEXT," + // 10: img_goods
                "\"IN_TIME\" INTEGER," + // 11: in_time
                "\"OUT_TIME\" INTEGER," + // 12: out_time
                "\"SYSTEM_ID\" TEXT," + // 13: system_id
                "\"IS_UPLOAD_IN\" INTEGER," + // 14: is_upload_in
                "\"IS_UPLOAD_OUT\" INTEGER);"); // 15: is_upload_out
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"VisitInfo_Table\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, VisitInfoEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String visitor_name = entity.getVisitor_name();
        if (visitor_name != null) {
            stmt.bindString(2, visitor_name);
        }
 
        Long visit_event_id = entity.getVisit_event_id();
        if (visit_event_id != null) {
            stmt.bindLong(3, visit_event_id);
        }
 
        String id_numer = entity.getId_numer();
        if (id_numer != null) {
            stmt.bindString(4, id_numer);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(5, sex);
        }
 
        String book_phone = entity.getBook_phone();
        if (book_phone != null) {
            stmt.bindString(6, book_phone);
        }
 
        String deparment = entity.getDeparment();
        if (deparment != null) {
            stmt.bindString(7, deparment);
        }
 
        String goods = entity.getGoods();
        if (goods != null) {
            stmt.bindString(8, goods);
        }
 
        String img_head = entity.getImg_head();
        if (img_head != null) {
            stmt.bindString(9, img_head);
        }
 
        String img_portrait = entity.getImg_portrait();
        if (img_portrait != null) {
            stmt.bindString(10, img_portrait);
        }
 
        String img_goods = entity.getImg_goods();
        if (img_goods != null) {
            stmt.bindString(11, img_goods);
        }
 
        java.util.Date in_time = entity.getIn_time();
        if (in_time != null) {
            stmt.bindLong(12, in_time.getTime());
        }
 
        java.util.Date out_time = entity.getOut_time();
        if (out_time != null) {
            stmt.bindLong(13, out_time.getTime());
        }
 
        String system_id = entity.getSystem_id();
        if (system_id != null) {
            stmt.bindString(14, system_id);
        }
 
        Integer is_upload_in = entity.getIs_upload_in();
        if (is_upload_in != null) {
            stmt.bindLong(15, is_upload_in);
        }
 
        Integer is_upload_out = entity.getIs_upload_out();
        if (is_upload_out != null) {
            stmt.bindLong(16, is_upload_out);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, VisitInfoEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String visitor_name = entity.getVisitor_name();
        if (visitor_name != null) {
            stmt.bindString(2, visitor_name);
        }
 
        Long visit_event_id = entity.getVisit_event_id();
        if (visit_event_id != null) {
            stmt.bindLong(3, visit_event_id);
        }
 
        String id_numer = entity.getId_numer();
        if (id_numer != null) {
            stmt.bindString(4, id_numer);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(5, sex);
        }
 
        String book_phone = entity.getBook_phone();
        if (book_phone != null) {
            stmt.bindString(6, book_phone);
        }
 
        String deparment = entity.getDeparment();
        if (deparment != null) {
            stmt.bindString(7, deparment);
        }
 
        String goods = entity.getGoods();
        if (goods != null) {
            stmt.bindString(8, goods);
        }
 
        String img_head = entity.getImg_head();
        if (img_head != null) {
            stmt.bindString(9, img_head);
        }
 
        String img_portrait = entity.getImg_portrait();
        if (img_portrait != null) {
            stmt.bindString(10, img_portrait);
        }
 
        String img_goods = entity.getImg_goods();
        if (img_goods != null) {
            stmt.bindString(11, img_goods);
        }
 
        java.util.Date in_time = entity.getIn_time();
        if (in_time != null) {
            stmt.bindLong(12, in_time.getTime());
        }
 
        java.util.Date out_time = entity.getOut_time();
        if (out_time != null) {
            stmt.bindLong(13, out_time.getTime());
        }
 
        String system_id = entity.getSystem_id();
        if (system_id != null) {
            stmt.bindString(14, system_id);
        }
 
        Integer is_upload_in = entity.getIs_upload_in();
        if (is_upload_in != null) {
            stmt.bindLong(15, is_upload_in);
        }
 
        Integer is_upload_out = entity.getIs_upload_out();
        if (is_upload_out != null) {
            stmt.bindLong(16, is_upload_out);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public VisitInfoEntity readEntity(Cursor cursor, int offset) {
        VisitInfoEntity entity = new VisitInfoEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // visitor_name
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // visit_event_id
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // id_numer
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // sex
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // book_phone
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // deparment
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // goods
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // img_head
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // img_portrait
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // img_goods
            cursor.isNull(offset + 11) ? null : new java.util.Date(cursor.getLong(offset + 11)), // in_time
            cursor.isNull(offset + 12) ? null : new java.util.Date(cursor.getLong(offset + 12)), // out_time
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // system_id
            cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14), // is_upload_in
            cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15) // is_upload_out
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, VisitInfoEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setVisitor_name(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setVisit_event_id(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setId_numer(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSex(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setBook_phone(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDeparment(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setGoods(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setImg_head(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setImg_portrait(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setImg_goods(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setIn_time(cursor.isNull(offset + 11) ? null : new java.util.Date(cursor.getLong(offset + 11)));
        entity.setOut_time(cursor.isNull(offset + 12) ? null : new java.util.Date(cursor.getLong(offset + 12)));
        entity.setSystem_id(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setIs_upload_in(cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14));
        entity.setIs_upload_out(cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(VisitInfoEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(VisitInfoEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(VisitInfoEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}