package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

/**
 * JDBC快速入门程序：查询jt_db.account表中的所有数据
 */
public class TestJdbc02 {
    @Test
    public void testFindAll(){
        //声明conn、stat、rs对象
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            //1.注册数据库驱动
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            //2.获取数据库连接 (导入 java.sql.Connection 包)
			/*
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/jt_db?characterEncoding=utf-8",
				"root", "1234"); */
            conn = DriverManager.getConnection(
                    "jdbc:mysql:///jt_db?characterEncoding=utf-8",
                    "root", "1234");
            //3.获取传输器 (导入 java.sql.Statement 包)
            stat = conn.createStatement();
            //4.执行SQL,返回结果 ( java.sql.ResultSet )
            String sql = "select * from account";
            rs = stat.executeQuery( sql );
            //5.处理结果(打印到控制台)
            while( rs.next() ) {
                //获取当前行的id、name、money
                int id = rs.getInt( "id" );
                String name = rs.getString( "name" );
                double money = rs.getDouble( "money" );
                System.out.println( id+","+name+","+money);
            }
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
        } finally {
            //6.释放资源(原则:越晚获取的越先关闭!)
            if( rs != null ) { //如果rs为null,则不需要关闭,反之,不为null才需要关闭!
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    /* 将rs置为null，结果集对象就会变成一个游离对象，时间一长，也会被回收 */
                    rs = null;
                }
            }
            if( stat != null ) {
                try {
                    stat.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    stat = null;
                }
            }
            if( conn != null ) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    conn = null;
                }
            }

        }
    }
}