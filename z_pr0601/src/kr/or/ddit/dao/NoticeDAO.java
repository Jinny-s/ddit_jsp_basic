package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.NoticeVO;

public interface NoticeDAO {
	
	// 게시글 조회
	NoticeVO selectNoticeByNno(SqlSession session, int nno) throws SQLException;
	
	// 게시글리스트 조회
	List<NoticeVO> selectNoticeList(SqlSession session, SearchCriteria cri) throws SQLException;
	
	// 검색 결과의 전체 리스트 개수
	int selectSearchNoticeListCount(SqlSession session, SearchCriteria cri) throws SQLException;
	
	
	
	
	
	
	int insertNotice(SqlSession session, NoticeVO notice) throws SQLException;
	
	int updateNotice(SqlSession session, NoticeVO notice) throws SQLException;
	
	int deleteNotice(SqlSession session, int nno) throws SQLException;
	

}