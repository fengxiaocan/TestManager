package com.evil.testmanager;

import java.io.Serializable;

/**
 * @name： TestManager
 * @package： com.evil.testmanager
 * @author: Noah.冯 QQ:1066537317
 * @time: 14:26
 * @version: 1.1
 * @desc： TODO
 */

public class PName implements Serializable{

    private String appName;
    private String packageName;

    public PName(){
    }

    public PName(String appName,String packageName){
        this.appName = appName;
        this.packageName = packageName;
    }

    public String getAppName(){
        return appName==null?"未知":appName;
    }

    public void setAppName(String appName){
        this.appName = appName;
    }

    public String getPackageName(){
        return packageName;
    }

    public void setPackageName(String packageName){
        this.packageName = packageName;
    }
}
