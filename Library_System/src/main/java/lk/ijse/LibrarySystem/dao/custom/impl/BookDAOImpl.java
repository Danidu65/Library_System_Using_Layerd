package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.CrudDAO;
import lk.ijse.LibrarySystem.dao.SQLUtil;
import lk.ijse.LibrarySystem.dao.custom.BookDAO;
import lk.ijse.LibrarySystem.db.DBConnection;
import lk.ijse.LibrarySystem.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {

    @Override
    public boolean add(Book book) throws SQLException, ClassNotFoundException {
        return  SQLUtil.execute("insert into book values(?,?,?,?,?)",book.getId(),book.getName(),
                book.getAuthor(),book.getQty(),book.getDiscription());    }

    @Override
    public boolean update(Book book) throws SQLException, ClassNotFoundException {
        return  SQLUtil.execute("update book set bookName=?,author_Id=?,qty=?,bookDiscription=? where bookId=?",
                book.getName(), book.getAuthor(),book.getQty(),book.getDiscription(),book.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("delete from book where BookId =?",id);
    }

    @Override
    public Book search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("select * from book where bookId=?",id);

        if (resultSet.next() ){

            return new Book(resultSet.getString(1) ,
                    resultSet.getString(2) ,
                    resultSet.getString(3) ,
                    Integer.parseInt(resultSet.getString(4)),
                    resultSet.getString(5));
        }
        return null;
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select bookId from book";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<String> BookIds = new ArrayList<>();

        while (result.next()) {
            BookIds.add(result.getString(1));
        }
        return BookIds;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT bookId FROM book ORDER BY bookId DESC LIMIT 1 ");

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            String lastBookId = rs.getString(1);

            String[] temp = lastBookId.split("B");

            int value = Integer.parseInt((temp[1]));
            String nextValue = (value+1) + "";

            if (nextValue.length() == 1 ){
                return "B00"+ nextValue;
            }else if (nextValue.length() == 2 ){
                return "B0" + nextValue;
            }else {
                return "B";
            }
        }
        return "B001";
    }

    @Override
    public ArrayList<Book> loadAll() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from book";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<Book> books = new ArrayList<>();

        while (result.next()) {
            Book book = new Book();
            book.setId(result.getString(1));
            book.setName(result.getString(2));
            book.setAuthor(result.getString(3));
            book.setQty(Integer.parseInt(result.getString(4)));
            book.setDiscription(result.getString(5));

            books.add(book);
        }

        return books;
        }
    }
