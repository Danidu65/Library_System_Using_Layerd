package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;

public interface CustomerDAO extends CrudDAO<CustomerDTO , String> , SuperDAO {
}
