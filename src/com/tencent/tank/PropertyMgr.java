package com.tencent.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: Yu Panpan
 * @Date: 2022/6/10 - 06 - 10 - 9:12
 * @Description: com.tencent.tank
 * @version: 1.0
 */
public class PropertyMgr {

    static Properties props = new Properties();

    static{
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
        if(props == null){
            return null;
        }
        return props.get(key);
    }

    //int getInt(String key)
    //String getString(String key)

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));

//        new PropertyMgr();
    }

}
