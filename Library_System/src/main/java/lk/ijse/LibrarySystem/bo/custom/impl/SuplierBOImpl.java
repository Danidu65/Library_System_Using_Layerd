package lk.ijse.LibrarySystem.bo.custom.impl;

import lk.ijse.LibrarySystem.bo.custom.SuplierBO;
import lk.ijse.LibrarySystem.dao.custom.impl.SuplierDAOImpl;
import lk.ijse.LibrarySystem.dto.SuplierDTO;
import lk.ijse.LibrarySystem.entity.Suplier;

import java.sql.SQLException;
import java.util.ArrayList;

public class SuplierBOImpl implements SuplierBO {
    SuplierDAOImpl supplierDAO = new SuplierDAOImpl();

    @Override
    public boolean supplierAdd(SuplierDTO supplier) throws SQLException, ClassNotFoundException {
      return supplierDAO.add(new Suplier(supplier.getId(),supplier.getName(),supplier.getContact(),supplier.getAddress(),supplier.getSuplierBooks()));
    }

    @Override
    public SuplierDTO supplierSearchFrom(String id) throws SQLException, ClassNotFoundException {
       Suplier suplier = supplierDAO.search(id);
       return new SuplierDTO(suplier.getId(),suplier.getName(),suplier.getContact(),suplier.getAddress(),suplier.getSuplierBooks());
    }

    @Override
    public boolean supplierDelete(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(id);
    }

    @Override
    public boolean supplierUpdate(SuplierDTO supplier) throws SQLException, ClassNotFoundException {
        supplierDAO.update(new Suplier(supplier.getName(),supplier.getContact(),supplier.getAddress(),supplier.getSuplierBooks(),supplier.getId()));
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
        for (Suplier s : supplierDAO.loadAll()) {
            allSuppliers.add(new SuplierDTO(s.getId(),s.getName(),s.getContact(),s.getAddress(),s.getSuplierBooks()));
        }
        return allSuppliers;
    }
}
