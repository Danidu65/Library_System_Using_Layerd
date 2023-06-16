package lk.ijse.LibrarySystem.bo.custom.impl;

import lk.ijse.LibrarySystem.bo.custom.SuplierBO;
import lk.ijse.LibrarySystem.dao.custom.impl.SuplierDAOImpl;
import lk.ijse.LibrarySystem.dto.SuplierDTO;
import lk.ijse.LibrarySystem.entity.Suplier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Supplier;

public class SuplierBOImpl implements SuplierBO {
    SuplierDAOImpl supplierDAO = new SuplierDAOImpl();

    @Override
    public boolean supplierAdd(SuplierDTO supplier) throws SQLException, ClassNotFoundException {
        supplierDAO.add(new Supplier(supplier.getId(),supplier.getName(),
                supplier.getContact(), supplier.getAddress(),supplier.getSuplierBooks()));
        return false;
    }

    @Override
    public Supplier supplierSearchFrom(String id) throws SQLException, ClassNotFoundException {
        return (Supplier) supplierDAO.search(id);

    }

    @Override
    public boolean supplierDelete(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(id);
    }

    @Override
    public boolean supplierUpdate(SuplierDTO supplier) throws SQLException, ClassNotFoundException {
        supplierDAO.update(new Supplier(supplier.getId(),supplier.getName(),
                supplier.getContact(), supplier.getAddress(),supplier.getSuplierBooks()));
        return false;
    }

    @Override
    public String supplierGenarateTurnId() throws SQLException, ClassNotFoundException {
        return supplierDAO.generateNewID();
    }

    @Override
    public ArrayList<String> loadAllSupplierIds() throws SQLException, ClassNotFoundException {
        return supplierDAO.loadAllIds();
    }

    @Override
    public ArrayList<SuplierDTO> loadAllSupplier() throws SQLException, ClassNotFoundException {
        ArrayList<SuplierDTO> allSuppliers = new ArrayList<>();
        ArrayList<Suplier> all = new SuplierDAOImpl().loadAll();
        for (Suplier b :  all) {
            allSuppliers.add(new SuplierDTO());
        }
        return allSuppliers;
    }
}
