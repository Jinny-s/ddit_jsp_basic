package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.Criteria;
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
	public NoticeVO getNoticeByNNO(int nno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			NoticeVO notice = noticeDAO.selectNoticeByNNO(session, nno);
			return notice;
		} finally {
			session.close();
		}
	}

	@Override
	public List<NoticeVO> getNoticeBeforeEnddate() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			List<NoticeVO> noticeList = noticeDAO.selectNoticeBeforeEnddate(session);
			return noticeList;
		} finally {
			session.close();
		}
	}

	@Override
	public List<NoticeVO> getNoticeAllList() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<NoticeVO> noticeList = noticeDAO.selectNoticeAllList(session);
			return noticeList;
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<NoticeVO> getNoticeAllList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<NoticeVO> noticeList = noticeDAO.selectNoticeAllList(session, cri);
			return noticeList;
		} finally {
			session.close();
		}
	}
}
