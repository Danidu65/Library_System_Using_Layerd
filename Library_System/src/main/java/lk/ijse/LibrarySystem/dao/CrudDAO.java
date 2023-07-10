package lk.ijse.LibrarySystem.dao;
import lk.ijse.LibrarySystem.bo.SuperBO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {
    public boolean add(T dto) throws SQLException, ClassNotFoundException;
    public Boolean update(T dto) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public static T search(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadAllIds() throws SQLException;
    public String generateNewID() throws SQLException, ClassNotFoundException;
    public ArrayList<T> loadAll() throws SQLException, ClassNotFoundException;
}
