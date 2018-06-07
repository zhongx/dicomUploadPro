package com.zhongx.util;


import com.zhongx.Boot;
import com.zhongx.dicom.DrtbMetaEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {

    private static final String DBDRIVER = Boot.dbDriver;
    private static final String DBURL = Boot.dbUrl;
    private static final String DBUSER = Boot.dbUser;
    private static final String DBPASSWORD = Boot.dbPassword;

    private static Connection conn = null;

    private static PreparedStatement ps = null;

    private static ResultSet rs = null;

    /*
     * get database Connection
     */
    public static Connection getConnection() {

        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
            System.out.println("success load SQL Server Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("can not load SQL Server Driver ");
            System.out.println(e.toString());
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static ResultSet select(String sql) throws Exception {
        try {
            conn = getConnection();
            ps = (PreparedStatement) conn.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException sqle) {
            throw new SQLException("select data Exception: " + sqle.getMessage());
        } catch (Exception e) {
            throw new Exception("System error: " + e.getMessage());
        }
    }

    /*
     * INSERT INTO TABLE drtb_meta
     */
    public static void insert(DrtbMetaEntity entity) throws Exception {
        String sql = "INSERT INTO drtb_meta (fguid,StudyDate,SeriesDate,ContentDate,StudyTime,SeriesTime,ContentTime,PatientID,PatientName,InstanceNumber,SeriesDescription,ImageComments,filename,flag) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt;
        int i = 0;
        try {
            conn = getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, entity.getFguid());
            pstmt.setString(2, entity.getStudyDate());
            pstmt.setString(3, entity.getSeriesDate());
            pstmt.setString(4, entity.getContentDate());
            pstmt.setString(5, entity.getStudyTime());
            pstmt.setString(6, entity.getSeriesTime());
            pstmt.setString(7, entity.getContentTime());
            pstmt.setString(8, entity.getPatientID());
            pstmt.setString(9, entity.getPatientName());
            pstmt.setString(10, entity.getInstanceNumber());
            pstmt.setString(11, entity.getSeriesDescription());
            pstmt.setString(12, entity.getImageComments());
            pstmt.setString(13, entity.getFilename());
            pstmt.setString(14, entity.getFlag());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException sqle) {
            throw new SQLException("insert data Exception: " + sqle.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                throw new Exception("ps close exception: " + e.getMessage());
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                throw new Exception("conn close exception: " + e.getMessage());
            }

        }

    }


}
