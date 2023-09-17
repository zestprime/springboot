package com.test.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.emp.Employee;

@RestController
public class MyController {

	//@Autowired
	//@Qualifier(value = "perEmployee")
	Employee pEmp;
	
	//@Autowired
	//@Qualifier(value = "conEmployee")
	Employee cEmp;
	
	public MyController() {
	}
	
	/*@Autowired
	public MyController(@Qualifier(value = "perEmployee") Employee pEmp,@Qualifier(value = "conEmployee") Employee cEmp) {
		this.pEmp =pEmp;
		this.cEmp =cEmp;
	}*/
	
	
	
	@GetMapping("/per")
	public String getPerEmpDetails() {
		
		return pEmp.empDetails();
	}
	
	
	public Employee getpEmp() {
		return pEmp;
	}

	@Autowired
	public void setpEmp(@Qualifier(value = "perEmployee") Employee pEmp) {
		this.pEmp = pEmp;
	}

	public Employee getcEmp() {
		return cEmp;
	}

	@Autowired
	public void setcEmp(@Qualifier(value = "conEmployee") Employee cEmp) {
		this.cEmp = cEmp;
	}

	@GetMapping("/con")
	public String getConEmpDetails() {
		
		return cEmp.empDetails();
	}
}
