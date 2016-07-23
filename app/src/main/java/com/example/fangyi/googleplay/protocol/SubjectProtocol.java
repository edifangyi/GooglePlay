package com.example.fangyi.googleplay.protocol;

import com.example.fangyi.googleplay.base.BaseProtocol;
import com.example.fangyi.googleplay.domain.SubjectInfo;

/**
 * Created by FANGYI on 2016/7/20.
 */

public class SubjectProtocol extends BaseProtocol<SubjectInfo> {

    @Override
    public String getKey() {
        return "subjectlist";
    }

}
