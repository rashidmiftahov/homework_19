package ru.innopolis.stc09.education.dao;

import ru.innopolis.stc09.education.connect.ConnectionManager;
import ru.innopolis.stc09.education.obj.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements IUser {
    private static ConnectionManager connectionManager = ConnectionManager.getInstance();

    @Override
    public boolean add(User user) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO public.\"user\"(fullname, role_id, login, password)\n" +
                    "\tVALUES (?, ?, ?, ?) WHERE id = ?");
            statement.setString(1, user.getFullname());
            statement.setInt(2, user.getRole_id());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
            statement.setInt(5, user.getId());
            ResultSet resultSet = statement.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getById(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * " +
                "FROM user WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        User user = null;
        if (resultSet.next()) {
            user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("fullname"),
                    resultSet.getInt("role_id"),
                    resultSet.getString("login"),
                    resultSet.getString("password"));
        }
        connection.close();
        return user;

    }

    @Override
    public boolean update(User user) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE public.\"user\"\n" +
                    "\tSET fullname=?, role_id=?, login=?, password=?\n" +
                    "\tWHERE id=?;");
            statement.setString(1, user.getFullname());
            statement.setInt(2, user.getRole_id());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
            statement.setInt(5, user.getId());
            ResultSet resultSet = statement.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        try {
            String query = "DELETE FROM user WHERE id=?";
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserByLogin(String login) throws SQLException {
        User result = null;
        Connection connection = new ConnectionManager().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                "* FROM public.\"user\" " +
                "WHERE login=?");
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            result = new User(resultSet.getInt("id"), resultSet.getString("login"),
                    resultSet.getString("password"), resultSet.getInt("role_id"));
        }
        connection.close();
        return result;
    }
}
