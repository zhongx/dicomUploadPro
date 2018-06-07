package com.zhongx.util;


import com.zhongx.Boot;
import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyException;

public class JNotifyUtil {

    /**
     * JNotify monitor function
     *
     * @throws JNotifyException
     * @throws InterruptedException
     */
    public static void sample() throws JNotifyException, InterruptedException {

        //monitor folder path
        String path = Boot.path;

        //monitor user operate
        int mask = JNotify.FILE_CREATED | JNotify.FILE_DELETED | JNotify.FILE_MODIFIED | JNotify.FILE_RENAMED;

        //monitor subFolder
        boolean subTree = true;

        //start monitor
        int watchID = JNotify.addWatch(path, mask, subTree, new MyJNotifyListener());

        //set monitor time
        Thread.sleep(1000 * 60 * 1200);

        //stop monitor
        boolean res = JNotify.removeWatch(watchID);

        if (res) {
            System.err.println("stop monitor");
        }
        System.err.println(path);
    }
}
