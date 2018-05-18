package ru.innopolis.stc09.education.service;

import ru.innopolis.stc09.education.dao.UserDAO;
import ru.innopolis.stc09.education.obj.User;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    UserDAO userDAO = new UserDAO();

    public List<User> getStudentsList(int groupId) {
        List<User> result = null;
        try {
            result = userDAO.getStudentsByGroupId(groupId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
