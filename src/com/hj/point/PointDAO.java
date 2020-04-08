package com.hj.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hj.util.DBConnect;

public class PointDAO {
	// DAO (Data Access Object) 
	//4. Add
	public int pointAdd(PointDTO pointDTO) throws Exception {
		Connection con = DBConnect.getConnection();
		
		String sql="INSERT INTO POINT VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, pointDTO.getName());
		st.setInt(2, pointDTO.getNum());
		st.setInt(3, pointDTO.getKor());
		st.setInt(4, pointDTO.getEng());
		st.setInt(5, pointDTO.getMath());
		st.setInt(6, pointDTO.getTot());
		st.setDouble(7, pointDTO.getAvg());
		
		int res = st.executeUpdate();
		if(res>0) System.out.println("추가완료");
		st.close();
		con.close();
		return res;
	}
	
	
	//3. Delete 
	public int pointDelete(int num) throws Exception{
		int res;
		Connection con = DBConnect.getConnection();
		
		String sql="delete from point where num = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		res = st.executeUpdate();
		if(res>0) {
			System.out.println("등록 완료");
		}
		
		st.close();
		con.close();
		return res;
	}
	
	//2. SelectOne
	public PointDTO pointSelect(int num) throws Exception{
		PointDTO pointDTO = null;
		
		Connection con = DBConnect.getConnection();
		
		String sql="select * from point where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			pointDTO = new PointDTO();
			pointDTO.setName(rs.getString("name"));
			pointDTO.setNum(rs.getInt("num"));
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTot(rs.getInt("tot"));
			pointDTO.setAvg(rs.getInt("avg"));
		} 
		rs.close();
		st.close();
		con.close();
		
		return pointDTO;
	}
	
	
	// 1. List
	public ArrayList<PointDTO> pointList() throws Exception {
		ArrayList<PointDTO> ar = new ArrayList<PointDTO>();	
		
		//1. DB 연결
		Connection con = DBConnect.getConnection();
		
		//2. SQL문 작성
		String sql = "select * from point order by num asc";
			//ERR CASE 1) 쿼리문 
		
		//3. SQL 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 값 세팅 
		
		//5. SQL 최종 전송
		ResultSet rs = st.executeQuery(); //가져오는 List는 executeQuery()
		
		//rs로 받아온 데이터 담기  
		while(rs.next()) {
			PointDTO pointDTO = new PointDTO();
			pointDTO.setName(rs.getString("name"));
			pointDTO.setNum(rs.getInt("num"));
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTot(rs.getInt("tot"));
			pointDTO.setAvg(rs.getInt("avg"));
			ar.add(pointDTO);
		}
		
		//6. 자원해제 
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
	// 2. SelectOne 
	// 3. Insert
	// 4. Update
	// 5. Delete
}
