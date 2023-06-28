package lk.ijse.LibrarySystem.bo.custom;

import lk.ijse.LibrarySystem.bo.SuperBO;
import lk.ijse.LibrarySystem.dto.ReturnDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReturnBO extends SuperBO {
    public  boolean ReturnSet(ReturnDTO returns, String Qty, String BookId, String IssuseID) throws SQLException;
    public ArrayList<ReturnDTO> loadAll() throws SQLException, ClassNotFoundException;

}
