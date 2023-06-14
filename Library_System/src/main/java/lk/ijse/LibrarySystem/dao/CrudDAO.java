package lk.ijse.LibrarySystem.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> {
    public boolean add(T entity) throws SQLException, ClassNotFoundException;
    public T search(String id) throws SQLException, ClassNotFoundException;
    public boolean update(T entity) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadAllIds() throws SQLException;
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    public String generateNewID() throws SQLException, ClassNotFoundException;
}
