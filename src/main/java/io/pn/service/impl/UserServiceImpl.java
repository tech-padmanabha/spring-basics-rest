package io.pn.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.pn.dto.UserDto;
import io.pn.entity.User;
import io.pn.exception.UserNotAvailableException;
import io.pn.exception.UserStoringException;
import io.pn.repository.UsersRepository;
import io.pn.service.UserService;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDto getUserByUserId(Integer id) {
		Optional<User> user = userRepository.findById(id);
		UserDto userDto = null;

		if (user.isPresent()) {
			User user2 = user.get();
			userDto = convertToDto(user2);
		} else {
			throw new UserNotAvailableException("User is not available");
		}
		return userDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserDto> usersDto = new ArrayList<>();
		if (!users.isEmpty()) {
			users.forEach(user -> usersDto.add(convertToDto(user)));
		} else {
			throw new UserNotAvailableException("There are no users available");
		}
		return usersDto;
	}

	@Override
	public Optional<UserDto> getUserByUserName(String userName) {
		Optional<User> users = userRepository.findByUsername(userName);
		Optional<UserDto> usersDto = null;

		if (users.isPresent()) {
			usersDto = Optional.ofNullable(convertToDto(users.get()));
		} else {
			throw new UserNotAvailableException("User does not exists");
		}
		return usersDto;
	}

	@Transactional
	@Override
	public UserDto saveUser(UserDto user) {

		User savedUser = userRepository.save(convertToUser(user));
		if (savedUser != null) {
			return convertToDto(savedUser);
		}
		return null;
	}

	@Transactional
	@Override
	public List<UserDto> saveUsers(List<UserDto> users) {
		List<User> userList = new ArrayList<>();

		// map all the user dto data into user and save
		users.forEach(us -> userList.add(convertToUser(us)));

		// to return List dto
		List<UserDto> usersDto = new ArrayList<>();
		try {
			List<User> savedUsers = userRepository.saveAll(userList);
			savedUsers.forEach(su -> usersDto.add(convertToDto(su)));
		} catch (Exception e) {
			throw new UserStoringException("Unable to store the users");
		}
		return usersDto;
	}

	@Transactional
	@Override
	public void removeUserByUsername(String username) {
		Optional<User> byUsername = userRepository.findByUsername(username);
		if (byUsername.isPresent()) {
			userRepository.delete(byUsername.get());
		}else {
			throw new UserNotAvailableException("Username is not available");
		}
	}

	@Transactional
	@Override
	public void removeUserById(Integer userId) {
		if (userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
		} else {
			throw new UserNotAvailableException("User id is not available");
		}
	}

	@Transactional
	@Override
	public UserDto updateUser(UserDto user) {
		boolean exists = userRepository.existsByUsername(user.username());
		UserDto userDto = null;
		if (exists) {
			Optional<User> byUserName = userRepository.findByUsername(user.username());
			
//				Optional<User> anyUser = byUserName.stream().filter(u -> u.getUsername().equals(user.username()))
//						.findAny();
				if (byUserName.isPresent()) {
					User toUpUser = byUserName.get();
					toUpUser.setUsername(user.username());
					toUpUser.setPassword(user.password());
					User save = userRepository.save(toUpUser);
					userDto = convertToDto(save);
				} else {
					throw new UserNotAvailableException("Username is not available");
				}
			

		}
		return userDto;
	}

	private User convertToUser(UserDto userD) {
		User user = new User();
		user.setUsername(userD.username());
		user.setPassword(userD.password());
		return user;
	}

	private UserDto convertToDto(User user) {
		return new UserDto(user.getUsername(), user.getPassword());
	}

}
