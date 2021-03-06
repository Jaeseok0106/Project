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
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {
		
		model.addAttribute("userinfo", session.getAttribute("userId"));
		return "home";
	}

	@RequestMapping("/login")
	public String viewLogin(@ModelAttribute("user") Users user) {
		return "users/login";
	}
	@RequestMapping("/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	
	public String doLogin(@Validated @ModelAttribute("user") UsersLoginForm Form, BindingResult bindingResult,
							HttpSession session, Model model) {
		
		if (bindingResult.hasErrors())
		{
			log.info("발생한 에러  = {}", bindingResult.getFieldError());
			return "users/login";
		}
		Users user = userService.login(Form.getId(), Form.getPassword());
		log.info("로그인 여부 = {}", user);
		if (user == null)
		{
			model.addAttribute("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
			return "users/login";
		}
		
		session.setAttribute("userId",user.getId());
		session.setAttribute("role", user.getRole());
		return "redirect:/";
	}
	
	@RequestMapping("/signin")
	public String viewSignin(@ModelAttribute("user") UsersSignForm user) {
		return "users/signin";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String doSignin(@Validated @ModelAttribute("user") UsersSignForm form, BindingResult bindingResult,
							Model model) {
		log.info("넘어온 값들 = {}", form);
		
		if (bindingResult.hasErrors())
		{
			log.info("발생한 에러  = {}", bindingResult.getFieldError());
			return "users/signin";
		}
		Users checkId = userService.checkId(form.getId());
		if (checkId != null)
		{
			model.addAttribute("overlap", "이미 존재하는 아이디입니다.");
			return "users/signin";
		}
		if (!form.getPassword().equals(form.getPasswordCheck()))
		{
			model.addAttribute("passwordError", "비밀번호가 일치하지 않습니다.");
			return "users/signin";
		}
		userService.addUsers(form);
		return "redirect:/login";
	}

}
