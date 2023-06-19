package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.custom.ReturnDAO;
import lk.ijse.LibrarySystem.db.DBConnection;
import lk.ijse.LibrarySystem.dto.IssueDTO;
import lk.ijse.LibrarySystem.dto.ReturnDTO;
import lk.ijse.LibrarySystem.entity.Return;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReturnDAOImpl implements ReturnDAO {

    public static boolean returnSet(ReturnDTO returns, String bookQty, String bookId, String issuseId) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into returnse values(?,?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        con.setAutoCommit(false);

        stm.setObject(1, returns.getReturnId());
        stm.setObject(2, returns.getReturnDate());
        stm.setObject(3, returns.getIssuseId());
        stm.setObject(4, returns.getIssuseDate());
        stm.setObject(5, returns.getBookId());

        int TakeIt = stm.executeUpdate();

        if (TakeIt > 0) {
            String sql2 = "update book set qty=qty+? where bookId=?";

            PreparedStatement stm2 = con.prepareStatement(sql2);

            stm2.setObject(1, bookQty);
            stm2.setObject(2, bookId);

            int itemUpdate = stm2.executeUpdate();

            if (itemUpdate > 0) {
                con.commit();
                con.setAutoCommit(true);
                return true;
            }
        }
        if (TakeIt > 0) {

            String sql3 = "DELETE FROM issuse WHERE iid=?";

            PreparedStatement stm3 = con.prepareStatement(sql3);

            stm3.setObject(1,issuseId);

            int itemUpdate1 = stm3.executeUpdate();

            if (itemUpdate1 > 0) {
                con.commit();
                con.setAutoCommit(true);
                return true;
            }
        }
        con.rollback();
        con.setAutoCommit(true);
        con.rollback();
        con.setAutoCommit(true);

        return false;
    }

    @Override
    public boolean add(Return dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Boolean update(Return dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Return search(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from issuse where iid=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,id);

        ResultSet result = stm.executeQuery();

        if(result.next()) {
            IssueDTO issue = new IssueDTO();
            issue.setMemberId(result.getString(1));
            issue.setDueDate(result.getString(2));
            issue.setIssusDate(result.getString(3));

            return issue;
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

        PreparedStatement ps = con.prepareStatement("SELECT Return_Id FROM returnse ORDER BY Return_Id DESC LIMIT 1 ");

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            String lastMemberId = rs.getString(1);

            String[] temp = lastMemberId.split("R");

            int value = Integer.parseInt((temp[1]));
            String nextValue = (value+1) + "";

            if (nextValue.length() == 1 ){
                return "R00"+ nextValue;
            }else if (nextValue.length() == 2 ){
                return "R0" + nextValue;
            }else {
                return "R";
            }


        }
        return  "R001";
    }

    @Override
    public ArrayList<Return> loadAll() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from returnse";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<Return> returns1 = new ArrayList<>();

        while (result.next()) {
            Return returns = new Return();

            returns.setReturnId(result.getString(1));
            returns.setReturnDate(result.getString(2));
            returns.setIssuseId(result.getString(3));
            returns.setIssuseDate(result.getString(4));
            returns.setBookId(result.getString(5));

            returns1.add(returns);
        }
        return returns1;
    }
}