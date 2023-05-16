package app;

import app.ProductRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private Connection connection;

    public ProductDao(Connection connection) {
        this.connection = connection;
    }

    //ID
    public List<ProductRecord> findById(int id){

        final var SQL = "SELECT id, name, price FROM products Where id =" + id;

        var ProductRecord = new ArrayList<ProductRecord>();

        try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                var product = new ProductRecord(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
                ProductRecord.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (ProductRecord.isEmpty()) {
            return null;
        } else {
            return ProductRecord;
        }
    }

    //NAME
    public List<ProductRecord> findByName(String name){
        final var SQL = "SELECT id, name, price FROM products Where name LIKE '%" + name + "%'";

        var ProductRecord = new ArrayList<ProductRecord>();

        try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                var product = new ProductRecord(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
                ProductRecord.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ProductRecord;
    }

    //インサート
    public int insert(ProductRecord p) {
        final var INSERT_SQL = "INSERT INTO products VALUES (" + p.id() +  ", '" + p.name() + "' ," + p.price() +  ")";
        int result = 0;
        try (PreparedStatement stmt = connection.prepareStatement(INSERT_SQL);) {
            result = stmt.executeUpdate();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //アップデート
    public int update(ProductRecord p) {
        final var UPDATE_SQL = "UPDATE products SET name = '" + p.name() + "', price = " + p.price() + " WHERE id = " + p.id() ;
        int result = 0;
        try (PreparedStatement stmt = connection.prepareStatement(UPDATE_SQL);) {
            result = stmt.executeUpdate();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //デリート
    public int delete(int p) {
        final var DELETE_SQL = "DELETE FROM products WHERE id = " + p;
        int result = 0;
        try (PreparedStatement stmt = connection.prepareStatement(DELETE_SQL);) {
            result = stmt.executeUpdate();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}

