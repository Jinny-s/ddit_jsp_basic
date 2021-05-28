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
		member.setId("mem999");
		member.setPwd("java");
		member.setEmail("java@ja.va");
		member.setPicture("test");
		member.setEnabled(1);
//		member.setRegdate("2021/05/25");
		member.setPhone("010-9999-9999");
		member.setName("뿅뿅");
		member.setRegister("널");
		member.setAddress("대전시");
		member.setAuthority("멤");
		
		int cnt = memberDAO.insertMember(session, member);

		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testUpdateMember() throws Exception {
		MemberVO member = new MemberVO();
		member.setId("test");
		member.setPwd("java");
		member.setEmail("java@ja.va");
		member.setEnabled(1);
		member.setPhone("010-9999-9999");
		member.setName("테스2");
		member.setRegister("test");
		member.setAddress("세종");
		member.setAuthority("ROLE_USER");
		
		int cnt = memberDAO.updateMember(session, member);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testDeleteMember() throws Exception {
		int cnt = memberDAO.deleteMember(session, "test");
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testSelectMemberByID() throws Exception {
		MemberVO member = memberDAO.selectMemberByID(session, "test");
		Assert.assertEquals("test@test.com", member.getEmail());
	}
	
	@Test
	public void testSelectMemberList() throws Exception {
		List<MemberVO> memberList = memberDAO.selectMemberList(session);
		Assert.assertEquals(7, memberList.size());
	}
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
	
}
