package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;

public interface OrderDetailsDAO extends CrudDAO<OrderDetailDTO , String> , SuperDAO {
}
