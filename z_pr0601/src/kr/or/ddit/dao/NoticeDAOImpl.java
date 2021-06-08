package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO {
	
	@Override
	public NoticeVO selectNoticeByNno(SqlSession session, int nno) throws SQLException {
		NoticeVO notice = session.selectOne("Notice-Mapper.selectNoticeByNno", nno);
		return notice;
	}

	@Override
	public List<NoticeVO> selectNoticeList(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.selectSearchNoticeList", cri, rowBounds);
		return noticeList;
	}

	@Override
	public int selectSearchNoticeListCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count = 0;
		count = session.selectOne("Notice-Mapper.selectSearchNoticeListCount", cri);
		return count;
	}
	
	@Override
	public int insertNotice(SqlSession session, NoticeVO notice) throws SQLException {
		int cnt = session.insert("Notice-Mapper.insertNotice", notice);
		return cnt;
	}

	@Override
	public int updateNotice(SqlSession session, NoticeVO notice) throws SQLException {
		int cnt = session.update("Notice-Mapper.updateNotice", notice);
		return cnt;
	}

	@Override
	public int deleteNotice(SqlSession session, int nno) throws SQLException {
		int cnt = session.delete("Notice-Mapper.deleteNotice", nno);
		return cnt;
	}
}
