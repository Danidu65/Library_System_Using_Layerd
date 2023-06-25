package lk.ijse.LibrarySystem.bo.custom;

import lk.ijse.LibrarySystem.bo.SuperBO;
import lk.ijse.LibrarySystem.dto.AuthorDTO;

import java.sql.SQLException;
import java.util.ArrayList;
public interface AutorBO extends SuperBO{
    public boolean autorAdd(AuthorDTO Aotor) throws SQLException, ClassNotFoundException;
    public AuthorDTO autorsearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean autorDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean autorUpdate(AuthorDTO Aotor) throws SQLException, ClassNotFoundException;
    public String autorGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadAllAutorIds() throws SQLException, ClassNotFoundException;
    public ArrayList<AuthorDTO> loadAllAutors() throws SQLException, ClassNotFoundException;
}
