package com.zhongx.bsoft;


import com.zhongx.Boot;
import com.zhongx.dicom.DicomUtil;
import com.zhongx.dicom.DrtbMetaEntity;
import com.zhongx.util.FTPClientUtil;
import com.zhongx.util.JDBCUtils;

import java.io.File;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 *
 * @author zhongx 2018-6-2
 */
public class DicomTrans {

    public static HashMap<String, Object> map = new HashMap<String, Object>() {{
        put("key", "value");
    }};
    public static String key;
    public static String value;
    public static String distFolder = Boot.distFolder;

    //32 bit operating system  call this function
    public static void transDicom(String rootPath, String name) {
        File file = new File(rootPath + "\\" + name);
        if (file.isDirectory()) {
            //ftp create Directory
            System.err.println("start create directory" + " -> " + rootPath + "/" + name);
            FTPClientUtil.makeDirectory(distFolder + File.separator + name);
        } else {
            System.err.println("start create dicom file" + " -> " + rootPath + "/" + name);
            boolean flag = FTPClientUtil.uploadFile(file, distFolder + File.separator + name.substring(0, name.indexOf("\\")));
            if (flag) {
                //insert the relationship with patient and the path of dicom file
                DicomUtil dicomUtil = new DicomUtil();
                DrtbMetaEntity entity = dicomUtil.readDicom(file);
                if (entity != null) {
                    entity.setFilename(distFolder + "/" + name);
                    entity.setFlag("1");
                    try {
                        JDBCUtils.insert(entity);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println("insert failure");
                    }
                }
            } else {
                System.err.println("upload failure");
            }

        }
    }

    //64 bit operating system  call this function
    public static void transDicom64(String rootPath, String name) {
        key = "modified" + rootPath + name;
        value = rootPath + name;
        if (!getfileModifiedTimes(key)) {
            map.put(key, value);
            File file = new File(rootPath + "\\" + name);
            if (file.isDirectory()) {
                //ftp create Directory
                System.err.println("start create directory" + " -> " + rootPath + "/" + name);
                FTPClientUtil.makeDirectory(distFolder + File.separator + name);
                map.remove(key);
            } else {
                System.err.println("start create dicom file" + " -> " + rootPath + "/" + name);
            }
        } else {
            File file = new File(rootPath + "\\" + name);
            System.err.println("end create dicom file" + " -> " + rootPath + "/" + name);
            boolean flag = FTPClientUtil.uploadFile(file, distFolder + File.separator + name.substring(0, name.indexOf("\\")));
            if (flag) {
                //insert the relationship with patient and the path of dicom file
                DicomUtil dicomUtil = new DicomUtil();
                DrtbMetaEntity entity = dicomUtil.readDicom(file);
                if (entity != null) {
                    entity.setFilename(distFolder + "/" + name);
                    entity.setFlag("1");
                    try {
                        JDBCUtils.insert(entity);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println("insert failure");
                    }
                }
            } else {
                System.err.println("upload failure");
            }
            map.remove(key);
        }
    }


    //fix  the bug of JNotify，On 64 bit OS，the create of file will trigger twice fileModified
    public static boolean getfileModifiedTimes(String key) {
        boolean exsist;
        if (map.containsKey(key)) {
            exsist = true;
        } else {
            exsist = false;
        }
        return exsist;
    }

}
