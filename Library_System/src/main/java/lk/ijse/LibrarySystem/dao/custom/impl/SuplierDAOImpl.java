package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.custom.SuplierDAO;
import lk.ijse.LibrarySystem.db.DBConnection;
import lk.ijse.LibrarySystem.dto.SuplierDTO;
import lk.ijse.LibrarySystem.entity.Suplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class SuplierDAOImpl implements SuplierDAO {
    @Override
    public boolean add(Suplier suplier) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO supplier values (?, ?, ?, ? , ?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,suplier.getId());
        stm.setObject(2,suplier.getName());
        stm.setObject(3,suplier.getContact());
        stm.setObject(4,suplier.getAddress());
        stm.setObject(5,suplier.getSuplierBooks());

//        int result = stm.executeUpdate();
        return  stm.executeUpdate() > 0;
    }

    @Override
    public Suplier search(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from supplier where supplierId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,id);

        ResultSet result = stm.executeQuery();

        if(result.next()) {
            SuplierDTO suplier = new SuplierDTO();
            suplier.setId(result.getString(1));
            suplier.setName(result.getString(2));
            suplier.setContact(result.getString(3));
            suplier.setAddress(result.getString(4));
            suplier.setSuplierBooks(result.getString(5));

            return suplier;
        }
        return null;
    }

    @Override
    public boolean update(Suplier suplier) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "update supplier set name=?,contact=?,Address=?,supliyBooks=? where SupplierId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, suplier.getName());
        stm.setObject(2, suplier.getContact());
        stm.setObject(3,suplier.getAddress());
        stm.setObject(4,suplier.getSuplierBooks());
        stm.setObject(5, suplier.getId());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "delete from supplier where supplierId = ?";

        PreparedStatement stm = con.prepareStatement(sql);
        stm.setObject(1,id);
        int result = stm.executeUpdate();

        return false;
    }

    @Override
    public ArrayList<Suplier> getAll() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from supplier";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<Suplier> supliers = new ArrayList<>();

        while(result.next()) {
            SuplierDTO suplier = new SuplierDTO();

            suplier.setId(result.getString(1));
            suplier.setName(result.getString(2));
            suplier.setContact(result.getString(3));
            suplier.setAddress(result.getString(4));
            suplier.setSuplierBooks(result.getString(5));

            supliers.add(suplier);
        }
        return supliers;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT SupplierId FROM supplier ORDER BY SupplierId DESC LIMIT 1 ");

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String lastMemberId = rs.getString(1);

            String[] temp = lastMemberId.split("S");

            int value = Integer.parseInt((temp[1]));
            String nextValue = (value + 1) + "";

            if (nextValue.length() == 1) {
                return "S00" + nextValue;
            } else if (nextValue.length() == 2) {
                return "S0" + nextValue;
            } else {
                return "S";
            }


        }
        return "S001";
    }
}
