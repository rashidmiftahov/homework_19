package ru.innopolis.stc09.education.dao;

import ru.innopolis.stc09.education.connect.ConnectionManager;
import ru.innopolis.stc09.education.obj.Groupp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO implements IGroup {
    private static ConnectionManager connectionManager = ConnectionManager.getInstance();

    @Override
    public List<Groupp> getAll() throws SQLException {
        ArrayList<Groupp> result = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM groupp");
        ResultSet resultSet = statement.executeQuery();
        Groupp groupp = null;
        while (resultSet.next()) {
            groupp = new Groupp(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDate("startDate"),
                    resultSet.getDate("finishDate"));
            result.add(groupp);
        }
        connection.close();
        return result;
    }
}
