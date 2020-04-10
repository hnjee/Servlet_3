package com.hj.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hj.util.DBConnect;

public class MemberDAO {
	//4. Update
	public int memberUpdate(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnect.getConnection();
		String sql="update member set pw=?, name=?, age=?, phone=?, email=? where id=? and pw =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getPw());
		st.setString(2, memberDTO.getName());
		st.setInt(3, memberDTO.getAge());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());
		st.setString(6, memberDTO.getId());
		st.setString(7, memberDTO.getPw());
		
		int res = st.executeUpdate();
		if(res>0) System.out.println("수정완료");
		
		st.close();
		con.close();
		return res;
	}
	
	//3. Delete
	public int memberDelete(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnect.getConnection();
		String sql="delete member where id = ? and pw =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		
		int res = st.executeUpdate();
		if(res>0) System.out.println("삭제완료");
		
		st.close();
		con.close();
		
		return res;
	}
	
	//2. Login 
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnect.getConnection();
		String sql = "select * from member where id=? and pw=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setAge(rs.getInt("age"));
		}else {
			memberDTO = null;
		}
		
		rs.close();
		st.close();
		con.close();
		
		return memberDTO;
	}
	
	//1. Join 
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnect.getConnection();
		String sql = "INSERT into member values (?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setInt(4, memberDTO.getAge());
		st.setString(5, memberDTO.getPhone());
		st.setString(6, memberDTO.getEmail());
		int res = st.executeUpdate();
		if(res>0) System.out.println("추가완료");
		st.close();
		con.close();
		return res;
	}
}
