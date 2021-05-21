package kr.or.ddit.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dto.MemberVO;

public class TestMemberService {
	
	private MemberServiceImpl service;
	
	@Before
	public void init() {
		service = new MemberServiceImpl();
		service.setMemberDAO(new MockMemberDAO());
	}
	
	@Test
	public void testInsertMember() throws Exception {
		
	}
	
	@Test
	public void testGetMemberByID() throws Exception {
		MemberVO member = service.getMemberByID("mem999");
		
		Assert.assertEquals("test", member.getMemPw());
	}
	
	@Test
	public void testGetMemberList () throws Exception {
		List<MemberVO> memberList = service.getMemberList();
		
		Assert.assertEquals(1, memberList.size());
		Assert.assertEquals("mem999", memberList.get(0).getMemId());
	}

}
