package dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO <T , ID > extends SuperDAO{
    public boolean add(T dto) throws SQLException, ClassNotFoundException;
    public T search(ID newValue) throws SQLException, ClassNotFoundException;
    public boolean delete(ID id) throws SQLException, ClassNotFoundException;
    public boolean update(T dto) throws SQLException, ClassNotFoundException;
}
