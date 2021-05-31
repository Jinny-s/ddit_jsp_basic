package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
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
	public int deleteMember(SqlSession session, String id) throws SQLException {
		int cnt = session.delete("Member-Mapper.deleteMember", id);
		return cnt;
	}
	
	@Override
	public MemberVO selectMemberById(SqlSession session, String id) throws SQLException {
		MemberVO member = session.selectOne("Member-Mapper.selectMemberByID", id);
		return member;
	}

	@Override
	public List<MemberVO> selectMemberList(SqlSession session) throws SQLException {
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList");
		return memberList;
	}

	@Override
	public List<MemberVO> selectMemberList(SqlSession session, Criteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList", null, rowBounds);
		return memberList;
	}

}
