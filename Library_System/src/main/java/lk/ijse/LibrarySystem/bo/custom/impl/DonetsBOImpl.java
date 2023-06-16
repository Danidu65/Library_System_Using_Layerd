package lk.ijse.LibrarySystem.bo.custom.impl;

import lk.ijse.LibrarySystem.bo.custom.DonetsBO;
import lk.ijse.LibrarySystem.dto.DonatesDTO;
import lk.ijse.LibrarySystem.entity.Donates;

import java.sql.SQLException;
import java.util.ArrayList;

public class DonetsBOImpl implements DonetsBO {
    @Override
    public boolean donetionAdd(DonatesDTO donetion) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Donates donetionsearchFrom(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean donetionDelete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean donetionUpdate(DonatesDTO donetion) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String donetionGenarateTurnId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<DonatesDTO> loadAllDonetionIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<DonatesDTO> loadAllDonetion() throws SQLException, ClassNotFoundException {
        return null;
    }
}
