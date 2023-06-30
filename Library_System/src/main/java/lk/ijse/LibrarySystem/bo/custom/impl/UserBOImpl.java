package lk.ijse.LibrarySystem.bo.custom.impl;

import lk.ijse.LibrarySystem.bo.custom.UserBO;
import lk.ijse.LibrarySystem.dao.DAOFactory;
import lk.ijse.LibrarySystem.dao.custom.impl.UserDAOImpl;
import lk.ijse.LibrarySystem.dto.UserDTO;
import lk.ijse.LibrarySystem.entity.User;

import java.sql.SQLException;

public abstract class UserBOImpl implements UserBO {

    UserDAOImpl userDAO = (UserDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean userAdd(UserDTO user) throws SQLException, ClassNotFoundException {
        userDAO.add(new User(user.getUserName(), user.getName(), user.getPassWord()));
        return false;
    }

    @Override
    public User usersearchFrom(String id) throws SQLException, ClassNotFoundException {
        return userDAO.search(id);
    }
}
