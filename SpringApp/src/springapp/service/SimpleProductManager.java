package springapp.service;

import java.util.List;

import springapp.db.ProductDao;
import springapp.domain.Product;

public class SimpleProductManager implements ProductManager 
{
	
	//private List<Product> products;
	private ProductDao productDao;

	@Override
	public void increasePrice(int percentage) 
	{
		List<Product> products = getProducts();
		 if (products != null) 
		 {
	            for (Product product : products) 
	            {
	                double newPrice = product.getPrice().doubleValue() * 
	                                    (100 + percentage)/100;
	                product.setPrice(newPrice);
	                productDao.saveProduct(product);
	            }
	        }

	}

	@Override
	public List<Product> getProducts() 
	{
		//return products;
		return productDao.getProductList();
	}
	
/*    public void setProducts(List<Product> products) 
    {
        this.products = products;
    }*/
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
