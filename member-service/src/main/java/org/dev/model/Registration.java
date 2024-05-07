package org.dev.model;

import java.io.Serializable;
import java.util.Date;

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
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "registration")
@AllArgsConstructor
@NoArgsConstructor
public class Registration implements Serializable {
	
	/**
	 * @author Pascal Dev
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registration_seq")
	@SequenceGenerator(name = "registration_seq", sequenceName = "registration_seq", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@NotNull
	@Column(name = "registration_date")
	@Temporal(TemporalType.DATE)
	private Date registrationDate;
	
	@NotNull
	@Column(name = "amount")
	private double amount;
	
	@Transient
	String userName;
	
	@OneToOne
	Member member;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private MemberType memberStatus;
	

}
