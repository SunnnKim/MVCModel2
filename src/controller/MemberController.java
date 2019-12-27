package controller;

import javax.swing.JOptionPane;

import dto.MemberDto;
import service.MemberService;
import service.impl.MemberServiceImpl;
import singleton.Singleton;
import view.accountView;
import view.loginView;

// controller는 service랑만 대화하도록 되어있다.
// 어디서나 대화가 가능하도록 싱글톤으로 만든다.
public class MemberController {
	
	// 생성 순서
	// memController -> memberService  -> memberDao
	MemberService memService = new MemberServiceImpl();
	
	// 생성자
	public MemberController() {
		
	}
	
	// TODO: login - 로그인 뷰 띄우는 함수
	public void login(){
		new loginView();
	}
	// TODO: regi - 회원가입 뷰 띄우는 함수
	public void regi() {
		new accountView();
	}
	
	// TODO: regiAfter - 회원가입 버튼 누른후 실행되는 함수
	// 회원가입 화면에서 넘어가면서 DB에 데이터 넣어주는 함수
	public void regiAfter(String id, String pwd, String name, String email) {
		boolean b = memService.addMember(new MemberDto(id, pwd, name, email, 3));
		if(b) {	// 회원가입 성공했을때
			JOptionPane.showMessageDialog(null, "회원가입 성공!");
			login();	// 로그인 뷰로 이동
		}else {
			JOptionPane.showMessageDialog(null, "회원가입 실패");
			regi();		// 다시 회원가입 뷰로 이동
		}
	}
	
	// TODO: idCheck - 아이디 중복체크하는 함수
	public boolean idCheck(String id) {
		return memService.getId(id);
	}
	
	// TODO: loginAfter
	public void loginAfter(String id, String pwd) {
		MemberDto dto = memService.login(id, pwd);
		if(dto == null) {	// 아이디 / 패스워드 틀렸을 때
			JOptionPane.showMessageDialog(null, "id나 password가 틀렸습니다.");
			login();
		}
		else {
			JOptionPane.showMessageDialog(null, dto.getId()+"님 환영합니다!");
			// id저장 -> 웹은 session에 저장하지만 여기서는 singleton에 변수로 저장한다.
			Singleton s = Singleton.getInstance();
			s.setLoginId(dto.getId());	// 로그인 정보 loginId에 저장
			
			// bbs controller list 로 이동하기
			s.bbsCtrl.getBbsList();
		}
	}
	
	
}
