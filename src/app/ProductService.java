package app;
import app.ProductDao;
import app.ProductRecord;
import app.DbUtil;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    //ID
    public List<ProductRecord> findId(int id) {
        try(var connection = DbUtil.getConnection();) {
            var productDao = new ProductDao(connection);
            return productDao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    //NAME
    public List<ProductRecord> findName(String name) {
        try(var connection = DbUtil.getConnection();) {
            var productDao = new ProductDao(connection);
            return productDao.findByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    //インサート
    public int insert(ProductRecord p) {
        try(var connection = DbUtil.getConnection();) {
            var productDao = new ProductDao(connection);
            return productDao.insert(p);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //アップデート
    public int update(ProductRecord p) {
        try(var connection = DbUtil.getConnection();) {
            var productDao = new ProductDao(connection);
            return productDao.update(p);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //デリート
    public int delete(int p) {
        try(var connection = DbUtil.getConnection();) {
            var productDao = new ProductDao(connection);
            return productDao.delete(p);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
