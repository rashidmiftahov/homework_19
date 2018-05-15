package ru.innopolis.stc09.education.dao;

import ru.innopolis.stc09.education.connect.ConnectionManager;
import ru.innopolis.stc09.education.obj.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO {
    private static ConnectionManager connectionManager = ConnectionManager.getInstance();

    public Role getById(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM role WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Role role = null;
        if (resultSet.next()) {
            role = new Role(
                    resultSet.getInt("id"),
                    resultSet.getString("name"));
        }
        connection.close();
        return role;
    }
}
