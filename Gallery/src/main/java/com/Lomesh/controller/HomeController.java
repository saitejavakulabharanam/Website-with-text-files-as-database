package com.Lomesh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Lomesh.model.Category;
import com.Lomesh.model.Kmessage;
import com.Lomesh.model.Product;


@Controller
public class HomeController {

	
	@ModelAttribute("kmessage")
	public Kmessage returnObject() {
		return new Kmessage();
	}	
	
	@RequestMapping(value = "/")
	public ModelAndView LandingPage(HttpSession session) {

		List<String> trans = new ArrayList<String>();
		ArrayList<Category> categorylist = new ArrayList<Category>();
		ArrayList<Product> productlist = new ArrayList<Product>();
		ArrayList<Product> corlist = new ArrayList<Product>();
		ArrayList<Product> toplist = new ArrayList<Product>();

		
		trans = ProductController.readFile(
				"D:\\Programs\\ImageGallery\\Gallery\\src\\main\\java\\com\\Lomesh\\data\\Productlist.txt");

		productlist = ProductController.listreturn(trans);

		
		for (Product temp : productlist) {
			if (temp.getCorshow().equals("yes")) {
				corlist.add(temp);
			}}

		for (Product temp : productlist) {
			if (temp.getTopshow().equals("yes")) {
				toplist.add(temp);
			}}

		
		
		trans =CategoryController.readFile(
				"D:\\Programs\\ImageGallery\\Gallery\\src\\main\\java\\com\\Lomesh\\data\\Categorylist.txt");
		categorylist = CategoryController.listreturn(trans);
		ModelAndView mv = new ModelAndView("Home");
		session.setAttribute("catline", categorylist);
		session.setAttribute("isAdmin", 0);
		mv.addObject("corlist", corlist);
		mv.addObject("toplist", toplist);
		
		return mv;
	}

	@RequestMapping(value = "/admin")
	public ModelAndView Adminpage(@RequestParam("username") String username, @RequestParam("password") String psw,
			HttpSession session) {
		ModelAndView mv = new ModelAndView("adminpage");

		if (username.equals("sai") && psw.equals("sai")) {
			session.setAttribute("isAdmin", 1);
		} else {
			mv = new ModelAndView("Home");
		}
		return mv;
	}

	@RequestMapping(value = "/adinfo")
	public ModelAndView InfoPage() {
		List<String> trans = new ArrayList<String>();
		trans = CategoryController.readFile("About.txt");

		ModelAndView mv = new ModelAndView("info");
		mv.addObject("aboutList", trans);
		return mv;
	}

	@RequestMapping(value = "/selectcat{name}")
	public ModelAndView CategorySelection(@PathVariable("name") String name) {
		List<String> trans = new ArrayList<String>();
		ArrayList<Product> productlist = new ArrayList<Product>();
		ArrayList<Product> newproductlist = new ArrayList<Product>();

		trans = ProductController.readFile(
				"D:\\Programs\\ImageGallery\\Gallery\\src\\main\\java\\com\\Lomesh\\data\\Productlist.txt");

		productlist = ProductController.listreturn(trans);

		ModelAndView mv = new ModelAndView("cat");

		for (Product temp : productlist) {
			if (name.equals(temp.getCat_Id())) {
				newproductlist.add(temp);
			}}

		mv.addObject("catname", name);
		mv.addObject("productList", newproductlist);
		return mv;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView LogoutPage(HttpSession session) {
		ModelAndView mv = new ModelAndView("Home");
		session.setAttribute("isAdmin", 0);
		List<String> trans = new ArrayList<String>();
		ArrayList<Product> productlist = new ArrayList<Product>();
		ArrayList<Product> corlist = new ArrayList<Product>();
		ArrayList<Product> toplist = new ArrayList<Product>();

		
		trans = ProductController.readFile(
				"D:\\Programs\\ImageGallery\\Gallery\\src\\main\\java\\com\\Lomesh\\data\\Productlist.txt");

		productlist = ProductController.listreturn(trans);

		
		
		
		
		for (Product temp : productlist) {
			if (temp.getCorshow().equals("yes")) {
				corlist.add(temp);
			}}
		

		for (Product temp : productlist) {
			if (temp.getTopshow().equals("yes")) {
				toplist.add(temp);
			}}
		
		
		trans = CategoryController.readFile(
				"D:\\Programs\\ImageGallery\\Gallery\\src\\main\\java\\com\\Lomesh\\data\\Categorylist.txt");

		ArrayList<Category> categorylist = new ArrayList<Category>();
		categorylist = CategoryController.listreturn(trans);
		session.setAttribute("catline", categorylist);
		mv.addObject("corlist", corlist);
		mv.addObject("toplist", toplist);
		return mv;
	}
	
	
	
	@RequestMapping(value = "/oneview{id}")
	public ModelAndView Onepage(@PathVariable("id") String id) {
		
		List<String> trans = new ArrayList<String>();
		ArrayList<Product> productlist = new ArrayList<Product>();
		
		ModelAndView mv = new ModelAndView("1productview");

		
		
		trans = ProductController.readFile(
				"D:\\Programs\\ImageGallery\\Gallery\\src\\main\\java\\com\\Lomesh\\data\\Productlist.txt");

		productlist = ProductController.listreturn(trans);

		for (Product temp : productlist) {
			if (id.equals(temp.getId())) {
				mv.addObject("oneproduct", temp);

			}
		}
		
		return mv;
	}
	
	
	@RequestMapping(value = "/test")
	public ModelAndView Testpage() {
		
		
		//{..\..\..\..\..\webapp\resources\images}
		//{..\..\..\..\..\resources\Categorylist.txt}
	
	
		
		ModelAndView mv = new ModelAndView("test");		
		return mv;
	}

	
	

}
