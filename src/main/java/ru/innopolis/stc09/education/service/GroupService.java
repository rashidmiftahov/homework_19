package ru.innopolis.stc09.education.service;

import ru.innopolis.stc09.education.dao.GroupDAO;
import ru.innopolis.stc09.education.obj.Groupp;

import java.sql.SQLException;
import java.util.List;

public class GroupService {
    GroupDAO groupDAO = new GroupDAO();

    public List<Groupp> getGroupList() {
        List<Groupp> result = null;
        try {
            result = groupDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
