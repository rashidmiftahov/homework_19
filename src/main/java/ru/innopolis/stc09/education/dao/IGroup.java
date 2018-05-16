package ru.innopolis.stc09.education.dao;

import ru.innopolis.stc09.education.obj.Groupp;

import java.sql.SQLException;
import java.util.List;

public interface IGroup {
    public List<Groupp> getAll() throws SQLException;
}
