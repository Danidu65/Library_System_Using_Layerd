package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.custom.PublisherDAO;
import lk.ijse.LibrarySystem.db.DBConnection;
import lk.ijse.LibrarySystem.entity.Author;
import lk.ijse.LibrarySystem.entity.Publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PublisherDAOImpl implements PublisherDAO {
    @Override
    public boolean add(Author publisher) throws SQLException, ClassNotFoundException {
//        Connection con = DBConnection.getInstance().getConnection();
//        String sql = "INSERT INTO publisher (publisherId, name, yearOfPublish,publishedBook) VALUES(?, ?, ?, ?)";
//
//        PreparedStatement stm = con.prepareStatement(sql);
//
//        stm.setObject(1,publisher.getId());
//        stm.setObject(2,publisher.getName());
//        stm.setObject(3,publisher.getYear());
//        stm.setObject(4,publisher.getPublishedBook());
//
//        int result = stm.executeUpdate();
//        return result > 0;
        return false;
    }

    @Override
    public Publisher search(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from publisher where publisherId=?";


        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,id);

        ResultSet result = stm.executeQuery();

        if(result.next()) {
            Publisher publisher = new Publisher();
            publisher.setId(result.getString(1));
            publisher.setName(result.getString(2));
            publisher.setYear(result.getString(3));
            publisher.setPublishedBook(result.getString(4));

            return publisher;
        }
        return null;
    }

    @Override
    public boolean update(Publisher entity) throws SQLException, ClassNotFoundException {
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
    public ArrayList<Publisher> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
