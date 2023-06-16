package lk.ijse.LibrarySystem.bo.custom;

import lk.ijse.LibrarySystem.dto.UserDTO;
import lk.ijse.LibrarySystem.entity.User;

import java.sql.SQLException;

public interface UserBO extends SuplierBO{
    public boolean userAdd(UserDTO user) throws SQLException, ClassNotFoundException;
    public User usersearchFrom(String id) throws SQLException, ClassNotFoundException;
}
