package lk.ijse.LibrarySystem.bo.custom.impl;

import lk.ijse.LibrarySystem.bo.custom.AutorBO;
import lk.ijse.LibrarySystem.dao.DAOFactory;
import lk.ijse.LibrarySystem.dao.custom.impl.AuthorDAOImpl;
import lk.ijse.LibrarySystem.dto.AuthorDTO;
import lk.ijse.LibrarySystem.entity.Author;

import java.sql.SQLException;
import java.util.ArrayList;

public class AutorBOImpl implements AutorBO {
    AuthorDAOImpl autorDAO = (AuthorDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.AUTOR);

    @Override
    public boolean autorAdd(AuthorDTO dto) throws SQLException, ClassNotFoundException {
        return autorDAO.add(new Author(dto.getId() , dto.getName() , dto.getBookName()) );
    }
    @Override
    public AuthorDTO autorsearchFrom(String id) throws SQLException, ClassNotFoundException {
        Author author = autorDAO.search(id);
        return new AuthorDTO(author.getId(),author.getName(),author.getBookName());
    }

    @Override
    public boolean autorDelete(String id) throws SQLException, ClassNotFoundException {
        return autorDAO.delete(id);
    }

    @Override
    public boolean autorUpdate(AuthorDTO Author) throws SQLException, ClassNotFoundException {
        return autorDAO.update(new Author(Author.getName(),Author.getBookName(),Author.getId()));
    }

    @Override
    public String autorGenarateTurnId() throws SQLException, ClassNotFoundException {
        return autorDAO.generateNewID();
    }

    @Override
    public ArrayList<String> loadAllAutorIds() throws SQLException, ClassNotFoundException {
        return autorDAO.loadAllIds();
    }

    @Override
    public ArrayList<AuthorDTO> loadAllAutors() throws SQLException, ClassNotFoundException {
        ArrayList<AuthorDTO> allAuthors = new ArrayList<>();

        for (Author a : autorDAO.loadAll()){
            allAuthors.add(new AuthorDTO(a.getId(),a.getName(),a.getBookName()));
        }
        return allAuthors;
    }
}
