package lk.ijse.LibrarySystem.bo.custom.impl;

import lk.ijse.LibrarySystem.bo.custom.ReturnBO;
import lk.ijse.LibrarySystem.dto.ReturnDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReturnBOImpl implements ReturnBO {
    @Override
    public boolean returnSet(ReturnDTO returns, String Qty, String BookId, String IssuseID) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<ReturnDTO> loadAllDonetion() throws SQLException, ClassNotFoundException {
        return null;
    }
}
