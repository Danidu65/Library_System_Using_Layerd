package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.SuperDAO;
import lk.ijse.LibrarySystem.dao.custom.BookDAO;
import lk.ijse.LibrarySystem.entity.Author;
import lk.ijse.LibrarySystem.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {
    @Override
    public boolean add(Author author) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Book search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Book entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Book> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
