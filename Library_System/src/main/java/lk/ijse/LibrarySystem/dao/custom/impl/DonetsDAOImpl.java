package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.custom.DonetsDAO;
import lk.ijse.LibrarySystem.dto.PublisherDTO;
import lk.ijse.LibrarySystem.entity.Donates;

import java.sql.SQLException;
import java.util.ArrayList;

public class DonetsDAOImpl implements DonetsDAO {

    @Override
    public boolean add(Donates dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Boolean update(Donates dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Donates search(String id) throws SQLException, ClassNotFoundException {
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