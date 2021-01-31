package com.mylab.lab18;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mylab.lab18.Emp;
import com.mylab.lab18.EmpService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	@Inject
 	EmpService empService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/viewemp", method = RequestMethod.GET)
 	public String viewemp(Model model) throws Exception {
 		model.addAttribute("viewemp", empService.selectEmployee());
 		return "viewemp";
 	}

 	@RequestMapping(value = "/empform")
 	public String showform(Model model) throws Exception {
 		model.addAttribute("command", new Emp());
 		return "empform";
 	}

 	@RequestMapping(value = "/save", method = RequestMethod.POST)
 	public String save(@ModelAttribute("emp") Emp emp) throws Exception {
 		empService.insertEmployee(emp);
 		System.out.println("save");
 		return "redirect: /mybatisexample/list";
 	}

 	@RequestMapping(value="/editemp/{id}")  
 	public String edit(@ModelAttribute("emp") Emp emp, Model model) throws Exception {
 		model.addAttribute("command", emp);
 		return "empeditform";
 	}

 	@RequestMapping(value="/editsave", method = RequestMethod.POST)
 	public String editsave(@ModelAttribute("emp") Emp emp) throws Exception {
 		try {
 			empService.editEmployee(emp);
 		} catch (Exception e) {
 			System.out.println("에러");
 			e.printStackTrace();
 		}
 		System.out.println("controller: editsave");
 		return "redirect: /mybatisexample/list";
 	}

 	@RequestMapping(value="/deleteemp/{id}", method = RequestMethod.GET)
 	public String delete(@ModelAttribute("emp") Emp emp, Model model) throws Exception {
 		try {
 			empService.deleteEmployee(emp);
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		System.out.println("delete");
 		return "redirect: /mybatisexample/list";
 	}
	
}
