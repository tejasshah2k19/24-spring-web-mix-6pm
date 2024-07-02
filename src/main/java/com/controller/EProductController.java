package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.EProductBean;
import com.dao.EProductDao;
import com.service.AwsS3Service;
import com.service.FileUploadService;

@Controller
public class EProductController {

	@Autowired
	AwsS3Service s3;

	@Autowired
	EProductDao productDao;

	@Autowired
	FileUploadService fileUploadService; 
	
	
	@GetMapping("/newproduct") // url->browser
	public String newProduct() {// method name
		return "NewProduct";// jsp name
	}

	// int a = 10
	@PostMapping("/saveproduct")
	public String saveProduct(EProductBean productBean, @RequestParam("masterImage") MultipartFile masterImage) {
		// using bean read data ->productBean

		// database -> size -> slow

		// folder -> path -> size++ ->
		// redis

		// cloud -> aws -> s3 ->
		//

		// validation using XX
		
		fileUploadService.uploadProductImage(masterImage);
		productDao.addProduct(productBean);// argument

		return "redirect:/products";// url call

		// return jspname
//		return redirect:/url 

	}

	@GetMapping("/products")
	public String listProducts(Model model) {
		List<EProductBean> products = productDao.getAllProducts();// return type

		model.addAttribute("products", products);

		return "EcomListProducts";
	}

	@GetMapping("/deleteproduct")
	public String deleteProduct(@RequestParam("productId") Integer productId) {

		System.out.println("deleteProduct() => " + productId);

		productDao.deleteProduct(productId);
		return "redirect:/products";// do not open jsp
		// open an url

	}

	// form ->data -> read -> bean

	// hyperlink -> ? -> query string -> @RequestParam("q") datatyep variablename
	// @RequestParam("productId") Integer productId

	@GetMapping("/viewproduct")
	public String viewProduct(@RequestParam("productId") Integer productId, Model model) {

		// id->details->table : products
		// select * from products where productId = ?
		EProductBean productBean = productDao.getProductById(productId);
		model.addAttribute("product", productBean);

		return "ViewProduct";
	}

}
