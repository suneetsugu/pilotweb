package springapp.db;

import java.util.List;

import springapp.domain.Product;

public interface ProductDao 
{
    public List<Product> getProductList();

    public void saveProduct(Product prod);
}
