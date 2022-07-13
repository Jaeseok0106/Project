package com.human.gallery.domain.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UsersSignForm {
	
	@NotBlank
	@Pattern(regexp="^[a-z]{1}[a-z0-9]{5,12}$")
	private String id;
	
	@NotBlank
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
	private String password;
	@NotBlank
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
	private String passwordCheck;
	
	@NotBlank
	@Pattern(regexp="^[ㄱ-ㅎ가-힣]*$")
	private String name;
	@NotBlank
	private String address;
	
	@NotBlank
	private String dtaddress;
	@NotBlank
	private String refAddress;
	@Email
	private String email;
	
	@NotBlank
	@Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$")
	private String mobile;

	@NotNull
	private int postcode;
}
