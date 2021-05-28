package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.dao.MemberDAO;
import kr.or.ddit.dao.MemberDAOImpl;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public int insertMember(MemberVO member) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		cnt = memberDAO.insertMember(session, member);
		session.close();
		
		return cnt;
	}
	
	@Override
	public int updateMember(MemberVO member) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		cnt = memberDAO.updateMember(session, member);
		session.close();
		
		return cnt;
	}
	
	@Override
	public int deleteMember(String id) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		cnt = memberDAO.deleteMember(session, id);
		session.close();
		
		return cnt;
	}
	
	@Override
	public MemberVO getMemberByID(String id) throws SQLException {
		MemberVO member = null;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		member = memberDAO.selectMemberByID(session, id);
		session.close();
		
		return member;
	}
	
	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		List<MemberVO> memberList = null;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		memberList = memberDAO.selectMemberList(session);
		session.close();
		
		return memberList;
	}
}
