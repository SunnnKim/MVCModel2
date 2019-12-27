package service.impl;

import dto.MemberDto;
import s.Memberdao;
import s.impl.MemberDaoImpl;
import service.MemberService;
// MemberService 상속받은 클래스
// Service는 dao와 controller의 중개자이다. 둘 모두와 대화함
public class MemberServiceImpl implements MemberService {
	
	// 멤버dao는 가장 나중에 생성되도록 설계한다.
	Memberdao dao = new MemberDaoImpl();

	// 아이디 중복확인 
	@Override
	public boolean getId(String id) {
		return dao.getId(id);
	}
	
	// 회원 추가하기
	@Override
	public boolean addMember(MemberDto dto) {
		return dao.addMember(dto);
	}

	// 로그인 하기
	@Override
	public MemberDto login(String id, String pwd) {
		return dao.login(id, pwd);
	}
	
	
}
