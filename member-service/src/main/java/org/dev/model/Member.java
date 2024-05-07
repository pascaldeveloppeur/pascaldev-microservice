package org.dev.model;

import java.io.Serializable;
import java.util.Date;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;

import org.joda.time.DateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pascal Dev
 */

@Entity
@Table(name="member")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@NotNull(message = "FirstName cannot be null")
	@Column(name = "first_name",length = 20)
	private String firstName;
	
	@NotNull(message = "LastName cannot be null")
	@Column(name = "last_name",length = 20)
	private String lastName;
	
	@NotNull(message = "UserName cannot be null")
	@Column(name = "user_name",length = 10)
	private String username;
	
	@Email(message = "Email should be valid")
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Transient
	@NotNull
	@Column(name = "gender")
	private Gender gender;
	
	@NotNull
	@Column(name = "naissance_date")
	@Transient
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@NotNull
	@Column(name = "password",unique = true)
	private String password;
	
	@OneToOne(mappedBy = "member")
	private Registration registration;
	
//	@Enumerated(EnumType.STRING)
//	@Column(name = "member_type")
//	private MemberType memberType;
	
	
	
	
	
	
	
	

}
