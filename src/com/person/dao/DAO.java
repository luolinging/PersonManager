package com.person.dao;
import java.sql.Connection;

import javax.sql.DataSource;

public interface DAO {
    Connection getConnection() throws DAOException;
    public void setDataSource(DataSource dataSource);
}
