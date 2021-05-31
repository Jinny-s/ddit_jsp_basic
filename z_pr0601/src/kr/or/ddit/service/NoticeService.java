package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.dto.NoticeVO;

public interface NoticeService {
	
	int insertNotice(NoticeVO notice) throws SQLException;
	
	int updateNotice(NoticeVO notice) throws SQLException;
	
	int deleteNotice(int nno) throws SQLException;
	
	NoticeVO getNoticeByNNO(int nno) throws SQLException;
	
	List<NoticeVO> getNoticeBeforeEnddate() throws SQLException;
	
	List<NoticeVO> getNoticeAllList() throws SQLException;
	List<NoticeVO> getNoticeAllList(Criteria cri) throws SQLException;
	
}
