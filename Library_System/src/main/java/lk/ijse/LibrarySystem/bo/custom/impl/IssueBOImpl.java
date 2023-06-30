package lk.ijse.LibrarySystem.bo.custom.impl;

import lk.ijse.LibrarySystem.bo.custom.IssueBO;
import lk.ijse.LibrarySystem.dao.CrudDAO;
import lk.ijse.LibrarySystem.dao.DAOFactory;
import lk.ijse.LibrarySystem.dao.custom.IssueDAO;
import lk.ijse.LibrarySystem.dao.custom.impl.IssueDAOImpl;
import lk.ijse.LibrarySystem.dto.IssueDTO;
import lk.ijse.LibrarySystem.entity.Issue;

import java.sql.SQLException;
import java.util.ArrayList;

public class IssueBOImpl implements IssueBO {
    IssueDAOImpl issuseDAO = (IssueDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ISSUSE);
    @Override
    public boolean issuseFrom(IssueDTO issuse, String qty, String Bookd) throws SQLException, ClassNotFoundException {
        /*issueDAO.issuseFrom(new IssueDTO(issuse.getIssusId(),issuse.getBookId(),issuse.getIssusDate(),issuse.getMemberId(),issuse.getDueDate(),issuse.getIssuseQty()));
        return issueDAO.issuseFrom(issuse);*/
        return false;
    }

    @Override
    public IssueDTO searchIssuseFrom(String id) throws SQLException, ClassNotFoundException {
        Issue issuse = (Issue) CrudDAO.search(id);
        return new IssueDTO(issuse.getIssusId(),issuse.getIssusDate(),issuse.getMemberId(),issuse.getBookId(),issuse.getDueDate(),issuse.getIssuseQty());
    }

    @Override
    public ArrayList<IssueDTO> loadAllIssuses() throws SQLException, ClassNotFoundException {
        return null;
    }
}
