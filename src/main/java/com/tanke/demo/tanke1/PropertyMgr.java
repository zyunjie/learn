package com.tanke.demo.tanke1;

import java.io.IOException;
import java.util.Properties;

/**
 * created by zyj on 2020/5/19
 */
public class PropertyMgr {

    static Properties props= new Properties();
    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
       if (props==null){return null;}
       return props.get(key);
    }
}
