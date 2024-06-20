package org.dev.repository;

import java.util.List;

import org.dev.model.Member;
import org.dev.model.MemberType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {
	
	
	//List<Member> findAllMemberBymemberType(MemberType memberType);
	Member findByusername(String username);

}
