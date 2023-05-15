package app;

import app.Record.ProductRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProductDao {
    private Connection con;

    public ProductDao(Connection con) {
        this.con = con;
    }

    public ArrayList<ProductRecord> findById(int i) throws SQLException {
        final var SQL = "SELECT id, name, price FROM users ORDER BY id";

        var ProductRecord = new ArrayList<ProductRecord>();

        try (PreparedStatement stmt = this.con.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                var user = new ProductRecord(rs.getInt("id"), rs.getString("name"), rs.getString("price"));
                ProductRecord.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ProductRecord;
    }

    public
}

