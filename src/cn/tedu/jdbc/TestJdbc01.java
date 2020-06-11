package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

/**
 * JDBC快速入门程序：
 */
public class TestJdbc01 {
    @Test
    public void testFindAll() throws Exception {
        //1.注册数据库驱动
        Class.forName( "com.mysql.cj.jdbc.Driver" );
        //2.获取数据库连接 (导入 java.sql.Connection 包)
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jt_db?characterEncoding=utf-8",
                "root", "1234");
        //3.获取传输器 (导入 java.sql.Statement 包)
        Statement stat = conn.createStatement();
        //4.执行SQL,返回结果 ( java.sql.ResultSet )
        String sql = "select * from account";
        ResultSet rs = stat.executeQuery( sql );
        //5.处理结果(打印到控制台)
        while( rs.next() ) {
            //获取当前行的id、name、money
            int id = rs.getInt( "id" );
            String name = rs.getString( "name" );
            double money = rs.getDouble( "money" );
            System.out.println( id+","+name+","+money);
        }
        //6.释放资源(原则:越晚获取的越先关闭!)
        rs.close();
        stat.close();
        conn.close();
        System.out.println("TestJdbc01.testFindAll()");
    }
}



