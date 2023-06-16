package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.custom.ExibitionDAO;
import lk.ijse.LibrarySystem.dto.PublisherDTO;
import lk.ijse.LibrarySystem.entity.Exibition;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExibitionDAOImpl implements ExibitionDAO {

    @Override
    public boolean add(Exibition dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Boolean update(Exibition dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Exibition search(String id) throws SQLException, ClassNotFoundException {
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
    public ArrayList<PublisherDTO> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}