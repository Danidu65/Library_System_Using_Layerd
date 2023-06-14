package lk.ijse.LibrarySystem.dao;

import lk.ijse.LibrarySystem.entity.Author;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> {
    public boolean add(Author author) throws SQLException, ClassNotFoundException;
    public T search(String id) throws SQLException, ClassNotFoundException;
    public boolean update(T entity) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadAllIds() throws SQLException, ClassNotFoundException;
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    public String generateNewID() throws SQLException, ClassNotFoundException;
}
