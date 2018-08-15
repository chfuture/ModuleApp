package com.ycwang.daomanager;

import android.content.Context;

import com.ycwang.baselib.Meizi;

import java.util.List;

/**
 * @author ycwang.
 * @date 2018-8-15.
 */
public class MeiziDaoUtil {

    private static final String TAG = MeiziDaoUtil.class.getSimpleName();


    private DaoManager mManager;

    public MeiziDaoUtil(Context context) {
        this.mManager = DaoManager.getInstance();
        mManager.init(context);
    }


    public boolean insert(Meizi meizi) {
        boolean flag;
        flag = mManager.getDaoSession().insert(meizi) != -1;
        return flag;
    }

    public boolean insert(final List<Meizi> list) {
        boolean flag;
        try {
            mManager.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (Meizi meizi : list) {
                        mManager.getDaoSession().insert(meizi);
                    }
                }
            });
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }


    public boolean update(Meizi meizi) {
        boolean flag;
        try {
            mManager.getDaoSession().update(meizi);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public boolean delete(Meizi meizi) {
        boolean flag;
        try {
            mManager.getDaoSession().delete(meizi);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public boolean deleteAll() {
        boolean flag;
        try {
            mManager.getDaoSession().deleteAll(Meizi.class);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public List<Meizi> queryAll() {
        return mManager.getDaoSession().loadAll(Meizi.class);
    }

    public Meizi queryById(long key) {
        return mManager.getDaoSession().load(Meizi.class, key);
    }

}
