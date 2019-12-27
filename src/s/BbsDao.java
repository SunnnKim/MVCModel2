package s;

import java.util.List;

import dto.BbsDto;

public interface BbsDao {
	
	public List<BbsDto> getBbsList(); // 게시판 전체 리스트 가져오기 
	public boolean writeBBS(BbsDto dto);
}
