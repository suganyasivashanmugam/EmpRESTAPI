package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.EmployeeDetails;
import com.example.demo.empService;

@Controller

public class empController {
	@Autowired
	private empService service; 
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<EmployeeDetails> listemprec = service.listAll();
		model.addAttribute("ListEmpDetails", listemprec);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewEmployeePage(Model model) {
		EmployeeDetails emp = new EmployeeDetails();
		model.addAttribute("Employee", emp);
		
		return "new_employee";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") EmployeeDetails emp) {
		service.save(emp);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditEmployeePage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_employee");
		EmployeeDetails emp = service.get(id);
		mav.addObject("Employee", emp);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
}

