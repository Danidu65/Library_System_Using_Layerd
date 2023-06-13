package bo.custom;

import dto.AuthorDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AuthorBO {
    ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

    ArrayList<CustomerDTO> getAllAuthors() throws SQLException, ClassNotFoundException;

    boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    String generateNewCustomerID() throws SQLException, ClassNotFoundException;

    boolean updateAuthor(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    boolean addAuthor(AuthorDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateAuthor(AuthorDTO dto) throws SQLException, ClassNotFoundException;

    boolean searchAuthor(String id) throws SQLException, ClassNotFoundException;

    boolean deleteAuthor(String id) throws SQLException, ClassNotFoundException;

    String generateNewAuthorID() throws SQLException, ClassNotFoundException;
}
