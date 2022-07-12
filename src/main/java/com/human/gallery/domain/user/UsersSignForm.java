package com.human.gallery.domain.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UsersSignForm {
	
	@NotBlank
	@Pattern(regexp = "/^[A-Za-z]{1}[A-Za-z0-9]{5,14}$/")
	private String id;
	
	@NotBlank
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
	private String password;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String dtaddress;
	@Email
	private String email;
	
	@NotBlank
	@Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$")
	private String mobile;

	@NotNull
	private int postcode;
}
