package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;

public interface ItemDAO extends CrudDAO<ItemDTO , String>  , SuperDAO {
}
