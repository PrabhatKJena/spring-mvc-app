package in.consultit.controller;

import in.consultit.handler.Handler;
import in.consultit.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

	@Autowired
	Handler productHandler;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView printWelcome(ModelMap model) {
		ModelAndView view = new ModelAndView("home");
		view.addObject("product", new Product());
		return view;
	}

	/*@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		model.addObject("message", "Hello,  "+name);

		return model;

	}*/

	@RequestMapping(value = "/findProduct", method = RequestMethod.POST)
	public ModelAndView findProduct(@ModelAttribute("product")Product product){
		ModelAndView view = new ModelAndView("home");
		List<Product> products = productHandler.doHandle(product);
		view.addObject("productList",products);
		return view;
	}
}