package com.hj.point;

import java.util.ArrayList;

public class PointService {
	
	private PointDAO pointDAO;
	
	public PointService() {
		this.pointDAO = new PointDAO();
	}
	//5. Update
	public int pointMod(PointDTO pointDTO) throws Exception{
		pointDTO.setTot(pointDTO.getKor()+pointDTO.getEng()+pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTot()/3.0);
		
		return pointDAO.pointMod(pointDTO);
	}
	
	
	//4. Insert
	public int pointAdd (PointDTO pointDTO) throws Exception{
		pointDTO.setTot(pointDTO.getKor()+pointDTO.getEng()+pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTot()/3.0);
		
		return pointDAO.pointAdd(pointDTO);
	}
	
	//3. Delete
	public int pointDelete(int num) throws Exception{
		return pointDAO.pointDelete(num);
	}
	
	//2. Select 
	public PointDTO pointSelect(int num) throws Exception{
		
		return pointDAO.pointSelect(num);
	}
	
	//1. List
	public ArrayList<PointDTO> pointList() throws Exception {
		return pointDAO.pointList();
	}

}
