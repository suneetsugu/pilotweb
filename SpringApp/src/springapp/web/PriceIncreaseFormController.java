package springapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;


import springapp.service.ProductManager;
import springapp.service.PriceIncrease;
import springapp.service.PriceIncreaseValidator;

@Controller
@RequestMapping("/priceincrease")
public class PriceIncreaseFormController
{


    private ProductManager productManager;
    PriceIncreaseValidator priceIncreaseValidator;
    
    @Autowired
    public PriceIncreaseFormController(PriceIncreaseValidator priceIncreaseValidator) 
    {
		this.priceIncreaseValidator=priceIncreaseValidator;
	}

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("priceIncrease") PriceIncrease priceIncrease,
    		BindingResult result, SessionStatus status, ModelMap model)
            throws ServletException {

        int increase = priceIncrease.getPercentage();

        priceIncreaseValidator.validate(priceIncrease, result);
        
        if(result.hasErrors())
        	return "priceincrease";

        
        productManager.increasePrice(increase);

        status.setComplete();

        model.addAttribute("now", new Date().toString());
        model.addAttribute("products", this.productManager.getProducts());
        
        return "hello";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected String initForm(ModelMap model) 
    {
        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(20);
        model.addAttribute("priceIncrease", priceIncrease);
        return "priceincrease";
    }

    @Resource(name="productManager")
    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

}