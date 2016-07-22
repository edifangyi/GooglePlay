package com.example.fangyi.googleplay.global;

/**
 * 定义全局参数
 *
 * @author Kevin
 */
public class GlobalContants {
//    http://192.168.1.113:8080/WebInfos/app/homelist1
//    http://127.0.0.1:8080/WebInfos/app/homelist1
    public static final String SERVER_URL = "http://192.168.1.102:8080/WebInfos/";
    public static final String SERVER_APP_URL = "http://192.168.1.102:8080/WebInfos/app/";
    public static final String HOME_URL = SERVER_URL + "homelist";// 获取分类信息的接口
    public static final String SUBJECT_URL = SERVER_URL + "app/subjectlist";// 获取分类信息的接口

    public static final String PHOTOS_URL = SERVER_URL + "photos/photos_1.json";// 获取组图信息的接口


}
