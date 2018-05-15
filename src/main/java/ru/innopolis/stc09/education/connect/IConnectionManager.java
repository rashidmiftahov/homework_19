package ru.innopolis.stc09.education.connect;

import java.sql.Connection;

public interface IConnectionManager {
    public Connection getConnection();
}
