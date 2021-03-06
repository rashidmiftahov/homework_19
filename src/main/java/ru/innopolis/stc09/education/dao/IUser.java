package ru.innopolis.stc09.education.dao;


import ru.innopolis.stc09.education.obj.User;

import java.sql.SQLException;
import java.util.List;

public interface IUser {
    public boolean add(User user);
    public User getById(int id) throws SQLException;
    public boolean update(User user);

    public boolean deleteById(int id);

    public User getUserByLogin(String login) throws SQLException;

    List<User> getStudentsByGroupId(int groupId) throws SQLException;
}
