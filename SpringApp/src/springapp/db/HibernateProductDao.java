package springapp.db;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;

import springapp.domain.Product;

public class HibernateProductDao implements ProductDao 
{

	private HibernateTemplate hibernateTemplate;
	
	public void setSessionFactory(SessionFactory sessionFactory) 
    {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		this.hibernateTemplate.setCheckWriteOperations(false);
	}
	
	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return hibernateTemplate.loadAll(Product.class);
	}

	@Override
	public void saveProduct(Product prod) {
		hibernateTemplate.saveOrUpdate(prod);

	}

}
