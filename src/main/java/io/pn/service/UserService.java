package io.pn.service;

import java.util.List;
import java.util.Optional;

import io.pn.dto.UserDto;

public interface UserService {
	UserDto getUserByUserId(Integer id);

	List<UserDto> getAllUsers();

	Optional<UserDto> getUserByUserName(String userName);
	
	UserDto saveUser(UserDto user);
	
	List<UserDto> saveUsers(List<UserDto> users);
	
	void removeUserByUsername(String username);
	
	void removeUserById(Integer userId);
	
	UserDto updateUser(UserDto user);
}
