package lk.ijse.LibrarySystem.dao;

import lk.ijse.LibrarySystem.dto.PublisherDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> {
    public boolean add(T dto) throws SQLException, ClassNotFoundException;
    public Boolean update(T dto) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public T search(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadAllIds() throws SQLException;
    public String generateNewID() throws SQLException, ClassNotFoundException;
    public ArrayList<PublisherDTO> loadAll() throws SQLException, ClassNotFoundException;
}
