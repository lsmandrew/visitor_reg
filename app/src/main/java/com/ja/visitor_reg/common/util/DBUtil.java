package com.ja.visitor_reg.common.util;

import com.ja.visitor_reg.entity.VisitEventEntity;
import com.ja.visitor_reg.entity.VisitInfoEntity;
import com.ja.visitor_reg.greendao.DaoSession;
import com.ja.visitor_reg.greendao.VisitEventEntityDao;
import com.ja.visitor_reg.greendao.VisitInfoEntityDao;
import com.orhanobut.logger.Logger;

import org.greenrobot.greendao.query.Join;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 数据库工具类
 */
public class DBUtil {

    private static DBUtil mInstance;
    private VisitEventEntityDao mEventDao;
    private VisitInfoEntityDao mVisitInfoDao;

    private DBUtil() {
        DaoSession daoSession = ApplicationUtil.getInstance().getDaoSession();
        mEventDao = daoSession.getVisitEventEntityDao();
        mVisitInfoDao = daoSession.getVisitInfoEntityDao();
    }

    public static DBUtil getInstance() {
        if (null == mInstance) {
            mInstance = new DBUtil();
        }
        return mInstance;
    }

    /**
     * 添加来访信息
     *
     * @param visitInfoEntity 来访信息实体
     */
    public void add_VisitInfo(VisitInfoEntity visitInfoEntity) {
        if (null != visitInfoEntity) {
            mVisitInfoDao.insert(visitInfoEntity);
        }

        Logger.d("insert visit entity");
    }

    /**
     * 添加來訪事件
     *
     * @param visitEventEntity 来访事件实体
     */
    public void add_VisitEvent(VisitEventEntity visitEventEntity) {
        if (null != visitEventEntity) {
            mEventDao.insert((visitEventEntity));
        }

        Logger.d("insert visit event");
    }

    /**
     * 查询来访记录
     *
     * @return List 返回结果
     */
    public List<VisitInfoEntity> query_VisitRecord() {
        List<VisitInfoEntity> list = null;
//        list = mVisitInfoDao.queryBuilder()
//                .where(VisitInfoEntityDao.Properties.Out_time.isNull())
//                .build().list();
        QueryBuilder<VisitInfoEntity> qb = mVisitInfoDao.queryBuilder();
        Join visitEvent = qb.join(VisitInfoEntityDao.Properties.Visit_event_id, VisitEventEntity.class,
                VisitEventEntityDao.Properties.Id);
        list = qb.where(VisitInfoEntityDao.Properties.Out_time.isNull())
                .list();

        Logger.d("query visit reocrd count=" + list.size());
        return list;
    }

    /**
     * 签退更新来访信息
     *
     * @param mVisitId
     */
    public void update_SignOut(Long mVisitId, Date outDate) {
        //query
        List<VisitInfoEntity> list = null;
        list = mVisitInfoDao.queryBuilder()
                .where(VisitInfoEntityDao.Properties.Id.eq(mVisitId))
                .limit(1)
                .list();

        //update
        for (VisitInfoEntity item : list) {
            item.setOut_time(outDate);
            mVisitInfoDao.update(item);
        }
        Logger.d("update update_SignOut id: " + mVisitId);
    }

    /**
     * 查询未上传的来访事件查询
     *
     * @param limit 查询条数
     * @return list
     */
    public List<VisitEventEntity> query_NotUploadEvent(int limit) {
        //query
        List<VisitEventEntity> list = null;
        list = mEventDao.queryBuilder()
                .where(VisitEventEntityDao.Properties.Is_upload.isNull())
                .limit(limit)
                .list();

        Logger.d("query event not upload count= " + list.size());
        return list;
    }

    /**
     * 查询未上传的来访信息
     *
     * @param limit 条数
     * @return list
     */
    public List<VisitInfoEntity> query_NotUploadVisitInfo(int limit) {
        //query
        List<VisitInfoEntity> list = null;
        QueryBuilder<VisitInfoEntity> qb = mVisitInfoDao.queryBuilder();
        //来访事件已上传并且来访信息未上传
        Join visitEvent = qb.join(VisitInfoEntityDao.Properties.Visit_event_id, VisitEventEntity.class,
                VisitEventEntityDao.Properties.Id);
        visitEvent.where(VisitEventEntityDao.Properties.Is_upload.eq(1));//来访事件已上传
        qb.where(VisitInfoEntityDao.Properties.Is_upload_in.isNull());//未上传
        list = qb.limit(limit).list();

        Logger.d("query visit info not upload count= " + list.size());
        return list;
    }

    /**
     * 查询未上传的来访签退信息
     *
     * @param limit 查询条数
     * @return list
     */
    public List<VisitInfoEntity> query_NotUploadVisitOut(int limit) {
        //query
        List<VisitInfoEntity> list = null;
        QueryBuilder<VisitInfoEntity> qb = mVisitInfoDao.queryBuilder();
        //已签退来访信息已上传签退信息未上传
        qb.where(VisitInfoEntityDao.Properties.Out_time.isNotNull(),
                qb.and(VisitInfoEntityDao.Properties.Is_upload_in.eq(1),
                        VisitInfoEntityDao.Properties.Is_upload_out.isNull()));
        list = qb.limit(limit).list();

        Logger.d("query visit out not upload count= " + list.size());
        return list;
    }

    /**
     * 查询未上传的图片
     *
     * @param limit 条数
     * @return list
     */
    public List<VisitInfoEntity> query_NotUploadImg(int limit) {
        //query
        List<VisitInfoEntity> list = null;
        QueryBuilder<VisitInfoEntity> qb = mVisitInfoDao.queryBuilder();
        qb.and(VisitInfoEntityDao.Properties.Is_upload_in.eq(1),
                VisitInfoEntityDao.Properties.Is_upload_img.notEq(0xFF));
        list = qb.limit(limit).list();
        //no img update (按位判断1:证件头像 2:证件照 3:现场人像 4:证件扫描图像 5:携带物品)
        for (VisitInfoEntity item : list) {
            int isUploadMark = null == item.getIs_upload_img() ? 0 : item.getIs_upload_img();//防止空
            if (StringUtil.isEmptyTrimed(item.getImg_head())){
                isUploadMark |= 0x01;
            }
            if (StringUtil.isEmptyTrimed(item.getImg_cert())){
                isUploadMark |= 0x02;
            }
            if (StringUtil.isEmptyTrimed(item.getImg_portrait())){
                isUploadMark |= 0x04;
            }
            if (StringUtil.isEmptyTrimed(item.getImg_scan())){
                isUploadMark |= 0x08;
            }
            if (StringUtil.isEmptyTrimed(item.getImg_goods())){
                isUploadMark |= 0x10;
            }
            if (0x1F == isUploadMark) {//没有拍照或照片已经都上传完成
                isUploadMark = 0xFF;
                list = new ArrayList<VisitInfoEntity>();
                break;
            }
            item.setIs_upload_img(isUploadMark);
            mVisitInfoDao.update(item);
        }
        Logger.d("query img not upload = " + list.size());
        return list;
    }

    /**
     * 更新上传来访事件成功
     *
     * @param eventEntity
     */
    public void update_UploadEventSuccess(VisitEventEntity eventEntity) {
        //update
        eventEntity.setIs_upload(1);
        mEventDao.update(eventEntity);
        Logger.d("update event upload success ");
    }


    /**
     * 更新上传来访信息成功
     *
     * @param visitInfoEntity
     */
    public void update_UploadVisitorSuccess(VisitInfoEntity visitInfoEntity) {
        //update
        visitInfoEntity.setIs_upload_in(1);
        mVisitInfoDao.update(visitInfoEntity);
        Logger.d("update  visitinfo upload success");
    }


    /**
     * 更新上传签退信息成功
     *
     * @param visitInfoEntity 来访信息
     */
    public void update_uploadVisitOutSuccess(VisitInfoEntity visitInfoEntity) {
        //update
        visitInfoEntity.setIs_upload_out(1);
        mVisitInfoDao.update(visitInfoEntity);
        Logger.d("update  visit out upload success");
    }

    /**
     * 更新上传图片成功
     *
     * @param visitInfoEntity 记录信息
     * @param uploadMark 上传标识
     */
    public void update_UploadImgSuccess(VisitInfoEntity visitInfoEntity, int uploadMark) {
        //update
        visitInfoEntity.setIs_upload_img(uploadMark);
        mVisitInfoDao.update(visitInfoEntity);
        Logger.d("update img upload success");
    }
}
