package cn.tedu.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** JDBC工具类 */
public class JdbcUtil {
    /**
     * 获取数据库连接对象并返回
     * @return Connection对象
     * @throws Exception
     */
    public static Connection getConn() throws Exception{
        //1.注册驱动
        Class.forName( "com.mysql.cj.jdbc.Driver" );
        //2.获取连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql:///jt_db?characterEncoding=utf-8&serverTimezone=GMT%2B8",
                "root",
                "1234");
        return conn;
    }

    /**
     * 释放JDBC程序中的资源
     * @param conn 连接对象
     * @param stmt 传输器对象
     * @param rs 结果集对象
     */
    public static void close(Connection conn,
                             Statement stmt, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
                rs = null;
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
                stmt = null;
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
                conn = null;
            }
        }
    }
}
