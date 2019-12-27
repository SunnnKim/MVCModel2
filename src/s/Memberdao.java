package s;

import dto.MemberDto;

public interface Memberdao {
	// model: 인터페이스로 제작
	
	
	public boolean getId(String id);
	public boolean addMember(MemberDto dto);
	public MemberDto login(String id, String pwd);	// 로그인용 함수 
}
