package springapp.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import springapp.domain.Product;

public class JdbcProductDao extends JdbcDaoSupport implements ProductDao {

	@Override
	public List<Product> getProductList() 
	{
        List<Product> products = getJdbcTemplate().query(
                "select id, description, price from products", 
                new ProductMapper());
        return products;
	}

	@Override
	public void saveProduct(Product prod) 
	{
        int count = getJdbcTemplate().update(
                "update products set price = ? where id = ?",
                prod.getPrice(),prod.getId());

	}

	
    private static class ProductMapper implements RowMapper<Product> {

        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product prod = new Product();
            prod.setId(rs.getInt("id"));
            prod.setDescription(rs.getString("description"));
            prod.setPrice(new Double(rs.getDouble("price")));
            return prod;
        }

    }
}
