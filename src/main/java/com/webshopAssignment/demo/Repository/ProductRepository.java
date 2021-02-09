package com.webshopAssignment.demo.Repository;

import com.webshopAssignment.demo.Model.Product;
import com.webshopAssignment.demo.data.database.DBManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ICrudRepository<Product>{

    @Autowired
    JdbcTemplate template;

    @Override
    public void create(Product product){
        String SQL = "INSERT INTO `Webshop`.`Product` (`name`, `price`) VALUES (?, ?);";
        template.update(SQL, product.getName(), product.getPrice());
    }

    @Override
    public List<Product> readAll(){
        String sql = "SELECT * FROM Webshop.Product;";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public Product read(long id){
        String sql = "SELECT * FROM Webshop.Product WHERE id =?;";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    @Override
    public void update(Product product){
        String sql = "UPDATE Webshop.Product SET name = ?, price = ? WHERE id = ?";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        template.update(sql, product.getName(), product.getPrice(), product.getId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM Webshop.Product WHERE id = ?";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        template.update(sql, id);
    }

    /*
    @Override
    public void create(Product product) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO `Webshop`.`Product` (`Product_Name`, `Product_Price`) VALUES (?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.executeUpdate();


        } catch (SQLIntegrityConstraintViolationException dupEntry){
            System.out.println("Duplicate entry");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

     */


/*
    @Override
    public List<Product> readAll() {
        List<Product> productList = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM Webshop.Product;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int productId = rs.getInt("Product_Id");
                String productName = rs.getString("Product_Name");
                double productPrice = rs.getDouble("Product_Price");
                Product product = new Product(productId, productName, productPrice);
                productList.add(product);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productList;
    }

 */



/*
    @Override
    public Product read(long id) {
        //find element med id
        Product product = new Product();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM Webshop.Product WHERE Product_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int productId = rs.getInt("Product_Id");
                String productName = rs.getString("Product_Name");
                double productPrice = rs.getDouble("Product_Price");
                product.setId((long) productId);
                product.setName(productName);
                product.setPrice(productPrice);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }

 */

/*
    @Override
    public boolean update(Product product) {
        int updateResult = 0;
        try {
            Connection con = DBManager.getConnection();
            String SQL = "UPDATE Webshop.Product SET Product_Name = ?, Product_Price = ? WHERE Product_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setLong(3, product.getId());
            updateResult = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        boolean updateOK = false;

        if (updateResult > 0){
            updateOK = true;
        }
        return updateOK;
    }

 */



/*
    @Override
    public boolean delete(long id) {
        int deleteResult = 0;

        try {
            Connection con = DBManager.getConnection();
            String SQL = "DELETE FROM Webshop.Product WHERE Product_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setLong(1, id);
            deleteResult = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        boolean deleteOK = false;

        if (deleteResult > 0){
            deleteOK = true;
        }
        return deleteOK;
    }

 */
}


