package com.hj.notice;

import java.util.ArrayList;

public class NoticeService {
	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		this.noticeDAO = new NoticeDAO();
	}
	
	//3. Add
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeAdd(noticeDTO);
	}
	//2. Select 
	public NoticeDTO noticeSelect(int no) throws Exception{
		return noticeDAO.noticeSelect(no);
	}
	//1. List
	public ArrayList<NoticeDTO>  noticeList() throws Exception {
		return noticeDAO.noticeList();
	}

}
