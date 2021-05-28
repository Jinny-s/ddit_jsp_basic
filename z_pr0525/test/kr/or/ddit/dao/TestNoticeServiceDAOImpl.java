package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dto.NoticeVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class TestNoticeServiceDAOImpl {

	private SqlSession session;
	private NoticeDAO noticeDAO;
	
	@Before
	public void init() {
		session = new OracleMyBatisSqlSessionFactory().openSession(false);
		noticeDAO = new NoticeDAOImpl();
	}
	
	@Test
	public void testInsertNotice() throws Exception {
		NoticeVO notice = new NoticeVO();
		notice.setNno(999999);
		notice.setTitle("test");
		notice.setWriter("test");
		notice.setContent("test");
		notice.setRegdate("2021/05/25");
		notice.setViewcnt(0);
		notice.setPoint(0);
		notice.setStartdate("2021/05/25");
		notice.setEnddate("2021/05/25");
		notice.setUpdatedate("2021/05/25");
		notice.setDist("N");
		
		int cnt = noticeDAO.insertNotice(session, notice);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testUpdateNotice() throws Exception {
		NoticeVO notice = new NoticeVO();
		notice.setTitle("test2");
		notice.setContent("test2");
		notice.setEnddate("2021/01/01");
		notice.setUpdatedate("2021/01/20");
		notice.setNno(27);
		
		int cnt = noticeDAO.updateNotice(session, notice);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testDeleteNotice() throws Exception {
		int cnt = noticeDAO.deleteNotice(session, 27);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testSelectNoticeByNNO() throws Exception {
		NoticeVO notice = noticeDAO.selectNoticeByNNO(session, 18);
		Assert.assertEquals("111", notice.getTitle());
	}
	
	@Test
	public void testSelectNoticeBeforeEnddate() throws Exception {
		List<NoticeVO> noticeList = noticeDAO.selectNoticeBeforeEnddate(session);
		Assert.assertEquals(6, noticeList.size());
	}
	
	@Test
	public void testSelectNoticeAllList() throws Exception {
		List<NoticeVO> noticeList = noticeDAO.selectNoticeAllList(session);
		Assert.assertEquals(22, noticeList.size());
	}
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
}
