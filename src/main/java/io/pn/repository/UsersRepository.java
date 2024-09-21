package io.pn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.pn.entity.User;

public interface UsersRepository extends JpaRepository<User, Integer> {

	Optional<User> findById(Integer id);

	List<User> findAll();

	boolean existsByUsername(String username);
	
	Optional<User> findByUsername(String username);

}
