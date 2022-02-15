package quoctuan.Employee.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import quoctuan.Employee.entities.EmployeeEntity;
import quoctuan.Employee.services.EmployeeServiceImpl;


@RestController
@RequestMapping("/rest")
public class Test {
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	@RequestMapping(value= {"/list"}, method= RequestMethod.GET, 
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<EmployeeEntity> list(Model model) {
		List<EmployeeEntity> lsEmployee = employeeServiceImpl.findAllEmployee();
		model.addAttribute("lsEmployee",lsEmployee );
		for (EmployeeEntity e : lsEmployee) {
			System.out.println(e.getId() + " -- "+e.getName() );
		}
		return lsEmployee;
	}
	
	
	@RequestMapping(value= {"/employees/{id}"}, method= RequestMethod.GET , produces= {
		MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE
	})
	
	public EmployeeEntity findEmployee(@PathVariable("id") int id) {
		EmployeeEntity objEmployee = employeeServiceImpl.findByEmployeeById(id);
		return objEmployee;
	}

	
	
	
}
