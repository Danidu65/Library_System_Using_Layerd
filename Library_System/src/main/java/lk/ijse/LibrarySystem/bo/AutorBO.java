package lk.ijse.LibrarySystem.bo;

import lk.ijse.LibrarySystem.dto.AuthorDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AutorBO {
    public boolean autorAdd(AuthorDTO Aotor) throws SQLException, ClassNotFoundException;
    public AuthorDTO autorsearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean autorDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean autorUpdate(AuthorDTO Aotor) throws SQLException, ClassNotFoundException;
    public String autorGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadAllAutorIds() throws SQLException, ClassNotFoundException;
    public ArrayList<AuthorDTO> loadAllAutors() throws SQLException, ClassNotFoundException;
}
