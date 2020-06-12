package cn.tedu.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AServlet", urlPatterns = "/AServlet")
public class AServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        System.out.println("AServlet.doGet()...");
        /*
        *   将请求转发给BServlet，由BServlet进行响应
        * (1)进行转发的两个资源必须属于同一个Web应用，否则失败
        * (2)转发时的路径不可以出现当前Web应用的访问路径，因为服务器自动添加
        * */
        request.getRequestDispatcher("BServlet").forward(request,response);
    }
}
