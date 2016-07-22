package com.example.fangyi.googleplay.protocol;

import com.example.fangyi.googleplay.base.BaseProtocol;
import com.example.fangyi.googleplay.domain.AppInfo;

/**
 * Created by FANGYI on 2016/7/20.
 */

public class HomeProtocol extends BaseProtocol<AppInfo> {

    @Override
    public String getKey() {
        return "homelist";
    }

}
