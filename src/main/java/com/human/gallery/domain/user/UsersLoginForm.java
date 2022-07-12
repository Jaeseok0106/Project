package com.human.gallery.domain.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersLoginForm {
	@NotBlank(message = "���̵� �Է����ּ���.")
	String id;
	@NotBlank(message= "��й�ȣ�� �Է����ּ���.")
	@Size(min=6, max=12)
	String password;
}
