package lk.ijse.LibrarySystem.bo.impl;

import lk.ijse.LibrarySystem.bo.AutorBO;
import lk.ijse.LibrarySystem.dao.custom.impl.AutorDAOImpl;
import lk.ijse.LibrarySystem.dto.AuthorDTO;
import lk.ijse.LibrarySystem.entity.Autor;

import java.sql.SQLException;
import java.util.ArrayList;

public class AutorBOImpl implements AutorBO {

    AutorDAOImpl autorDAO = new AutorDAOImpl();

    @Override
    public boolean autorAdd(AuthorDTO dto) throws SQLException, ClassNotFoundException {
       // System.out.println(dto.getId());
        return autorDAO.add(new Autor(dto.getId() , dto.getName() , dto.getBookName()) );

    }

    @Override
    public AuthorDTO autorsearchFrom(String id) throws SQLException, ClassNotFoundException {
        System.out.println();
        return null;
    }

    @Override
    public boolean autorDelete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean autorUpdate(AuthorDTO Aotor) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String autorGenarateTurnId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> loadAllAutorIds() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<AuthorDTO> loadAllAutors() throws SQLException, ClassNotFoundException {
        return null;
    }
}
