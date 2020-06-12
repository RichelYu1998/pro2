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
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        System.out.println("AServlet.doGet()...");
        /*
        *   将请求转发给BServlet，由BServlet进行响应
        *  （1）转发是一次请求，一次响应
           （2）请求转发前后，浏览器的地址栏地址不会发生变化。（浏览器--访问--> A --转发--> B，地址栏地址始终指向A的地址）
           （3）请求转发前后的request对象是同一个（转发前在A中的request和转发到B后，B中的request对象和A中的request对象是同一个。基于这一点，可以通过request从A带数据到B）
           （4）请求转发前后的两个资源必须属于同一个Web应用，否则将无法进行转发。（A--转发-->B，A和B必须属于同一个Web应用！）
        * */
        request.getRequestDispatcher("BServlet").forward(request, response);
    }
}
