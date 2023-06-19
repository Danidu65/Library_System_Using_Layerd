package lk.ijse.LibrarySystem.tm;

import lk.ijse.LibrarySystem.db.DBConnection;
import lk.ijse.LibrarySystem.dto.AuthorDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorModel {
    public static boolean Save(AuthorDTO author) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO author(authorId, Name, bookName) VALUES(?, ?, ?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,author.getId());
        stm.setObject(2,author.getName());
        stm.setObject(3,author.getBookName());

        int result = stm.executeUpdate();
        return result > 0;
    }

    public static AuthorDTO Search(String searchId) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from author where authorId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,searchId);

        ResultSet result = stm.executeQuery();

        if(result.next()) {
            AuthorDTO author = new AuthorDTO();
            author.setId(result.getString(1));
            author.setName(result.getString(2));
            author.setBookName(result.getString(3));

            return author;
        }
        return null;
    }
    public static ArrayList<String> loadAllAuthor() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select  AuthorId from author";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList <String> authorIds = new ArrayList();

        while (result.next()) {
            authorIds.add(result.getString(1));
//            Author author = new Author();
//            author.setId(result.getString(1));
//            author.setName(result.getString(2));
        }
        return authorIds;
    }

    public static boolean delete(String searchId) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "delete from author where authorId = ?";

        PreparedStatement stm = con.prepareStatement(sql);
        stm.setObject(1,searchId);
        int result = stm.executeUpdate();

        return false;
    }

    public static ArrayList<AuthorDTO> LoadAllAuthors() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from author";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<AuthorDTO> authors = new ArrayList<>();

        while(result.next()) {
            AuthorDTO author = new AuthorDTO();

            author.setId(result.getString(1));
            author.setName(result.getString(2));
            author.setBookName(result.getString(3));

            authors.add(author);
        }
        return authors;
    }

    public static Boolean Update(AuthorDTO author) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "update author set name=?,bookName=? where AuthorId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, author.getName());
        stm.setObject(2, author.getBookName());
        stm.setObject(3, author.getId());

        int result = stm.executeUpdate();

        if (result == 1) {
            return true;
        }
        return null;
    }

    public static String genarateTurnId() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT authorId FROM author ORDER BY authorId DESC LIMIT 1 ");

        ResultSet rs = ps.executeQuery();

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
