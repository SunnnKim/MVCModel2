package service.impl;

import java.util.List;

import dto.BbsDto;
import s.BbsDao;
import s.impl.BbsDaoImpl;
import service.BbsService;

public class BbsServiceImpl implements BbsService {
	
	BbsDao dao = new BbsDaoImpl();
	
	// 전체 리스트 뿌려주기 
	@Override
	public List<BbsDto> getBbsList() {
		return dao.getBbsList();
	}

	// 새 글쓰기
	@Override
	public boolean writeBBS(BbsDto dto) {
		return dao.writeBBS(dto);
	}

}
