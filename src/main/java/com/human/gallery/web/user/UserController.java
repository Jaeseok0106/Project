package com.human.gallery.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.human.gallery.domain.user.UserService;
import com.human.gallery.domain.user.Users;
import com.human.gallery.domain.user.UsersLoginForm;
import com.human.gallery.domain.user.UsersSignForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/login")
	public String viewLogin(@ModelAttribute("user") Users user) {
		return "users/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	
	public String doLogin(@Validated @ModelAttribute("user") UsersLoginForm Form, BindingResult bindingResult,
							HttpSession session, Model model) {
		
		if (bindingResult.hasErrors())
		{
			log.info("�߻��� ����  = {}", bindingResult.getFieldError());
			return "users/login";
		}
		Users user = userService.login(Form.getId(), Form.getPassword());
		log.info("�α��� ���� = {}", user);
		if (user == null)
		{
			model.addAttribute("loginFail", "���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�.");
			return "users/login";
		}
		
		session.setAttribute("userId",user.getId());
		session.setAttribute("role", user.getRole());
		return "redirect:/";
	}
	
	@RequestMapping("/signin")
	public String viewSignin(@ModelAttribute("user") Users user) {
		return "users/signin";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String doSignin(@Validated @ModelAttribute("user") UsersSignForm form, BindingResult bindingResult) {
		log.info("�Ѿ�� ���� = {}", form);
		
		if (bindingResult.hasErrors())
		{
			log.info("�߻��� ����  = {}", bindingResult.getFieldError());
			return "users/signin";
		}
		return "redirect:/";
	}

}
