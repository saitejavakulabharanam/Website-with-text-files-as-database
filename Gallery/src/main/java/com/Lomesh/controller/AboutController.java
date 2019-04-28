package com.Lomesh.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Lomesh.model.Category;

@Controller
public class AboutController {

	public static List<String> readFile(String filename) {
		List<String> records = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				records.add(line);
			}
			reader.close();
			return records;
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	@RequestMapping(value = "/aboutlist")
	public ModelAndView Aboutlist(){

		List<String> trans = new ArrayList<String>();
		trans = readFile(
				"D:\\Programs\\ImageGallery\\Gallery\\src\\main\\java\\com\\Lomesh\\data\\About.txt");


		ModelAndView mv = new ModelAndView("adminpage");
		mv.addObject("listabt", 0);
		mv.addObject("aboutList", trans);
		return mv;
	}
	
	
	@RequestMapping(value = "/Editdetails")
	public ModelAndView Editdetails(){

		List<String> trans = new ArrayList<String>();
		trans = readFile(
				"D:\\Programs\\ImageGallery\\Gallery\\src\\main\\java\\com\\Lomesh\\data\\About.txt");

		String abt="";
		
		int zz=trans.size();
		for(int i=0;i<zz;i++) {
			abt=abt+trans.get(i);
			if(i==zz-1) {
			}
			else {
				abt=abt+"\n";
			}
		}
		
		ModelAndView mv = new ModelAndView("adminpage");
		mv.addObject("add", 2);
		mv.addObject("aboutList", abt);
		return mv;
	}
	
	
	@RequestMapping(value = "/Updatedetails")
	public ModelAndView Updatedetails(@RequestParam("about")String about) throws IOException{

		
		File file = new File(
				"D:\\Programs\\ImageGallery\\Gallery\\src\\main\\java\\com\\Lomesh\\data\\About.txt");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(about);;
		
		writer.close();
		
		
		
		
		List<String> trans = new ArrayList<String>();
		trans = readFile(
				"D:\\Programs\\ImageGallery\\Gallery\\src\\main\\java\\com\\Lomesh\\data\\About.txt");


		ModelAndView mv = new ModelAndView("adminpage");
		mv.addObject("listabt", 0);
		mv.addObject("aboutList", trans);
		return mv;
	}

}
