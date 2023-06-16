package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.SuperDAO;
import lk.ijse.LibrarySystem.dao.custom.ExibitionDAO;
import lk.ijse.LibrarySystem.entity.Author;
import lk.ijse.LibrarySystem.entity.Exibition;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExibitionDAOImpl implements ExibitionDAO {
    @Override
    public boolean add(Author author) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Exibition search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Exibition entity) throws SQLException, ClassNotFoundException {
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
    public ArrayList<Exibition> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
