package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.SuperDAO;
import lk.ijse.LibrarySystem.dao.custom.IssueDAO;
import lk.ijse.LibrarySystem.entity.Author;
import lk.ijse.LibrarySystem.entity.Issue;

import java.sql.SQLException;
import java.util.ArrayList;

public class IssueDAOImpl implements IssueDAO {
    @Override
    public boolean add(Author author) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Issue search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Issue entity) throws SQLException, ClassNotFoundException {
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
    public ArrayList<Issue> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
