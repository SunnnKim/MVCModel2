package singleton;

import controller.BbsController;
import controller.MemberController;

public class Singleton {
	
	private static Singleton s = null;
	// controller가 어느곳에서든 접근 가능하도록 하기 위해 싱글턴 안에 넣는다.
	public MemberController memCtrl = null;
	public BbsController bbsCtrl = null;
	private String loginId = null; // 로그인 아이디도 싱글턴에 저장한다
	
	
	public String getLoginId() {
		// loginID getter
		return loginId;
	}

	public void setLoginId(String loginId) {
		// loginID setter
		this.loginId = loginId;
	}

	private  Singleton() {	// 생성자 
		memCtrl = new MemberController();
		bbsCtrl = new BbsController();
		
	}
	
	public static Singleton getInstance() {
		if(s == null)
			s = new Singleton();
		return s;
	}
	
}
