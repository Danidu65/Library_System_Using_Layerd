package lk.ijse.LibrarySystem.dao.custom;

import lk.ijse.LibrarySystem.dao.CrudDAO;
import lk.ijse.LibrarySystem.entity.Return;

public interface ReturnDAO extends CrudDAO<Return> {
    static boolean ReturnSet(Return aReturn, String qty, String bookId, String issuseID) {
    }
}
