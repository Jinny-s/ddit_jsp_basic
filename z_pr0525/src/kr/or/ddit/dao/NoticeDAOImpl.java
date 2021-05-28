package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO {

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

	@Override
	public NoticeVO selectNoticeByNNO(SqlSession session, int nno) throws SQLException {
		NoticeVO notice = session.selectOne("Notice-Mapper.selectNoticeByNNO", nno);
		return notice;
	}

	@Override
	public List<NoticeVO> selectNoticeBeforeEnddate(SqlSession session) throws SQLException {
		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.selectNoticeBeforeEnddate");
		return noticeList;
	}

	@Override
	public List<NoticeVO> selectNoticeAllList(SqlSession session) throws SQLException {
		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.selectNoticeAllList");
		return noticeList;
	}

}
