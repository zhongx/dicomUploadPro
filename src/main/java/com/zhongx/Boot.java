package com.zhongx;

/**
 * Boot
 */


import com.zhongx.util.JNotifyUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Boot {

    //define Properties
    public static Properties property = null;

    //define Properties file
    public static String configFile = "D:\\eyeTransconfig.properties";

    //define local dicom folder
    public static String path;

    //define local dicom folder
    public static String distFolder;

    //define ftp Username
    public static String ftpUsername;

    //define ftp Password
    public static String ftpPassword;

    //define ftpIp
    public static String ftpIp;

    //define ftpPort
    public static int ftpPort = 21;

    // SQLServerDriver
    public static String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    //define database url
    public static String dbUrl;

    //define database user
    public static String dbUser;

    //define database password
    public static String dbPassword;

    public static void main(String[] args) {
        System.err.println("start");
        try {

            InputStream inStream = new FileInputStream(new File(configFile));
            property = new Properties();
            property.load(inStream);
            path = property.getProperty("path");
            distFolder = property.getProperty("distFolder");
            dbUrl = property.getProperty("dbUrl");
            dbUser = property.getProperty("dbUser");
            dbPassword = property.getProperty("dbPassword");
            ftpUsername = property.getProperty("ftpUsername");
            ftpPassword = property.getProperty("ftpPassword");
            ftpIp = property.getProperty("ftpIp");
            JNotifyUtil.sample();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

