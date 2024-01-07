package com.alamincsme.springboot.controllers;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alamincsme.springboot.Programmer;
import com.alamincsme.springboot.Repository.ProgrammerRepo;


// all example are learning purpose.


@Controller
public class AppController {
	
	@Autowired
	ProgrammerRepo programmerRepo ;
	
	@RequestMapping("/home")
	@GetMapping("/home")
	public String homePage() {
		return "home.html";
	}
	//section 12 .
//	@RequestMapping("addProgrammer")
//	public String addProgrammer(@RequestParam int pId, @RequestParam String pName, @RequestParam String pLan, Model model) {
//		model.addAttribute("pId", pId);
//		model.addAttribute("pName", pName);
//		model.addAttribute("pLan", pLan);
//		System.out.println(pId + " " + pName + " " + pLan);
//		return "programmer.html" ;
//	}
	
	
	//section 13.
//	@RequestMapping("addProgrammer")
//	public ModelAndView addProgrammer(@RequestParam int pId, @RequestParam String pName, @RequestParam String pLan) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("programmer.html");
//        mv.addObject("pId", pId);
//        mv.addObject("pName", pName);
//        mv.addObject("pLan", pLan);
//		System.out.println(pId + " " + pName + " " + pLan);
//		return mv ;
//	}
	
	
	//section 14
//	@RequestMapping("addProgrammer")
//	public ModelAndView addProgrammer(@RequestParam("pId") int id , @RequestParam("pName")  String name, @RequestParam String pLan) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("programmer.html");
//        mv.addObject("pId", id);
//        mv.addObject("pName", name);
//        mv.addObject("pLan", pLan);
//		System.out.println(id + " " + name + " " + pLan);
//		return mv ;
//	}
//	
	//section 14.1 next section.
	
	//@RequestMapping(value = "addProgrammer", method = RequestMethod.POST)
	@PostMapping("addProgrammer")
	public String addProgrammer(@ModelAttribute Programmer programmer) {
		programmerRepo.save(programmer);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("programmer.html");
//		return mv;
		return "redirect:/home";
	}
	
	
	@PostMapping("/findById")
	public String findById(@RequestParam int pId, Model model ) {
		Programmer programmer = programmerRepo.getOne(pId);
		model.addAttribute("programmer", programmer);
		return "programmer.html";
	}
	
	
//	@PostMapping("/dp")
//	public String deleteProgrammer(@RequestParam int pId) {
//		programmerRepo.deleteById(pId);
//		return "redirect:/home";
//	}
	
	@PostMapping("/updateProgrammer")
	public String update(@ModelAttribute Programmer programmer) {
		Programmer p   = programmerRepo.getById(programmer.getpId());
		p.setpName(programmer.getpName());
		p.setpLan(programmer.getpLan());
		programmerRepo.save(p);
		programmerRepo.
		return "programmer.html";
	}
//	@PostMapping("/addProgrammer")
//	public String addProgrammer(@ModelAttribute Programmer programmer) {
//		programmerRepo.save(programmer);
//		return "programmer.html";	
//	}
	@ModelAttribute
	public void welcome(Model m) {
		m.addAttribute("message" , "Welcome Spring boot tutorial");
	}
	
	
	@GetMapping("/allProgrammer")
	public String allProgrammer(Model model) {
		List<Programmer> p = new ArrayList<>();
		p.add(new Programmer(101, "Mohammad", "Java"));
		p.add(new Programmer(102, "Abu Siam", "React"));
		p.add(new Programmer(103, "Ataur", "Django"));
        model.addAttribute("programmers", p);
        return "allProgrammer.html";

	}
	
	
}
