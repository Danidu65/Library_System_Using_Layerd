package lk.ijse.LibrarySystem.bo.custom;

import lk.ijse.LibrarySystem.bo.SuperBO;
import lk.ijse.LibrarySystem.dto.DonatesDTO;
import lk.ijse.LibrarySystem.entity.Donates;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DonetsBO extends SuperBO {
    public boolean donetionAdd(DonatesDTO donetion) throws SQLException, ClassNotFoundException;
    public Donates donetionsearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean donetionDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean donetionUpdate(DonatesDTO donetion) throws SQLException, ClassNotFoundException;
    public String donetionGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<DonatesDTO> loadAllDonetionIds() throws SQLException, ClassNotFoundException;
    public ArrayList<DonatesDTO> loadAllDonetion() throws SQLException, ClassNotFoundException;
}
