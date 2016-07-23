package com.example.fangyi.googleplay.domain;

import java.util.List;

/**
 * Created by FANGYI on 2016/7/23.
 */

public class SubjectInfo {

    /**
     * des : 一周新锐游戏精选
     * url : image/recommend_01.jpg
     */

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String des;
        private String url;

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "des='" + des + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SubjectInfo{" +
                "list=" + list +
                '}';
    }
}
