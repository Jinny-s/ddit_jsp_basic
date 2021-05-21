package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class TestMemberServiceDAOImpl {

	private SqlSession session;
	private MemberDAO memberDAO;
	
	@Before
	public void init() {
		session = new OracleMyBatisSqlSessionFactory().openSession(false);
		memberDAO = new MemberDAOImpl();
	}
	
	@Test
	public void testInsertMember() throws Exception {
		MemberVO member = new MemberVO();
		member.setMemId("mem999");
		member.setMemPw("java");
		member.setMemEmail("java@ja.va");
		member.setMemHp("010-9999-9999");
		
		int cnt = memberDAO.insertMember(session, member);

		MemberVO member2 = memberDAO.selectMemberByID(session, "mem999");
		member2.getMemId();
		member2.getMemPw();
		member2.getMemEmail();
		member2.getMemHp();
		
		Assert.assertEquals(1, cnt);
		Assert.assertEquals("mem999", member2.getMemId());
		Assert.assertEquals("java", member2.getMemPw());
		Assert.assertEquals("java@ja.va", member2.getMemEmail());
		Assert.assertEquals("010-9999-9999", member2.getMemHp());
	}
	
	@Test
	public void testUpdateMember() throws Exception {
		MemberVO member = new MemberVO();
		member.setMemId("mem001");
		member.setMemPw("java");
		member.setMemEmail("java@ja.va");
		member.setMemHp("010-8888-8888");
		
		int cnt = memberDAO.updateMember(session, member);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testDeleteMember() throws Exception {
		int cnt = memberDAO.deleteMember(session, "mem001");
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testSelectMemberByID() throws Exception {
		MemberVO member = memberDAO.selectMemberByID(session, "mem001");
		Assert.assertEquals("java@java.kr", member.getMemEmail());
	}
	
	@Test
	public void testSelectMemberList() throws Exception {
		List<MemberVO> memList = memberDAO.selectMemberList(session);
		Assert.assertEquals(2, memList.size());
	}
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
	
}
