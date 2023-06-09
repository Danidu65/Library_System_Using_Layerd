package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;

public interface OrderDAO extends CrudDAO<OrderDTO , String> , SuperDAO {
}
