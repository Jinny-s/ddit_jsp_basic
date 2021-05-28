package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.InvalidPasswordException;
import kr.or.ddit.exception.NotFoundIDException;

public interface MemberService {

	int insertMember(MemberVO member) throws SQLException;
	
	int updateMember(MemberVO member) throws SQLException;
	
	int deleteMember(String id) throws SQLException;
	
	MemberVO getMemberByID(String id) throws SQLException;
	
	List<MemberVO> getMemberList() throws SQLException;
	
	void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException;
	
}
