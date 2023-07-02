package lk.ijse.LibrarySystem.bo.custom.impl;

import lk.ijse.LibrarySystem.bo.custom.ExibitionBO;
import lk.ijse.LibrarySystem.dto.ExibitionDTO;
import lk.ijse.LibrarySystem.entity.Exibition;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExibitionBOImpl implements ExibitionBO {
    @Override
    public boolean exibitionAdd(ExibitionDTO exibition) throws SQLException, ClassNotFoundException {
        return false;
    }
    @Override
    public Exibition exibitionsearchFrom(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exibitionDelete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exibitionUpdate(ExibitionDTO exibition) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String exibitionGenarateTurnId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ExibitionDTO> loadAllExibitionIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ExibitionDTO> loadAllExibition() throws SQLException, ClassNotFoundException {
        return null;
    }
}
