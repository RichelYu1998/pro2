package cn.tedu.PreStatement;

import cn.tedu.Util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * 练习PreparedStatement
 * */
public class TestPreparedStatement {
    public static void main(String[] args) {
        //声明一个Scanner
        Scanner sc = new Scanner(System.in);
        //1.提示用户登录，提示用户输入用户名并接收
        System.out.println("请输入想添加的信息");
        System.out.println("请输入用户名:");
        String user = sc.nextLine();
        //2.提示用户输入的密码并接收
        System.out.println("请输入密码:");
        String psw = sc.nextLine();
        //3.根据用户名和密码进行登录
        testInsert(user, psw);
        testFindAll();
    }

    /*练习1.往user表中，插入一条用户信息: 孙尚香 123456*/
    private static void testInsert(String user, String psw) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtil.getConn();
            String sql = "insert into user value (null,?,?)";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, psw);
            int rows = pstmt.executeUpdate();
            System.out.println("影响行数:" + rows);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn, pstmt, null);
        }
    }

    /*练习2.查询user表中所有信息，并输出所有信息到控制台
     * 如果SQL语句中无参，那就不需要设置参数
     * */
    private static void testFindAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConn();
            String sql = "select * from user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(id + "，" + username + "，" + password);
            }
            System.out.println("------------------------------------------------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
