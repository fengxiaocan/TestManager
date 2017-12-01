package com.evil.testmanager;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * The type Save utils.
 *
 * @name： BaseApp
 * @package： com.fxc.util
 * @author: Noah.冯 QQ:1066537317
 * @time: 17 :18
 * @version: 1.1
 * @desc： 保存工具类
 */
public final class SaveUtils{

    /**
     * Save.
     *
     * @param file
     *         the file
     * @param value
     *         the value
     */
    public static void save(File file,Object value){
        FileOutputStream fos = null;
        ObjectOutputStream os = null;
        try{
            fos = new FileOutputStream(file);
            os = new ObjectOutputStream(fos);
            os.writeObject(value);
            os.close();
        }catch(Exception e){
        }finally{
            closeIO(fos,os);
        }
    }


    /**
     * Save.
     *
     * @param <T>
     *         the type parameter
     * @param file
     *         the file
     *
     * @return the t
     */
    public static <T> T get(File file){
        FileInputStream fis = null;
        ObjectInputStream os = null;
        T t = null;
        try{
            fis = new FileInputStream(file);
            os = new ObjectInputStream(fis);
            t = (T) os.readObject();
            os.close();
        }catch(Exception e){
        }finally{
            closeIO(fis,os);
        }
        return t;
    }


    /**
     * 关闭IO
     *
     * @param closeables closeables
     */
    public static void closeIO(Closeable... closeables) {
        if (closeables == null) return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
