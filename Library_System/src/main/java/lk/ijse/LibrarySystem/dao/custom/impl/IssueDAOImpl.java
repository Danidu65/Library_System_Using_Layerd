package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.custom.IssueDAO;
import lk.ijse.LibrarySystem.entity.Author;
import lk.ijse.LibrarySystem.entity.Issue;

import java.sql.SQLException;
import java.util.ArrayList;

public class IssueDAOImpl implements IssueDAO {

    @Override
    public boolean add(Issue dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Issue dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Issue search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Issue> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
