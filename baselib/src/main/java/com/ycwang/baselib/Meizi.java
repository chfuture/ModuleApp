package com.ycwang.baselib;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author ycwang.
 * @date 2018-8-15.
 */

@Entity(nameInDb = "mei_zi")
public class Meizi {

    @Id(autoincrement = true)
    public long _id;

    public String source;

    @NotNull
    public String url;

    @Transient
    public String add;

    @Generated(hash = 1438151240)
    public Meizi(long _id, String source, @NotNull String url) {
        this._id = _id;
        this.source = source;
        this.url = url;
    }

    @Generated(hash = 507723578)
    public Meizi() {
    }

    public long get_id() {
        return this._id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
