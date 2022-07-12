package com.human.gallery.domain.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersLoginForm {
	@NotBlank(message = "아이디를 입력해주세요.")
	String id;
	@NotBlank(message= "비밀번호를 입력해주세요.")
	@Size(min=6, max=12)
	String password;
}
