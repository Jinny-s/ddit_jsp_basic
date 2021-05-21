package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dao.MemberDAO;
import kr.or.ddit.dto.MemberVO;

public class MockMemberDAO implements MemberDAO {

	@Override
	public int insertMember(SqlSession session, MemberVO member) throws SQLException {
		member = null;
		
		if(session.getConnection() == null) throw new SQLException();
		
		member.setMemId("mem999");
		
		return 0;
	}

	@Override
	public int updateMember(SqlSession session, MemberVO member) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(SqlSession session, String memId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO selectMemberByID(SqlSession session, String memId) throws SQLException {
		MemberVO member = null;
		
		if(session.getConnection() == null) throw new SQLException();
		
		if(memId.equals("mem999")) {
			member = new MemberVO();
			member.setMemPw("test");
		}
		return member;
	}

	@Override
	public List<MemberVO> selectMemberList(SqlSession session) throws SQLException {
		List<MemberVO> menuList = null;
		
		if(session.getConnection() == null) throw new SQLException();
		
		MemberVO member = new MemberVO();
		member.setMemId("mem999");
		
		menuList = new ArrayList<>();
		menuList.add(member);
		
		return menuList;
	}

}
