package lk.ijse.LibrarySystem.bo.custom.impl;

import lk.ijse.LibrarySystem.bo.custom.UserBO;
import lk.ijse.LibrarySystem.dto.UserDTO;
import lk.ijse.LibrarySystem.entity.User;

import java.sql.SQLException;

public abstract class UserBOImpl implements UserBO {
    @Override
    public boolean userAdd(UserDTO user) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public User usersearchFrom(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
