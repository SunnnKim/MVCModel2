package service;

import dto.MemberDto;

// service 인터페이스
public interface MemberService {
	
	// 아이디중복확인
	public boolean getId(String id);
	public boolean addMember(MemberDto dto);
	public MemberDto login(String id, String pwd);
}
