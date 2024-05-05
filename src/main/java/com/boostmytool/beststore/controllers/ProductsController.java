package com.boostmytool.beststore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boostmytool.beststore.models.Product;
import com.boostmytool.beststore.models.ProductDto;
import com.boostmytool.beststore.services.ProductRepository;

@Controller
@RequestMapping("/products")
public class ProductsController {
	@Autowired 
	private ProductRepository repo;
	
	@GetMapping({"","/"})
	public String showProductList(Model model) {
		List<Product> products=repo.findAll(Sort.by(Sort.Direction.ASC,"id"));
		model.addAttribute("products",products);
		return "products/index";
	}
	
	@GetMapping("/create")
	public String showCreatePage(Model model) {
		ProductDto productDto=new ProductDto();
		model.addAttribute("productDto", productDto);
		return "products/CreateProduct";

	}
}
