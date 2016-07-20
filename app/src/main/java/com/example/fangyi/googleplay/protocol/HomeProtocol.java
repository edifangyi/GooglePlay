package com.example.fangyi.googleplay.protocol;

import com.example.fangyi.googleplay.domain.App;
import com.example.fangyi.googleplay.domain.New;
import com.example.fangyi.googleplay.utils.FileUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.socks.library.KLog;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;
import com.yolanda.nohttp.tools.IOUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.example.fangyi.googleplay.global.GlobalContants.CATEGORIES_URL;

/**
 * Created by FANGYI on 2016/7/20.
 */

public class HomeProtocol {

    public void load(int index) {


        loadServer(index);//请求服务器
//
//        //请求服务器
//        String json = loadLocal(index);//读取缓存
//
//        if (json == null) {
//            loadServer(index);//请求服务器
//        }
//
//        if (json != null) {
//            paserJson(json);//解析
//        }

    }

    /**
     * 解析数据
     *
     * @param json
     */
    private void paserJson(String json) {
        List<New>mList;//结果
        List<String>mPicture=new ArrayList<>();//结果

        Gson gson = new Gson();
        try {
            JSONObject object = new JSONObject(json);
            //解析list
            String list = object.getString("list");
            Type type = new TypeToken<List<New>>() {
            }.getType();
            mList = gson.fromJson(list, type);
            //解析picture
            JSONArray picture = object.getJSONArray("picture");
            int length = picture.length();
            for (int i = 0; i < length; i++) {
                mPicture.add(picture.getString(i));
            }
            for (String s : mPicture) {
                KLog.e(s);
            }
            for (New n : mList) {
                KLog.e(n.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void paserJson2(String json) {
        Gson gson = new Gson();
        App md = gson.fromJson(json, App.class);
        KLog.e("1 ==================== "+md);

    }

    /**
     * 把数据保存到本地
     * <p>
     * //1.把整个json文件写到一个本地文件中
     * //2.把每条数据都摘除存到数据库中
     *
     * @param json
     * @param index
     */
    private void saveLocal(String json, int index) {
        //在第一行写一个过期时间

        BufferedWriter bw = null;
        try {
            File dir = FileUtils.getCacheDir();// /mnt/sdcard/GooglePlay/cache
            File file = new File(dir, "home_" + index);
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(System.currentTimeMillis() + 1000 * 100 + "");
            bw.newLine();//换行
            bw.write(json);//把整个json文件保存起来
            bw.flush();
            bw.close();
            KLog.e(2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(bw);
        }

    }


    /**
     * 联网
     *
     * @param index
     * @return
     */
    private void loadServer(int index) {

        String url = CATEGORIES_URL + index;

        getHttpRequest(url, index);//请求方式
    }

    /**
     * 读取本地缓存
     *
     * @param index
     * @return
     */
    private String loadLocal(int index) {
        //如果发现文件已经过期，就不要再复用保存
        File dir = FileUtils.getCacheDir();//获取缓存文件夹
        File file = new File(dir, "home_" + index);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            long outOfDate = Long.parseLong(br.readLine());//获取过期时间
            if (System.currentTimeMillis() > outOfDate) {
                return null;
            } else {
                String str = null;
                StringWriter sw = new StringWriter();
                while ((str = br.readLine()) != null) {
                    sw.write(str);
                }
                return sw.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /* 响应码 */
    private static final int NOHTTP_WHAT_TEST = 0x001;

    /**
     * 使用NoHttp请求网络
     *
     * @param url
     * @param index
     */
    private void getHttpRequest(String url, final int index) {

        RequestQueue requestQueue = NoHttp.newRequestQueue();
        // 创建请求对象
        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.GET);


        requestQueue.add(NOHTTP_WHAT_TEST, request, new OnResponseListener<String>() {

            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                if (what == NOHTTP_WHAT_TEST) {
                    // 请求成功
                    // 响应结果
                    String json = response.get();
//
//                    if (json != null) {
//                        saveLocal(json, index);//保存为本地缓存
//                    }

                    if (json != null) {
//                        paserJson(json);//解析
                        paserJson2(json);
                    }

                }
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {

            }

            @Override
            public void onFinish(int what) {

            }
        });

    }

}
