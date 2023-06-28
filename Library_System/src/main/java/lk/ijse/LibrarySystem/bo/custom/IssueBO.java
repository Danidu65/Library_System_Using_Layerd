package lk.ijse.LibrarySystem.bo.custom;

import lk.ijse.LibrarySystem.bo.SuperBO;
import lk.ijse.LibrarySystem.dto.IssueDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IssueBO extends SuperBO {
    public  boolean issuseFrom(IssueDTO issuse, String qty, String Bookd) throws SQLException, ClassNotFoundException;
    public IssueDTO searchIssuseFrom(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<IssueDTO> loadAllIssuses() throws SQLException, ClassNotFoundException;
}
