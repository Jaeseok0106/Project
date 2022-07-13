package com.human.gallery.domain.user;

public interface UserRepository {
	
	Users findById(String id);
	void addUser(String id, String password);
	void addDetail(Integer number, String name, String mobile, String address, String dtaddress, String email, int postcode);
	Integer findNumById(String id);
}
