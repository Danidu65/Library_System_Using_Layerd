package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.custom.AutorDAO;
import lk.ijse.LibrarySystem.db.DBConnection;
import lk.ijse.LibrarySystem.entity.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutorDAOImpl implements AutorDAO {
    @Override
    public boolean add(Autor author) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO author(authorId, Name, bookName) VALUES(?, ?, ?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,author.getId());
        stm.setObject(2,author.getName());
        stm.setObject(3,author.getBookName());

        return stm.executeUpdate() > 0;

    }

    @Override
    public Autor search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Autor entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Autor> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
