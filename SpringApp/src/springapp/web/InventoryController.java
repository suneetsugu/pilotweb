package springapp.web;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springapp.service.ProductManager;

@Controller
@RequestMapping("/hello")
public class InventoryController
{
	private ProductManager productManager;
	
	@Resource(name="productManager")
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
   @RequestMapping(method = RequestMethod.GET)
   public String printHello(ModelMap model) 
   {
      model.addAttribute("now", new Date().toString());
      model.addAttribute("products", this.productManager.getProducts());
      return "hello";
   }

}
