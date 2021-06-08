package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.OrderVO;

public interface OrderService {
	
	// 주문목록 조회
	Map<String, Object> getOrderList(SearchCriteria cri) throws SQLException;
	
	// 주문번호로 주문 조회
	OrderVO getOrder(int ono) throws SQLException;
	
}
