package com.example.fangyi.googleplay.domain;

/**
 * Created by FANGYI on 2016/7/20.
 */

public class AppInfo {
    private Inner list;
    public Inner getList() {
        return list;
    }

    public void setList(Inner list) {
        this.list = list;
    }
    public class Inner {
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

        private int id;
        private String name;
        private String packageName;
        private String iconUrl;
        private int stars;
        private int size;
        private String downloadUrl;
        private String des;

        public int getId() {
            return id;
        }

        public void setId(int id) {
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

        public int getStars() {
            return stars;
        }

        public void setStars(int stars) {
            this.stars = stars;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
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
}
