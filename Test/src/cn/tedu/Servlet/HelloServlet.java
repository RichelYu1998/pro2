package cn.tedu.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
public class HelloServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = -4893468351035679241L;

    /*
     * doPost方法:浏览器访问当前Servlet,请求方式为GET提交，将会调用doPost
     * 方法来处理请求
     * 如果GET提交和POST提交代码相同
     * 可以将所有处理请求的代码都放在doGet方法中，在doPost方法中调用doGet方法
     * 这样一来，无论是GET提交，还是POST提交，最终都会调用DoGet方法处理请求
     * */
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    /*
    * doGet方法:浏览器访问当前Servlet，请求方式为GET提交，将会调用doGet
    * 方法来处理请求
    * */
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("HelloServlet.doGet()...");
        //做出响应(alt+shift+L)
        PrintWriter out=response.getWriter();
        //向浏览器发送数据(暂时不写中文)
        out.write("Hello Word"+new Date());
        out.write("hello java");
    }
}
