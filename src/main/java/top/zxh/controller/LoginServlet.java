package top.zxh.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.zxh.entity.User;
import top.zxh.service.UserService;
import top.zxh.utils.ResponseUtils;

import java.io.IOException;

/**
 * Date:2023/3/1
 * Author：zxh
 * Description: 用户登录控制层
 */
@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        //接收用户输入，前端用表单键值对的形式传参
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        //调用业务逻辑
        ResponseUtils resp;
        try {
            User user = userService.login(username, password);
            System.out.println(user);
            user.setPassword(null);
            user.setSalt(null);
            // 响应结果, "0" 代表处理成功,非 "0"代表处理失败
            resp = new ResponseUtils().put("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            // 登录失败，service会执行 throw new LoginException 操作，在这里捕获，并将失败原因返回给客户端
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        // 返回JSON 结果
        response.getWriter().println(resp.toJsonString());
    }
}
