package cn.tedu.jdbc;

import cn.tedu.Util.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * 完成JDBC的增删改查操作
 */
public class TestJdbc03 {
    /* 1、新增:往account表中添加一个名称为john、money为3500的记录 */
    @Test
    public void testInsert() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1.注册驱动,获取连接
           /* Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jt_db?characterEncoding=utf-8",
                    "root","1234");*/
            conn = JdbcUtil.getConn();
            //获取传输器
            stmt = conn.createStatement();
            //执行SQL,返回结果
            String sql = "insert into account value(null,'john',3500)";
            int rows = stmt.executeUpdate(sql);
            //输出结果
            System.out.println("影响行数:" + rows);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JdbcUtil.close(conn, stmt, rs);
        }
    }

    /* 2、修改:将account表中名称为john的记录，money修改为1500 */
    @Test
    public void testUpdate() {
        Connection conn = null;
        Statement stmt = null;
        //ResultSet rs=null;
        try {
            conn = JdbcUtil.getConn();
            stmt = conn.createStatement();
            String sql = "update account set money=1500 where name='john'";
            int rows = stmt.executeUpdate(sql);
            System.out.println("影响行数:" + rows);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn, stmt, null);
        }
    }

    /* 3、查询:查询account表中名称为john的记录 */
    @Test
    public void testFind() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConn();
            stmt = conn.createStatement();
            String sql = "select * from account where name='john'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double money = rs.getDouble("money");
                System.out.println(id + "," + name + "," + money);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn, stmt, rs);
        }
    }

    /* 4、删除:删除account表中名称为john的记录 */
    @Test
    public void testDelete() {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try{
            conn=JdbcUtil.getConn();
            stmt=conn.createStatement();
            String sql="delete from account where name='john'";
            int rows = stmt.executeUpdate( sql );
            //处理结果
            System.out.println( "影响行数: "+rows );
            //输出结果
            System.out.println("影响行数:" + rows);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn,stmt,rs);
        }
    }
}
