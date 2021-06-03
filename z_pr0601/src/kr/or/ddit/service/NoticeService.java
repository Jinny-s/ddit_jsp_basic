package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.NoticeVO;

public interface NoticeService {
	
	// 게시글 조회
	NoticeVO getNotice(int nno) throws SQLException;
	
	// 게시글 리스트 조회
	List<NoticeVO> getNoticeList() throws SQLException;
	List<NoticeVO> getNoticeList(Criteria cri) throws SQLException;
	Map<String, Object> getNoticeList(SearchCriteria cri) throws SQLException;
	
	
	
	
	
	
	
	int insertNotice(NoticeVO notice) throws SQLException;
	
	int updateNotice(NoticeVO notice) throws SQLException;
	
	int deleteNotice(int nno) throws SQLException;
	
}
