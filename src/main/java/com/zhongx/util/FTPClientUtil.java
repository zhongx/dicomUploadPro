package com.zhongx.util;


import com.zhongx.Boot;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.SocketException;
import java.text.SimpleDateFormat;


/**
 * Created by IntelliJ IDEA.
 *
 * @author zhongx 2018-5-30 10:32:39
 */
public class FTPClientUtil {
    public static Log logger = LogFactory.getLog(FTPClientUtil.class);

    private static String userName = Boot.ftpUsername;
    private static String password = Boot.ftpPassword;
    private static String ip = Boot.ftpIp;
    private static int port = 21;
    private static FTPClient ftpClient = null;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    public static int i = 1;

    /**
     * uploadFile
     *
     * @param localFile
     * @param distFolder
     * @return true success，false failure
     */
    public static boolean uploadFile(File localFile, String distFolder) {
        System.out.println("-------------------------");
        boolean flag = true;
        connectServer();
        try {

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
            InputStream input = new FileInputStream(localFile);


            String objFolder = distFolder;
            ftpClient.changeWorkingDirectory("/");
            ftpClient.makeDirectory(objFolder);
            ftpClient.changeWorkingDirectory(objFolder);
            flag = ftpClient.storeFile(localFile.getName(), input);
            if (flag) {
                System.out.println("upload file success");
            } else {
                System.out.println("upload file failure");
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.debug("local file upload failure", e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * close Connect
     */
    public static void closeConnect() {
        try {
            if (ftpClient != null) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * set File Type
     *
     * @param fileType--BINARY_FILE_TYPE、ASCII_FILE_TYPE
     */
    public static void setFileType(int fileType) {
        try {
            ftpClient.setFileType(fileType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return ftpClient
     */
    protected static FTPClient getFtpClient() {
        connectServer();
        return ftpClient;
    }


    /**
     * connect Server
     *
     * @return true  connect Server success， false connect Server failure
     */
    public static boolean connectServer() {
        boolean flag = true;
        if (ftpClient == null) {
            int reply;
            try {
                ftpClient = new FTPClient();
                ftpClient.setControlEncoding("GBK");
                ftpClient.setDefaultPort(port);
                ftpClient.configure(getFtpConfig());
                ftpClient.connect(ip);
                ftpClient.login(userName, password);
                ftpClient.setDefaultPort(port);
                reply = ftpClient.getReplyCode();
                ftpClient.setDataTimeout(120000);

                if (!FTPReply.isPositiveCompletion(reply)) {
                    ftpClient.disconnect();
                    System.err.println("FTP server refused connection.");
                    flag = false;
                }
                i++;
            } catch (SocketException e) {
                flag = false;
                e.printStackTrace();
                System.err.println("login ftp server " + ip + " timeout");
            } catch (IOException e) {
                flag = false;
                e.printStackTrace();
                System.err.println("login ftp server " + ip + " can not open");
            }
        }
        return flag;
    }

    /**
     * change Working Directory
     *
     * @param directory
     */
    public static void changeWorkingDirectory(String directory) {
        try {
            connectServer();
            ftpClient.changeWorkingDirectory(directory);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * return Directory
     */
    public static void changeToParentDirectory() {
        try {
            connectServer();
            ftpClient.changeToParentDirectory();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    /**
     * @return ftpConfig
     */
    private static FTPClientConfig getFtpConfig() {
        FTPClientConfig ftpConfig = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
        ftpConfig.setServerLanguageCode(FTP.DEFAULT_CONTROL_ENCODING);
        return ftpConfig;
    }

    /**
     * [ISO-8859-1 -> GBK]
     *
     * @param obj
     * @return ""
     */
    private static String iso8859togbk(Object obj) {
        try {
            if (obj == null) {
                return "";
            } else {
                return new String(obj.toString().getBytes("iso-8859-1"), "GBK");
            }

        } catch (Exception e) {
            return "";
        }
    }

    /**
     * make Directory
     *
     * @param dir can not contains special character; eg:  \ 、/ 、: 、* 、?、 "、 <、>...
     */
    public static boolean makeDirectory(String dir) {
        connectServer();
        boolean flag = true;
        try {
            flag = ftpClient.makeDirectory(dir);
            if (flag) {
                System.out.println("make Directory " + dir + " succeed");

            } else {
                System.out.println("make Directory " + dir + " false");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}