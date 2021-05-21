package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public int insertMember(SqlSession session, MemberVO member) throws SQLException {
		int cnt = session.insert("Member-Mapper.insertMember", member);
		return cnt;
	}

	@Override
	public int updateMember(SqlSession session, MemberVO member) throws SQLException {
		int cnt = session.update("Member-Mapper.updateMember", member);
		return cnt;
	}

	@Override
	public int deleteMember(SqlSession session, String memId) throws SQLException {
		int cnt = session.delete("Member-Mapper.deleteMember", memId);
		return cnt;
	}

	@Override
	public MemberVO selectMemberByID(SqlSession session, String memId) throws SQLException {
		MemberVO member = session.selectOne("Member-Mapper.selectMemberByID", memId);
		return member;
	}

	@Override
	public List<MemberVO> selectMemberList(SqlSession session) throws SQLException {
		List<MemberVO> memList = session.selectList("Member-Mapper.selectMemberList");
		return memList;
	}

}
