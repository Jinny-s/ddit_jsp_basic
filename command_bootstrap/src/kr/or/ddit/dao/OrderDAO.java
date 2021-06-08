package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.OrderVO;

public interface OrderDAO {
	
	// 주문목록 조회
	List<OrderVO> selectOrderList(SqlSession session, SearchCriteria cri) throws SQLException;
	
	// 목록 리스트 개수
	int selectOrderListCount(SqlSession session, SearchCriteria cri) throws SQLException;
	
	// 주문번호로 주문 조회
	OrderVO selectOrderByOno(SqlSession session, int ono) throws SQLException;
	
}
