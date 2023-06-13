package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.AuthorDAO;
import entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorDAOimpl implements AuthorDAO {


    @Override
    public boolean add(Author author) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO author(authorId, Name, bookName) VALUES(?, ?, ?)";

        return SQLUtil.execute(sql ,
                author.getAuthorId() ,
                author.getName() ,
                author.getBookName()
        );

    }

    @Override
    public Author search(String searchId) throws SQLException, ClassNotFoundException {
        String sql = "select * from author where authorId=?";

        ResultSet rs = SQLUtil.execute(sql , searchId );

        if(rs.next()) {
            Author author = new Author();
            author.setAuthorId(rs.getString(1));
            author.setName(rs.getString(2));
            author.setBookName(rs.getString(3));

            return author;
        }
        return null;

    }

    @Override
    public boolean delete(String searchId) throws SQLException, ClassNotFoundException {
        String sql = "delete from author where authorId = ?";

        return SQLUtil.execute(sql , searchId );

    }

    @Override
    public boolean update(Author author) throws SQLException, ClassNotFoundException {
        String sql = "update author set name=?,bookName=? where AuthorId=?";

        return SQLUtil.execute(sql ,
                author.getAuthorId() ,
                author.getName() ,
                author.getBookName()
        );

    }

    @Override
    public ArrayList<String> loadAllAuthorIds() throws SQLException, ClassNotFoundException {
        String sql = "select  AuthorId from author";

        ResultSet rs = SQLUtil.execute(sql);

        ArrayList <String> authorIds = new ArrayList();

        while (rs.next()) {
            authorIds.add(rs.getString(1));
        }
        return authorIds;

    }

    @Override
    public ArrayList<Author> loadAllAuthors() throws SQLException, ClassNotFoundException {
        String sql = "select * from author";

        ResultSet rs = SQLUtil.execute(sql);

        ArrayList<Author> authors = new ArrayList<>();

        while(rs.next()) {
            Author author = new Author();

            author.setAuthorId(rs.getString(1));
            author.setName(rs.getString(2));
            author.setBookName(rs.getString(3));

            authors.add(author);
        }
        return authors;
    }

    @Override
    public String genarateTurnId() throws SQLException, ClassNotFoundException {
        String sql = ("SELECT authorId FROM author ORDER BY authorId DESC LIMIT 1 ");

        ResultSet rs = SQLUtil.execute(sql);


        if (rs.next()){
            String lastMemberId = rs.getString(1);

            String[] temp = lastMemberId.split("A");

            int value = Integer.parseInt((temp[1]));
            String nextValue = (value+1) + "";

            if (nextValue.length() == 1 ){
                return "A00"+ nextValue;
            }else if (nextValue.length() == 2 ){
                return "A0" + nextValue;
            }else {
                return "A";
            }


        }
        return  "A001";


    }
}
