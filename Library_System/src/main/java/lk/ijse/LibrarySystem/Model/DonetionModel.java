package lk.ijse.LibrarySystem.Model;

import lk.ijse.LibrarySystem.db.DBConnection;
import lk.ijse.LibrarySystem.dto.DonatesDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DonetionModel {
    public static boolean DonetionAdd(DonatesDTO donetion) throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into donetion values(?,?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, donetion.getDonetionId());
        stm.setObject(2, donetion.getAmmount());
        stm.setObject(4, donetion.getReview());
        stm.setObject(3, donetion.getDonetionName());
        stm.setObject(5, donetion.getExibitionId());

        return stm.executeUpdate() > 0;
    }
    public static ArrayList<DonatesDTO> loadAllDonetions() throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from donetion";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<DonatesDTO> donates = new ArrayList<>();

        while (result.next()) {
            DonatesDTO donates1 = new DonatesDTO();
            donates1.setDonetionId(result.getString(1));
            donates1.setAmmount(Double.parseDouble(result.getString(2)));
            donates1.setReview(result.getString(3));
            donates1.setDonetionName(result.getString(4));
            donates1.setExibitionId(result.getString(5));

            donates.add(donates1);
        }

        return donates;
    }
}
