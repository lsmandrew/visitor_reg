package com.ja.visitor_reg.common.util;

import com.ja.visitor_reg.entity.VisitEventEntity;
import com.ja.visitor_reg.entity.VisitInfoEntity;
import com.ja.visitor_reg.greendao.DaoSession;
import com.ja.visitor_reg.greendao.VisitEventEntityDao;
import com.ja.visitor_reg.greendao.VisitInfoEntityDao;
import com.orhanobut.logger.Logger;

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
     * @return List 返回结果
     */
    public List<VisitInfoEntity> query_VisitRecord() {
        List<VisitInfoEntity> list = null;
        list = mVisitInfoDao.queryBuilder()
                .where(VisitInfoEntityDao.Properties.Out_time.isNull())
                .build().list();

        Logger.d("query visit reocrd count=" + list.size());
        return list;
    }

    /**
     * 签退更新来访信息
     * @param mVisitId
     */
    public void update_SignOut(Long mVisitId, Date outDate) {
        //query
        List<VisitInfoEntity> list = null;
        list = mVisitInfoDao.queryBuilder()
                .where(VisitInfoEntityDao.Properties.Id.eq(mVisitId))
                .limit(1)
                .build().list();

        //update
        for (VisitInfoEntity item : list) {
            item.setOut_time(outDate);
            mVisitInfoDao.update(item);
        }
        Logger.d("update update_SignOut id: " + mVisitId);
    }

    /**
     * 查询未上传的来访时间查询
     * @param limit 查询条数
     * @return list
     */
    public List<VisitEventEntity> query_NotUploadEvent(int limit) {
        //query
        List<VisitEventEntity> list = null;
        list = mEventDao.queryBuilder()
                .where(VisitEventEntityDao.Properties.Is_upload.isNull())
                .limit(1)
                .build().list();

        Logger.d("query event not upload count= " + list.size());
        return  list;
    }
}
