package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
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
	public NoticeVO getNotice(int nno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			NoticeVO notice = noticeDAO.selectNoticeByNno(session, nno);
			return notice;
		} finally {
			session.close();
		}
	}

	@Override
	public List<NoticeVO> getNoticeList() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<NoticeVO> noticeList = noticeDAO.selectNoticeList(session);
			return noticeList;
		} finally {
			session.close();
		}
	}

	@Override
	public List<NoticeVO> getNoticeList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<NoticeVO> noticeList = noticeDAO.selectNoticeList(session, cri);
			return noticeList;
		} finally {
			session.close();
		}
	}

	@Override
	public Map<String, Object> getNoticeList(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		try {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(noticeDAO.selectSearchNoticeListCount(session, cri));
			
			List<NoticeVO> noticeList = noticeDAO.selectNoticeList(session, cri);
			
			dataMap.put("noticeList", noticeList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
		} finally {
			session.close();
		}
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
}
