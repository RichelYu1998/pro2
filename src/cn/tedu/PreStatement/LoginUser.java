package cn.tedu.PreStatement;

import cn.tedu.Util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginUser {
    public static void main(String[] args) {
        //声明一个Scanner
        Scanner sc=new Scanner(System.in);
        //1.提示用户登录，提示用户输入用户名并接收
        System.out.println("请登录");
        System.out.println("请输入用户名:");
        String user=sc.nextLine();
        //2.提示用户输入的密码并接收
        System.out.println("请输入密码:");
        String psw=sc.nextLine();
        //3.根据用户名和密码进行登录
        Login(user,psw);
    }
/*
* 根据用户名和密码查询User表中的数据
* @param user 用户名
* @param psw 密码
* */
    private static void Login(String user, String psw) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try{
            //注册驱动并获取连接
            conn=JdbcUtil.getConn();
            //获取传输器，执行SQL并返回结果
            stmt=conn.createStatement();
            String sql="select * from user where username='"+user+"' and password='"+psw+"'";
            rs=stmt.executeQuery(sql);
            //处理结果(检查是否允许登录)
            if(rs.next()){//true--有数据
                System.out.println("登录成功");
            }
            else {
                System.out.println("登录失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn,stmt,rs);
        }
    }
}
