package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.dto.NoticeVO;

public interface NoticeDAO {
	
	int insertNotice(SqlSession session, NoticeVO notice) throws SQLException;
	
	int updateNotice(SqlSession session, NoticeVO notice) throws SQLException;
	
	int deleteNotice(SqlSession session, int nno) throws SQLException;
	
	NoticeVO selectNoticeByNNO(SqlSession session, int nno) throws SQLException;
	
	List<NoticeVO> selectNoticeBeforeEnddate(SqlSession session) throws SQLException;
	
	List<NoticeVO> selectNoticeAllList(SqlSession session) throws SQLException;
	List<NoticeVO> selectNoticeAllList(SqlSession session, Criteria cri) throws SQLException;

}