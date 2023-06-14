package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.SQLUtil;
import lk.ijse.LibrarySystem.dao.custom.AutorDAO;
import lk.ijse.LibrarySystem.db.DBConnection;
import lk.ijse.LibrarySystem.dto.AuthorDTO;
import lk.ijse.LibrarySystem.entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorDAOImpl implements AutorDAO {

    @Override
    public boolean add(Author author) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Customer (AuthorId,name, bookName) VALUES (?,?,?)" , author.getId(),author.getName(),author.getBookName());
    }

    @Override
    public Author search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst =  SQLUtil.execute("select * from author where authorId=?",id);

        if(rst.next()){

            return new Author(rst.getString(1) ,
                    rst.getString(2) ,
                    rst.getString(3) ,
                    rst.getString(4)
                );
        }
        return null;
    }

    @Override
    public boolean update(Author author) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("update author set name=?,bookName=? where AuthorId=?", author.getId(),author.getName(),author.getBookName());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("delete from author where authorId = ?", id);
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select  authorId from Author";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<String> AuthorIds = new ArrayList<>();

        while (result.next()) {
            AuthorIds.add(result.getString(1));
        }
        return AuthorIds;
    }

    @Override
    public ArrayList<Author> getAll() throws SQLException, ClassNotFoundException {
        ArrayList <Author> allAuthors = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("select * from author");
        while (rst.next()){
            Author autor = new Author(rst.getString("AuthorId"),rst.getString("name"),rst.getString("bookName"));
            allAuthors.add(autor);
        }
        return allAuthors;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT authorId FROM author ORDER BY authorId DESC LIMIT 1");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("A00-", "")) + 1;
            return String.format("A00-%03d", newCustomerId);
        } else {
            return "A00-001";
        }
    }
}
