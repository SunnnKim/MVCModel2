package main;

import db.DBConnection;
import singleton.Singleton;

public class main {
	public static void main(String[] args) {
	// MVCModel 2
	/*
	 	1. main을 맨처음 실행할 때 controller부터 실행한다.
	 	2. dao는 controller하고만 대화
	 	3. dao만이 DB와 연결한다
	 	4. dao는 model에 해당한다.
	 	5. dao는 2가지로 구성 : controller와 연결하는 service(데이터 편집 등),
	 		DB와 데이터를 직접 연결하는 dao가 있다. dao와 service는 서로 연결되어있다.
	 	6. dao와 view는 대부분 연결할 일이 없지만, 아이디 중복확인 등 뷰를 유지한 상태에서 DB 데이터가 
	 		필요할 때  controller 를 거쳐가기 번거로우므로 연결할 때가 있다.
	 		(Ajax의 역할과 같음)
	 	7. 
	 	
	 */
		// DB연결
		DBConnection.initConnection();
		
		// 싱글턴 생성
		Singleton s = Singleton.getInstance();
		s.memCtrl.login();
		
	}
}
