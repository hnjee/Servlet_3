package com.hj.notice;

import java.util.ArrayList;

public class NoticeService {
	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		this.noticeDAO = new NoticeDAO();
	}
	
	//1. List
	public ArrayList<NoticeDTO>  noticeList() throws Exception {
		return noticeDAO.noticeList();
	}

}
