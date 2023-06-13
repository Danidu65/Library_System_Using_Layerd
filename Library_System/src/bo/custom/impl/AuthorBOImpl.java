package bo.custom.impl;

import bo.custom.AuthorBO;
import dao.DAOFactory;
import dao.custom.AuthorDAO;
import dto.AuthorDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorBOImpl implements AuthorBO {

    AuthorDAO authorDAO = (AuthorDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.AUTHOR);

    @Override
    public ArrayList<AuthorDTO> getAllAuthors() throws SQLException, ClassNotFoundException {
        ArrayList<AuthorDTO> allCustomers= new ArrayList<>();
        ArrayList<Author> all = authorDAO.getAll();
        for (Author c : all) {
            allCustomers.add(new AuthorDTO(c.get(),c.getName(),c.getAddress()));
        }
        return allCustomers;
    }

    @Override
    public boolean addAuthor(AuthorDTO dto) throws SQLException, ClassNotFoundException {
        return AuthorDAO.add(new Author(dto.getId(), dto.getName(), dto.getAddress()));
    }

    @Override
    public boolean updateAuthor(AuthorDTO dto) throws SQLException, ClassNotFoundException {
        return authorDAO.update(new Author(dto.getId(),dto.getName(),dto.getAddress()));
    }

    @Override
    public boolean searchAuthor(String id) throws SQLException, ClassNotFoundException {
        return authorDAO.search(id);
    }

    @Override
    public boolean deleteAuthor(String id) throws SQLException, ClassNotFoundException {
        return authorDAO.delete(id);
    }

    @Override
    public String generateNewAuthorID() throws SQLException, ClassNotFoundException {
        return authorDAO.generateNewID();
    }
}
