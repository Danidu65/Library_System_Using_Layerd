package bo.custom;

import dto.AuthorDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AuthorBO {

    ArrayList<AuthorDTO> getAllAuthors() throws SQLException, ClassNotFoundException;

    String generateAuthorID() throws SQLException, ClassNotFoundException;

    boolean updateAuthor(AuthorDTO dto) throws SQLException, ClassNotFoundException;

    boolean addAuthor(AuthorDTO dto) throws SQLException, ClassNotFoundException;

    AuthorDTO searchAuthor(String id) throws SQLException, ClassNotFoundException;

    boolean deleteAuthor(String id) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllAuthorIds() throws SQLException, ClassNotFoundException;
}
