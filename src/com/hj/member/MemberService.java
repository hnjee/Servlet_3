package com.hj.member;

public class MemberService {
	MemberDAO memberDAO;
	public MemberService(){
		memberDAO = new MemberDAO();
	}
	
	//2. Login
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		return memberDAO.memberLogin(memberDTO);
	}
	
	//1. Join
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		return memberDAO.memberJoin(memberDTO);
	}

}
