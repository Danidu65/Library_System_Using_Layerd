package lk.ijse.LibrarySystem.bo.custom.impl;

import lk.ijse.LibrarySystem.bo.custom.BookBO;
import lk.ijse.LibrarySystem.dao.DAOFactory;
import lk.ijse.LibrarySystem.dao.custom.impl.BookDAOImpl;
import lk.ijse.LibrarySystem.dto.BookDTO;
import lk.ijse.LibrarySystem.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;
public class BookBOImpl implements BookBO {
    BookDAOImpl bookDAO = (BookDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOK);
    @Override
    public boolean bookAdd(BookDTO book) throws SQLException, ClassNotFoundException {
        return bookDAO.add(new Book(book.getId(),book.getName(),book.getAuthor(),book.getQty(),book.getDiscription()));
    }

    @Override
    public Book booksearchFrom(String id) throws SQLException, ClassNotFoundException {
        Book book = bookDAO.search(id);
        return new Book(book.getId(),book.getName(),book.getAuthor(),book.getQty(),book.getDiscription());
    }

    @Override
    public boolean bookDelete(String id) throws SQLException, ClassNotFoundException {
        return bookDAO.delete(id);
    }

    @Override
    public boolean bookUpdate(BookDTO book) throws SQLException, ClassNotFoundException {
        bookDAO.update(new Book(book.getId(),book.getName(),book.getAuthor(),book.getQty(),book.getDiscription()));
        return false;
    }

    @Override
    public String bookGenarateTurnId() throws SQLException, ClassNotFoundException {
        return bookDAO.generateNewID();
    }

    @Override
    public ArrayList<String> loadAllBookIds() throws SQLException, ClassNotFoundException {
        return bookDAO.loadAllIds();
    }

    @Override
    public ArrayList<BookDTO> loadAllBooks() throws SQLException, ClassNotFoundException {
        ArrayList<BookDTO> allBooks = new ArrayList<>();
        for (Book b : bookDAO.loadAll()){
            allBooks.add(new Book(b.getId(),b.getName(),b.getAuthor(),b.getDiscription(),b.getQty()));
        }
        return allBooks;
    }
}
