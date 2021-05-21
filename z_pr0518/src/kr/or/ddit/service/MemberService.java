package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dto.MemberVO;

public interface MemberService {

	int insertMember(MemberVO member) throws SQLException;
	
	int updateMember(MemberVO member) throws SQLException;
	
	int deleteMember(String memId) throws SQLException;
	
	MemberVO getMemberByID(String memId) throws SQLException;
	
	List<MemberVO> getMemberList() throws SQLException;
	
}
