package com.bwie.test.home.model;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：王兵洋  2017/8/3 16:25
 * 类的用途：Json数据解析的Bean
 */
public class ConfigResponse implements Serializable {

    public String ucUrl;
    public String mallUrl;
    public String templateUrl;
    public String configUrl;
    public String androidVer;
    public String androidDes;
    public String androidUrl;
    public String iOSVer;
    public String iOSDes;
    public String iOSUrl;
    public String appName;
    public int forceUpdate;
    public String webUrl;
    public String activityUrl;
    public String officialIcon;
    public String founderBDAppID;
    public String founderBDUrl;
    public String ucTabisShow;
    public String ucTabPosition;
    public String ucTabString;
    public String ucTabIcon;
    public List<?> adv;

    public static ConfigResponse objectFromData(String str) {
        return new com.google.gson.Gson().fromJson(str, ConfigResponse.class);
    }
}
