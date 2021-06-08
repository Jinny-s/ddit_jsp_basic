package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.OrderVO;
import kr.or.ddit.handler.Handler;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public List<OrderVO> selectOrderList(SqlSession session, SearchCriteria cri) throws SQLException {
		
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<OrderVO> orderlist = session.selectList("Order-Mapper.selectOrderList", cri, rowBounds);
		System.out.println("오덜덜" + orderlist);
		return orderlist;
	}

	@Override
	public int selectOrderListCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count = 0;
		count = session.selectOne("Order-Mapper.selectOrderListCount", cri);
		return count;
	}

	@Override
	public OrderVO selectOrderByOno(SqlSession session, int ono) throws SQLException {
		OrderVO order = session.selectOne("Order-Mapper.selectOrderByOno", ono);
		return order;
	}
	
}
