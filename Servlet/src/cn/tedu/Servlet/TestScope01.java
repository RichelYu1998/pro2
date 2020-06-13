package cn.tedu.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestScope01", urlPatterns = "/TestScope01")
public class TestScope01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //----------------------------------------------------------
        System.out.println("TestScope01.doGet()...");
        //往request对象的map集合存入一条数据
        String[] names={"刘德华","张学友","郭富城","黎明"};
        request.setAttribute("names",names);
        //将请求发给TestScope02(会将request对象的数据一并带过去)
        request.getRequestDispatcher("TestScope02").forward(request,response);
    }
}
