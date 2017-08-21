package com.yoyiyi.soleil.bean.region;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 18:30
 * 描述:分区类型Type
 */
public class RegionTagType implements Parcelable {

    /**
     * tid : 13
     * reid : 0
     * name : 番剧
     * logo :
     * goto :
     * param :
     * children : [{"tid":33,"reid":13,"name":"连载动画","logo":"http://i0.hdslb.com/u_user/54f589cd0573f9ab5c735698ae156d19.png","goto":"","param":""},{"tid":32,"reid":13,"name":"完结动画","logo":"http://i0.hdslb.com/u_user/18ad593e4b2f90b233f817e028bee71d.png","goto":"","param":""},{"tid":153,"reid":13,"name":"国产动画","logo":"http://i0.hdslb.com/u_user/405774aed11d0538a3548109a598fd80.png","goto":"","param":""},{"tid":51,"reid":13,"name":"资讯","logo":"","goto":"","param":""},{"tid":152,"reid":13,"name":"官方延伸","logo":"http://i0.hdslb.com/u_user/a78fa47e8f25772d51db1a19fe8b310f.png","goto":"","param":""}]
     */

    public int tid;
    public int reid;
    public String name;
    public String logo;
    @SerializedName("goto")
    public String gotoX;
    public String param;
    public List<ChildrenBean> children;

    public static class ChildrenBean implements Parcelable {

        /**
         * tid : 33
         * reid : 13
         * name : 连载动画
         * logo : http://i0.hdslb.com/u_user/54f589cd0573f9ab5c735698ae156d19.png
         * goto :
         * param :
         */

        public int tid;
        public int reid;
        public String name;
        public String logo;
        @SerializedName("goto")
        public String gotoX;
        public String param;

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.tid);
            dest.writeInt(this.reid);
            dest.writeString(this.name);
            dest.writeString(this.logo);
            dest.writeString(this.gotoX);
            dest.writeString(this.param);
        }

        public ChildrenBean() {
        }

        protected ChildrenBean(Parcel in) {
            this.tid = in.readInt();
            this.reid = in.readInt();
            this.name = in.readString();
            this.logo = in.readString();
            this.gotoX = in.readString();
            this.param = in.readString();
        }

        public static final Creator<ChildrenBean> CREATOR = new Creator<ChildrenBean>() {
            @Override
            public ChildrenBean createFromParcel(Parcel source) {
                return new ChildrenBean(source);
            }

            @Override
            public ChildrenBean[] newArray(int size) {
                return new ChildrenBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.tid);
        dest.writeInt(this.reid);
        dest.writeString(this.name);
        dest.writeString(this.logo);
        dest.writeString(this.gotoX);
        dest.writeString(this.param);
        dest.writeList(this.children);
    }

    public RegionTagType() {
    }

    public RegionTagType(Parcel in) {
        this.tid = in.readInt();
        this.reid = in.readInt();
        this.name = in.readString();
        this.logo = in.readString();
        this.gotoX = in.readString();
        this.param = in.readString();
        this.children = new ArrayList<ChildrenBean>();
        in.readList(this.children, ChildrenBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<RegionTagType> CREATOR = new Parcelable.Creator<RegionTagType>() {
        @Override
        public RegionTagType createFromParcel(Parcel source) {
            return new RegionTagType(source);
        }

        @Override
        public RegionTagType[] newArray(int size) {
            return new RegionTagType[size];
        }
    };
}
