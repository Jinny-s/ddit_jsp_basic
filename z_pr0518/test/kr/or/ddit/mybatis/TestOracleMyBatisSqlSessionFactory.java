package kr.or.ddit.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dto.MemberVO;

public class TestOracleMyBatisSqlSessionFactory {
	
	private SqlSessionFactory factory = new OracleMyBatisSqlSessionFactory();
	private SqlSession session;
	
	@Before
	public void openSession() {
		session = factory.openSession();
	}
	
	@Test
	public void testSqlSession () throws Exception {
		Assert.assertNotNull(session.getConnection());
	}
	
	@Test
	public void testSQL() {
		List<Object> list = session.selectList("Member-Mapper.selectMemberList");
		System.out.println(list);
		
		MemberVO mem = session.selectOne("Member-Mapper.selectMemberByID");
		System.out.println(mem);
		
		Assert.assertEquals("java", mem.getMemPw());
	}
	
	@After
	public void closeSession() {
		session.close();
	}
}
