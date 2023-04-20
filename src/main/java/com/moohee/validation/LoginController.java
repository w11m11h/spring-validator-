package com.moohee.validation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moohee.validation.dto.StudentDto;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login")
	public String login() {		
		return "login";
	}
	
	@RequestMapping(value = "/loginOk")
	public String loginOk(StudentDto studentDto, Model model, BindingResult result) {
		
		StudentValidator validator = new StudentValidator();
		
		validator.validate(studentDto, result);
		
		if(result.hasErrors()) { //���̸� ����
			return "redirect:login";
		} else {
			model.addAttribute("student", studentDto);
			return "loginOk";
		}		
		
	}
}
