package com.example.fangyi.googleplay.domain;

import java.util.List;

/**
 * @author Joey Huang（QQ:273179370）
 * @created 2016/7/20
 */
public class AppInfo {
    private List<Inner>list;
    private List<String>picture;

    public List<String> getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }

    public List<Inner> getList() {
        return list;
    }

    public void setList(List<Inner> list) {
        this.list = list;
    }

    /**
     * id : 1525490
     * name : 有缘网
     * packageName : com.youyuan.yyhl
     * iconUrl : app/com.youyuan.yyhl/icon.jpg
     * stars : 4
     * size : 3876203
     * downloadUrl : app/com.youyuan.yyhl/com.youyuan.yyhl.apk
     * des : 产品介绍：有缘是时下最受大众单身男女亲睐的婚恋交友软件。有缘网专注于通过轻松、
     */

    public class Inner {


        private long id;
        private String name;
        private String packageName;
        private String iconUrl;
        private float stars;
        private float size;
        private String downloadUrl;
        private String des;

        @Override
        public String toString() {
            return "Inner{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", packageName='" + packageName + '\'' +
                    ", iconUrl='" + iconUrl + '\'' +
                    ", stars=" + stars +
                    ", size=" + size +
                    ", downloadUrl='" + downloadUrl + '\'' +
                    ", des='" + des + '\'' +
                    '}';
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public float getStars() {
            return stars;
        }

        public void setStars(float stars) {
            this.stars = stars;
        }

        public float getSize() {
            return size;
        }

        public void setSize(float size) {
            this.size = size;
        }

        public String getDownloadUrl() {
            return downloadUrl;
        }

        public void setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "list=" + list +
                ", picture=" + picture +
                '}';
    }
}
