package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.dao.NoticeDAO;
import kr.or.ddit.dto.NoticeVO;

public class NoticeServiceImpl implements NoticeService {

	private NoticeDAO noticeDAO;
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	} 
	
	@Override
	public int insertNotice(NoticeVO notice) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		cnt = noticeDAO.insertNotice(session, notice);
		session.close();
		
		return cnt;
	}

	@Override
	public int updateNotice(NoticeVO notice) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		cnt = noticeDAO.updateNotice(session, notice);
		session.close();
		
		return cnt;
	}

	@Override
	public int deleteNotice(int nno) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		cnt = noticeDAO.deleteNotice(session, nno);
		session.close();
		
		return cnt;
	}

	@Override
	public NoticeVO selectNoticeByNNO(int nno) throws SQLException {
		NoticeVO notice = null;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		notice = noticeDAO.selectNoticeByNNO(session, nno);
		session.close();
		
		return notice;
	}

	@Override
	public List<NoticeVO> selectNoticeBeforeEnddate() throws SQLException {
		List<NoticeVO> noticeList = null;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		noticeList = noticeDAO.selectNoticeBeforeEnddate(session);
		session.close();
		
		return noticeList;
	}

	@Override
	public List<NoticeVO> selectNoticeAllList() throws SQLException {
		List<NoticeVO> noticeList = null;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		noticeList = noticeDAO.selectNoticeAllList(session);
		session.close();
		
		return noticeList;
	}
}
