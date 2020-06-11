package cn.tedu.c3p0;

//import com.mchange.v2.c3p0.ComboPooledDataSource;
import cn.tedu.Util.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestC3P0 {
    /* 测试c3p0连接池的使用：往User表中插入一条用户信息 */
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        //创建一个连接池(存放连接的容器)对象
        //ComboPooledDataSource pool = new ComboPooledDataSource();

        try {
            //设置连接数据库的基本信息
            //注册驱动并获取连接(创建连接对象-->造船)
            //conn = JdbcUtil.getConn();
            //从连接池中获取一个连接对象
           // conn = pool.getConnection();

            //获取传输器,执行sql语句,并返回执行结果
            String sql = "insert into user value(null, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString( 1, "赵云130" );
            ps.setString( 2, "123456" );
            int rows = ps.executeUpdate();
            System.out.println( "影响行数: "+rows );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /* conn.close()方法在这里是关闭连接 */
            JdbcUtil.close(conn, ps, null);
            /* 如果是自己创建的连接对象，这个连接对象没有经过任何的改动，调用
             * conn.close方法，是将连接对象关闭
             * 如果是从连接池中获取的连接对象，该连接对象在返回时就已经被连接池
             * 改造了，将连接对象的close方法改为了还连接到连接池中
             */
        }
    }
}





