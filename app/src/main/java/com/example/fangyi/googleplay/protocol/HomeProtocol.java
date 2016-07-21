package com.example.fangyi.googleplay.protocol;

import com.example.fangyi.googleplay.domain.AppInfo;
import com.example.fangyi.googleplay.utils.FileUtils;
import com.google.gson.Gson;
import com.socks.library.KLog;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;
import com.yolanda.nohttp.tools.IOUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import static com.example.fangyi.googleplay.global.GlobalContants.CATEGORIES_URL;

/**
 * Created by FANGYI on 2016/7/20.
 */

public class HomeProtocol {


    private AppInfo md;
    private Request<String> request;
    private Response<String> response;

    public AppInfo load(int index) {
//        String json = loadServer(index);//请求服务器

        //请求服务器
        String json = loadLocal(index);//读取缓存
        KLog.e("1 == " + json);

        if (json == null) {
            json = loadServer(index);//请求服务器
        }

        if (json != null) {
            saveLocal(json, index);//保存为本地缓存
            md = paserJson(json);//解析
        }

        KLog.e("7.最后的信息 ======= " + md);
        return md;
    }

    /**
     * 解析数据
     *
     * @param json
     */
    private AppInfo paserJson(String json) {
        Gson gson = new Gson();
        AppInfo getAppInfo = gson.fromJson(json, AppInfo.class);
        return getAppInfo;
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
    private String loadServer(int index) {

        String getJson = null;

        String url = CATEGORIES_URL + index;
        KLog.e(url);

        // 创建请求对象
        request = NoHttp.createStringRequest(url, RequestMethod.GET);
        response = NoHttp.startRequestSync(request);
        getJson = response.get();

        KLog.e("3.getJson ====" + getJson);
//        if (response.isSucceed()) {
//            // 请求成功
//            getJson = response.get();
//            KLog.e("3.给json赋值，json ====" + getJson);
//        } else {
//            // 请求失败
//        }
        return getJson;
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

}
