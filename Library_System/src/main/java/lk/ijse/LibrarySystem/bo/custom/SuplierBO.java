package lk.ijse.LibrarySystem.bo.custom;

import lk.ijse.LibrarySystem.bo.SuperBO;
import lk.ijse.LibrarySystem.dto.SuplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Supplier;
public interface SuplierBO extends SuperBO {
    public boolean supplierAdd(SuplierDTO supplier) throws SQLException, ClassNotFoundException;
    public SuplierDTO supplierSearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean supplierDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean supplierUpdate(SuplierDTO supplier) throws SQLException, ClassNotFoundException;
    public String supplierGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadAllSupplierIds() throws SQLException, ClassNotFoundException;
    public ArrayList<SuplierDTO> loadAllSupplier() throws SQLException, ClassNotFoundException;
}
