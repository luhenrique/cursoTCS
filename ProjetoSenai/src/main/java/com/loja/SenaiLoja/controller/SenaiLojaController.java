package com.loja.SenaiLoja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loja.SenaiLoja.dao.SenaiLojaDao;
import com.loja.SenaiLoja.model.Product;
import org.springframework.ui.Model;

	@Controller
	public class SenaiLojaController {
		
		@Autowired
		private SenaiLojaDao service; 
		
		@RequestMapping("/")
		public String viewHomePage(Model model) {
			List<Product> listProducts = service.listAll();
			model.addAttribute("listProducts", listProducts);
			
			return "index";
		}
		
		@RequestMapping("/new")
		public String showNewProductPage(Model model) {
			Product product = new Product();
			model.addAttribute("product", product);
			
			return "new";
		}
		
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String saveProduct(Product product) {
			service.save(product);
			
			return "redirect:/"; // tem que deixar explicito que vai redirecionar para o barra 
		}
		
		@RequestMapping("/edit/{id}")
		public ModelAndView showEditProductPage(@PathVariable(name = "id") long id) {
			ModelAndView mav = new ModelAndView("edit");
			Product product = service.get(id);
			mav.addObject("product", product);
			
			return mav; //faz o redirecionamento automatico para o /
		}
		
		@RequestMapping("/delete/{id}")
		public String deleteProduct(@PathVariable(name = "id") long id) {
			service.delete(id);
			return "redirect:/";		
		}
	}
