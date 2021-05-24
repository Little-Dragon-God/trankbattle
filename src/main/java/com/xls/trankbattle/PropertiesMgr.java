package com.xls.trankbattle;

import java.io.IOException;
import java.util.Properties;

public class PropertiesMgr {
    static Properties propt = new Properties();
    static {
        //加载配置文件
        try {
            propt.load(PropertiesMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object get(String key){
        if (propt == null)
            return null;
        return propt.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertiesMgr.get("initTankCount"));
    }
}
