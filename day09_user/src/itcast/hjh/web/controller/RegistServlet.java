package itcast.hjh.web.controller;

import java.io.IOException;

public class RegistServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //1、对表单字段的合法性进行校验 （formbean）
        //2、如果校验失败，跳回到表单页面，回显校验失败信息
        //3、如果校验成功，则调用service处理注册请求
        //4、如果service处理不成功，用户已存在，则跳回到注册页面
        //5、如果service处理不成功，为其他问题，则跳转到网站的全局消息显示页面，为用户显示友好错误消息
        //6、如果service处理成功。则跳转到全局消息显示页面，为用户显示注册成功消息

    }
}
