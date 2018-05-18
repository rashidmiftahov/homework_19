package ru.innopolis.stc09.education.controller;

import ru.innopolis.stc09.education.obj.User;
import ru.innopolis.stc09.education.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentsController extends HttpServlet {
    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String groupId = req.getParameter("groupId");
        List<User> students = studentService.getStudentsList(Integer.parseInt(groupId));
        req.setAttribute("students", students);
        req.setAttribute("groupId", groupId);
        req.getRequestDispatcher("/students.jsp").forward(req, resp);
    }
}
