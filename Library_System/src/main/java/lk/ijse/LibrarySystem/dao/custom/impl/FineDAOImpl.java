package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.custom.FineDAO;
import lk.ijse.LibrarySystem.dto.PublisherDTO;
import lk.ijse.LibrarySystem.entity.Fines;

import java.sql.SQLException;
import java.util.ArrayList;

public class FineDAOImpl implements FineDAO {

    @Override
    public boolean add(Fines dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Boolean update(Fines dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Fines search(String id) throws SQLException, ClassNotFoundException {
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
