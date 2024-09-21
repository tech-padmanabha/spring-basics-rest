package io.pn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.pn.dto.UserDto;
import io.pn.exception.UserNotAvailableException;
import io.pn.service.UserService;

@RestController
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/user")
	public ResponseEntity<UserDto> getUserByUserId(@RequestParam Integer id) {
		UserDto userByUserId = userService.getUserByUserId(id);
		return new ResponseEntity<>(userByUserId, HttpStatusCode.valueOf(200));
	}

	@GetMapping(value = "/user/all")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> allUsers = userService.getAllUsers();
		return new ResponseEntity<>(allUsers, HttpStatusCode.valueOf(200));
	}

	@GetMapping(value = "/user/{userName}")
	public ResponseEntity<Optional<UserDto>> getUserByUserName(@PathVariable String userName) {
		Optional<UserDto> users = userService.getUserByUserName(userName);
		return new ResponseEntity<>(users, HttpStatusCode.valueOf(200));
	}

	@PostMapping(value = "/user/save-user")
	public ResponseEntity<UserDto> saveUser(@Validated @RequestBody UserDto user) {
		UserDto saveUser = userService.saveUser(user);
		return new ResponseEntity<>(saveUser, HttpStatusCode.valueOf(201));
	}

	@PostMapping(value = "/user/save-all")
	public ResponseEntity<List<UserDto>> saveUsers(@Validated @RequestBody List<UserDto> users) {
		List<UserDto> savedUsers = userService.saveUsers(users);
		return new ResponseEntity<>(savedUsers, HttpStatusCode.valueOf(201));
	}

	@DeleteMapping(value = "/user/remove/{username}/username")
	public ResponseEntity<String> removeUserByUsername(@PathVariable String username) {
		userService.removeUserByUsername(username);
		return new ResponseEntity<String>("Deleted Successfully ..", HttpStatusCode.valueOf(200));
	}

	@DeleteMapping(value = "/user/remove/userId")
	public ResponseEntity<String> removeUserById(@RequestParam Integer userId) {
		userService.removeUserById(userId);
		return new ResponseEntity<String>("Deleted Successfully ..", HttpStatusCode.valueOf(200));
	}

	@PutMapping(value = "/user/update")
	public ResponseEntity<UserDto> updateUser(@Validated @RequestBody UserDto user) {
		UserDto updateUser = userService.updateUser(user);
		if(updateUser!= null) {
		return new ResponseEntity<>(updateUser, HttpStatusCode.valueOf(201));
		}
		else {
			throw new UserNotAvailableException("User not available");
		}
	}

}
