package controller;

import java.util.List;

import javax.swing.JOptionPane;

import dto.BbsDto;
import service.BbsService;
import service.impl.BbsServiceImpl;
import view.bbsAddView;
import view.bbsListView;

public class BbsController {
	
	BbsService bbsService = new BbsServiceImpl();
		
	// 전체리스트 받아오기
	public void getBbsList() {
		List<BbsDto> list = bbsService.getBbsList();
		new bbsListView(list);
	}
	// 글쓰는 화면 
	public void write() {
		new bbsAddView();
	}
	public boolean writeBbs(BbsDto dto) {
		boolean b =  bbsService.writeBBS(dto);
		if(b) {
			JOptionPane.showMessageDialog(null, "글 추가 성공!");
			getBbsList();
		}else {
			JOptionPane.showMessageDialog(null, "글 추가 실패");
		}
		return b;
	}
	
	
}
