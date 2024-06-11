package org.dev.service;

import org.dev.dto.MemberDTO;

public interface MemberService extends AbstractService<MemberDTO> {

	MemberDTO update(Long id, MemberDTO memberDTO);

}
