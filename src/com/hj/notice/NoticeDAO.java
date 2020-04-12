package com.hj.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hj.util.DBConnect;

public class NoticeDAO {
	
	//3. Add 
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception {
		Connection con = DBConnect.getConnection();
		String sql = "insert into notice values (SEQ_NO_NOTICE.nextval, ?, ?, ?, sysdate, 1)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeDTO.getSubject());
		st.setString(2, noticeDTO.getContents());
		st.setString(3, noticeDTO.getName());
		int res = st.executeUpdate();
		if(res>0) System.out.println("글쓰기 성공");
		st.close();
		con.close();
		return res;
	}
	
	//2. Select 
	public NoticeDTO noticeSelect(int no) throws Exception{
		Connection con = DBConnect.getConnection();
		String sql = "select * from notice where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		ResultSet res = st.executeQuery(); 
		
		NoticeDTO noticeDTO = new NoticeDTO();
		while(res.next()) {
			noticeDTO.setNo(res.getInt("no"));
			noticeDTO.setSubject(res.getString("subject"));
			noticeDTO.setContents(res.getString("contents"));
			noticeDTO.setName(res.getString("name"));
			noticeDTO.setDay(res.getDate("day"));
			noticeDTO.setHit(res.getInt("hit"));
		}
		st.close();
		con.close();
		return noticeDTO;
	}
	
	//1. List 
	public ArrayList<NoticeDTO> noticeList() throws Exception {
		Connection con = DBConnect.getConnection();
		String sql = "select * from notice order by no asc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet res = st.executeQuery();
		
		ArrayList<NoticeDTO> ar = new ArrayList<NoticeDTO>();
		while(res.next()) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNo(res.getInt("no"));
			noticeDTO.setSubject(res.getString("subject"));
			noticeDTO.setName(res.getString("name"));
			noticeDTO.setDay(res.getDate("day"));
			noticeDTO.setHit(res.getInt("hit"));
			ar.add(noticeDTO);
		}
		st.close();
		con.close();
		return ar;
	}
}
