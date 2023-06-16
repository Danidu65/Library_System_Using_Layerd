package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.SQLUtil;
import lk.ijse.LibrarySystem.dao.custom.AutorDAO;
import lk.ijse.LibrarySystem.db.DBConnection;
import lk.ijse.LibrarySystem.dto.PublisherDTO;
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
    public Boolean update(Author author) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("update author set name=?,bookName=? where AuthorId=?", author.getId(),
                author.getName(),
                author.getBookName()
        );
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("delete from autor where AutorId =?",id);
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
    public ArrayList<String> loadAllIds() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select  AutorId from Autor";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<String> AutorIds = new ArrayList<>();

        while (result.next()) {
            AutorIds.add(result.getString(1));
        }
        return AutorIds;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst =  SQLUtil.execute("SELECT autorId FROM autor ORDER BY autorId DESC LIMIT 1");
        if (rst.next()){
            String id = rst.getString("id");
            int newAutorId = Integer.parseInt(id.replace("A00-", "")) + 1;
            return String.format("A00-%03d", newAutorId);
        } else {
            return "A001";
        }
    }

    @Override
    public ArrayList<PublisherDTO> loadAll() throws SQLException, ClassNotFoundException {
        ArrayList<Author> allItems = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
        while (rst.next()) {
            allItems.add(new Author(rst.getString("AutorID"), rst.getString("AutorName"),
                    rst.getString("BookName"),rst.getString("BookID")));
        }
        return allItems;
    }
}