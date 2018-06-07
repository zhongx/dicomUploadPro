package com.zhongx.util;



import com.zhongx.bsoft.DicomTrans;
import net.contentobjects.jnotify.JNotifyListener;

public class MyJNotifyListener implements JNotifyListener {


    @Override
    public void fileCreated(int wd, String rootPath, String name) {
        System.err.println("created " + rootPath + " : " + name);
    }

    @Override
    public void fileDeleted(int wd, String rootPath, String name) {
        System.err.println("deleted " + rootPath + " : " + name);
    }

    @Override
    public void fileRenamed(int wd, String rootPath, String oldName, String newName) {
        System.err.println("renamed " + rootPath + " : " + oldName + " -> " + newName);
    }

    @Override
    public void fileModified(int wd, String rootPath, String name) {
        System.err.println("modified " + rootPath + " : " + name);
        //32 bit  OS
        DicomTrans.transDicom(rootPath, name);
        //64 bit OS
       // DicomTrans.transDicom64(rootPath, name);
    }


}