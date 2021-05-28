package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dto.NoticeVO;

public interface NoticeService {
	
	int insertNotice(NoticeVO notice) throws SQLException;
	
	int updateNotice(NoticeVO notice) throws SQLException;
	
	int deleteNotice(int nno) throws SQLException;
	
	NoticeVO selectNoticeByNNO(int nno) throws SQLException;
	
	List<NoticeVO> selectNoticeBeforeEnddate() throws SQLException;
	
	List<NoticeVO> selectNoticeAllList() throws SQLException;
	
}
