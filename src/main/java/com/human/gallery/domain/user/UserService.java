package com.human.gallery.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	private final UserRepository userRepository;
	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public Users login(String id, String password) {
		Users user = userRepository.findById(id);
	
		if (user == null)
		{
			return null;
		}
		else if (user.getPassword().equals(password)) {
			return user;
		}
		else {
			return null;
		}
	}
	
}
