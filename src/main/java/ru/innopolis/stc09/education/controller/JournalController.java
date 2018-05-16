package ru.innopolis.stc09.education.controller;

import ru.innopolis.stc09.education.obj.Groupp;
import ru.innopolis.stc09.education.service.GroupService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JournalController extends HttpServlet {
    private GroupService groupService = new GroupService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Groupp> groupps = groupService.getGroupList();
        req.setAttribute("groupps", groupps);
        req.getRequestDispatcher("/journal.jsp").forward(req, resp);
    }

}
