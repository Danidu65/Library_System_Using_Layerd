package dao.custom;

import dao.CrudDAO;
import entity.Author;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AuthorDAO extends CrudDAO<Author , String> {
    public ArrayList<String> loadAllAuthorIds() throws SQLException, ClassNotFoundException;
    public ArrayList<Author> loadAllAuthors() throws SQLException, ClassNotFoundException;
    public String genarateTurnId() throws SQLException, ClassNotFoundException;


}
