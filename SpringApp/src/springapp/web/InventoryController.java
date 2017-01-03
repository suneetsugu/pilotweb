package springapp.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springapp.db.BusScheduleDao;
import springapp.domain.BusSchedule;
import springapp.domain.Product;
import springapp.service.ProductManager;

@RestController
public class InventoryController
{
/*	private ProductManager productManager;
	
	
	@Resource(name="productManager")
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}*/
	
	private BusScheduleDao busDao;
	
	@Autowired(required=true)
	@Qualifier(value="busDao")
	public void setBusDao(BusScheduleDao busDao) {
		this.busDao = busDao;
	}  

/*   @RequestMapping(method = RequestMethod.GET)
   public String printHello(ModelMap model) 
   {
      model.addAttribute("now", new Date().toString());
      model.addAttribute("products", this.productManager.getProducts());
      return "hello";
   }*/
	
/*	@RequestMapping(value = "/index", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public List<Product> getProducts() {  
	  List<Product> listOfProducts = this.productManager.getProducts();
	  return listOfProducts;  
	 }*/

	@RequestMapping(value = "/buslist/{origin}/{destination}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<BusSchedule> getBusbySearch(@PathVariable("origin") String origin, @PathVariable("destination") String destination) 
	{
		  List<BusSchedule> listOfBus = this.busDao.getBusListBySearch(origin,destination);
		  return listOfBus;
	}
}
