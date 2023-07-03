package lk.ijse.LibrarySystem.bo.custom.impl;

import lk.ijse.LibrarySystem.bo.custom.ReturnBO;
import lk.ijse.LibrarySystem.dao.custom.ReturnDAO;
import lk.ijse.LibrarySystem.dto.ReturnDTO;
import lk.ijse.LibrarySystem.entity.Return;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReturnBOImpl implements ReturnBO {
    @Override
    public boolean ReturnSet(ReturnDTO returns, String Qty, String BookId, String IssuseID) throws SQLException {
        return ReturnDAO.ReturnSet(new Return(
                        returns.getReturnId(),
                        returns.getIssuseId(),
                        returns.getRreturnQty(),
                        returns.getReturnDate() ,
                        returns.getBookId(),
                        returns.getIssuseDate()),
                Qty,BookId,IssuseID);
    }
    @Override

    public ArrayList<ReturnDTO> loadAll() throws SQLException, ClassNotFoundException {
        ArrayList<ReturnDTO> allReturns = new ArrayList<>();

        for (Return r : ReturnDAO.loadAll()) {
            allReturns.add(new ReturnDTO(r.getReturnId(), r.getReturnDate(), r.getIssuseId(), r.getIssuseDate(), r.getBookId()));
        }
        return allReturns;
    }
}
