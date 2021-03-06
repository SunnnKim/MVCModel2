package s.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.BbsDto;
import s.BbsDao;

public class BbsDaoImpl implements BbsDao {

	@Override
	public List<BbsDto> getBbsList() {
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, "
				+ " WDATE, DEL, READCOUNT "
				+ " FROM BBS "
				+ " ORDER BY WDATE DESC ";
		
		Connection conn = null;			// DB Connection
		PreparedStatement psmt = null;	// SQL
		ResultSet rs = null;			// result
		
		List<BbsDto> list = new ArrayList<BbsDto>();
				
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BbsDto dto = new BbsDto(rs.getInt(1), //seq, 
										rs.getString(2), //id, 
										rs.getString(3), //title, 
										rs.getString(4), //content, 
										rs.getString(5), //wdate, 
										rs.getInt(6), //del, 
										rs.getInt(7) //readcount
						);
				list.add(dto);				
			}			
			
		} catch (SQLException e) {			
			e.printStackTrace();			
		} finally {
			DBClose.close(psmt, conn, rs);			
		}		
		
		return list;
	}

	@Override
	public boolean writeBBS(BbsDto dto) {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "INSERT INTO BBS(SEQ, ID, TITLE, CONTENT, WDATE, DEL, READCOUNT) "
				+ " VALUES(SEQ_BBS.NEXTVAL, ?, ?, ?, SYSDATE, 0, 0) ";
		
		try {
			conn = DBConnection.getConnection();			
			psmt = conn.prepareStatement(sql);			
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			
			count = psmt.executeUpdate();			
			
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally{
			DBClose.close(psmt, conn, rs);			
		}
		
		return count>0?true:false;
		
	}

	
	
}

