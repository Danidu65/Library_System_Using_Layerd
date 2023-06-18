package lk.ijse.LibrarySystem.tm;

import lk.ijse.LibrarySystem.db.DBConnection;
import lk.ijse.LibrarySystem.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

    public static UserDTO SearchUser(String name) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from user where userName = ?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, name);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            UserDTO user = new UserDTO();
            user.setName(result.getString(1));
            user.setUserName(result.getString(2));
            user.setPassWord(result.getString(3));
            return user;
        }

        return null;
    }

    public static boolean singUp(UserDTO user) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO user(name , userName, password) VALUES(?, ?, ?)";

        PreparedStatement stm = con.prepareStatement(sql);

       stm.setObject(1,user.getName());
       stm.setObject(2,user.getUserName());
       stm.setObject(3,user.getPassWord());

        int result = stm.executeUpdate();
        return result > 0;
    }
}
