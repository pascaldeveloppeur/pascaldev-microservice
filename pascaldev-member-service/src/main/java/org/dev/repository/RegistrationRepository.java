package org.dev.repository;

import java.util.List;

import org.dev.model.MemberType;
import org.dev.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

	List<Registration> findAllRegistrationBymemberStatus(MemberType status);
}
