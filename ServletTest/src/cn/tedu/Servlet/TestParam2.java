package cn.tedu.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "TestParam2", urlPatterns = "/TestParam2")
public class TestParam2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名(username)
        String username = request.getParameter("username");
        System.out.println("username"+username);
        //2.获取密码(pwd)
        String pwd = request.getParameter("pwd");
        System.out.println("pwd"+pwd);
        //3.获取性别(gender)
        String gender = request.getParameter("gender");
        System.out.println("gender"+gender);
        //4.获取爱好(like)
        String[] like = request.getParameterValues("like");
        System.out.println(
                Arrays.toString(like)
        );
        //5.获取城市(city)
        String city = request.getParameter("city");
        System.out.println("city"+city);
        //6.获取自我描述(description)
        String description = request.getParameter("description");
        System.out.println("description"+description);
    }
}
