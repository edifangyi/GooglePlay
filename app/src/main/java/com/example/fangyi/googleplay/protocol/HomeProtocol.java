package com.example.fangyi.googleplay.protocol;

import com.example.fangyi.googleplay.global.GlobalContants;
import com.socks.library.KLog;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;

/**
 * Created by FANGYI on 2016/7/20.
 */

public class HomeProtocol {
    public void load(int index) {
        //请求服务类
        String json = loadLocal(index);//读取缓存
        if (json == null) {

            json = loadServer(index);//请求服务器
            if (json != null) {
                saveLocal(json, index);//保存
            }
        }

        if (json!=null) {
            paserJson(json);//解析
        }

    }

    private void paserJson(String json) {

    }

    private void saveLocal(String json, int index) {

    }

    private String loadServer(int index) {
        index = 1;
        String url = GlobalContants.CATEGORIES_URL + index;

        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.GET);
        String s = request.toString();
        KLog.e(s);
        return s;
    }


    private String loadLocal(int index) {
        return null;
    }
}
