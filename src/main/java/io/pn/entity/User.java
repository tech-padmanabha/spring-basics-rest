package io.pn.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, name = "user_id", nullable = false)
	private Integer userId;
	@Column(unique = true, name = "username", nullable = false)
	private String username;
	@Column(unique = true, name = "password", nullable = false)
	private String password;

	String email;
	String mobileNo;
	BigDecimal annualCTC;
	Boolean appStatus;
	LocalDate dob;
	LocalDate doj;
	LocalTime timeOfJoin;
	Integer epf;
	Boolean socialStatus;
	Character gender;
	Double insurenceAmt;
	Double dailyCost;

}
