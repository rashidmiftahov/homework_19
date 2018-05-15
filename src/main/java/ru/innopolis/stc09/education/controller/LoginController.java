package ru.innopolis.stc09.education.controller;

import ru.innopolis.stc09.education.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String login = req.getParameter("userName");
        String password = req.getParameter("userPassword");
        if (userService.checkAuthorization(login, password) == 1) {
            req.getSession().setAttribute("login", login);
            resp.sendRedirect(req.getContextPath() + "/teacher/journal");
        } else if (userService.checkAuthorization(login, password) == 2) {
            req.getSession().setAttribute("login", login);
            resp.sendRedirect(req.getContextPath() + "/student/notes");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login?errorMsg=authErr");
        }
    }
}
