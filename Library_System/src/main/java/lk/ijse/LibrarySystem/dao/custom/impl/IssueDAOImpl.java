package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.SQLUtil;
import lk.ijse.LibrarySystem.dao.custom.IssueDAO;
import lk.ijse.LibrarySystem.db.DBConnection;
import lk.ijse.LibrarySystem.dto.IssueDTO;
import lk.ijse.LibrarySystem.dto.PublisherDTO;
import lk.ijse.LibrarySystem.entity.Issue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IssueDAOImpl implements IssueDAO {

    public boolean issuseFrom(IssueDTO issuse, String qty, String bookd) throws SQLException, ClassNotFoundException {
        DBConnection.getInstance().getConnection().setAutoCommit(false);

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into issuse values(?,?,?,?,?,?)";

        boolean isUpdated = SQLUtil.execute(sql,
                issuse.getIssusId(),
                issuse.getBookId(),
                issuse.getIssusDate(),
                issuse.getMemberId(),
                issuse.getDueDate(),
                issuse.getIssuseQty()
        );

        if (isUpdated) {
            String sql2 = "update book set qty=qty-? where bookId=?";

            boolean isQtyUpdated = SQLUtil.execute(sql2 , qty , bookd);

            if (isQtyUpdated) {
                con.commit();
                con.setAutoCommit(true);
                return true;
            }
            con.rollback();
            con.setAutoCommit(true);
        }
        con.rollback();
        con.setAutoCommit(true);

        return false;
    }

    @Override
    public boolean add(Issue dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Boolean update(Issue dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Issue search(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from issuse where iid = ?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            Issue issues = new Issue();
            issues.setIssusId(result.getString(1));
            issues.setBookId(result.getString(2));
            issues.setIssusDate(result.getString(3));
            issues.setMemberId(result.getString(4));
            issues.setDueDate(result.getString(5));
            issues.setIssuseQty(result.getString(6));

            return issues;
        }
        return null;
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT iid FROM issuse ORDER BY iid DESC LIMIT 1 ");

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            String lastMemberId = rs.getString(1);

            String[] temp = lastMemberId.split("I");

            int value = Integer.parseInt((temp[1]));
            String nextValue = (value+1) + "";

            if (nextValue.length() == 1 ){
                return "I00"+ nextValue;
            }else if (nextValue.length() == 2 ){
                return "I0" + nextValue;
            }else {
                return "I";
            }
        }
        return  "I001";
    }

    @Override
    public ArrayList<PublisherDTO> loadAll() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from issuse";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<IssueDTO> issuses = new ArrayList<>();

        while (result.next()) {
            IssueDTO issuse1 = new IssueDTO();

            issuse1.setIssusId(result.getString(1));
            issuse1.setBookId(result.getString(2));
            issuse1.setIssusDate(result.getString(3));
            issuse1.setMemberId(result.getString(4));
            issuse1.setDueDate(result.getString(5));
            issuse1.setIssuseQty(result.getString(6));

            issuses.add(issuse1);
        }
        return issuses;
    }
}
