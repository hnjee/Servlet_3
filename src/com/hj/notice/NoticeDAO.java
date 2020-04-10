package com.hj.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hj.util.DBConnect;

public class NoticeDAO {
	//2. Select 
	public NoticeDTO noticeSelect(NoticeDTO noticeDTO) throws Exception{
		Connection con = DBConnect.getConnection();
		String sql = "select * from notice where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, noticeDTO.getNo());
		ResultSet res = st.executeQuery(); 
		
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
		return ar;
	}
}
