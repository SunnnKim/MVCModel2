package service;

import java.util.List;

import dto.BbsDto;

public interface BbsService {
	
	public List<BbsDto> getBbsList();
	public boolean writeBBS(BbsDto dto);
}
