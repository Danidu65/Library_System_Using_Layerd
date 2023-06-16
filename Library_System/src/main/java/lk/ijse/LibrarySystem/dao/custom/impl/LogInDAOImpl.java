package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.custom.LoginDAO;
import lk.ijse.LibrarySystem.entity.Author;
import lk.ijse.LibrarySystem.entity.Login;

import java.sql.SQLException;
import java.util.ArrayList;

public class LogInDAOImpl implements LoginDAO {
    @Override
    public boolean add(Author author) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Login search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Login entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Login> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
