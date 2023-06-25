package lk.ijse.LibrarySystem.bo.custom;

import lk.ijse.LibrarySystem.bo.SuperBO;
import lk.ijse.LibrarySystem.dto.ExibitionDTO;
import lk.ijse.LibrarySystem.entity.Exibition;

import java.sql.SQLException;
import java.util.ArrayList;
public interface ExibitionBO extends SuperBO {
    public boolean exibitionAdd(ExibitionDTO exibition) throws SQLException, ClassNotFoundException;
    public Exibition exibitionsearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean exibitionDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean exibitionUpdate(ExibitionDTO exibition) throws SQLException, ClassNotFoundException;
    public String exibitionGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<ExibitionDTO> loadAllExibitionIds() throws SQLException, ClassNotFoundException;
    public ArrayList<ExibitionDTO> loadAllExibition() throws SQLException, ClassNotFoundException;
}

