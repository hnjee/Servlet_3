# Servlet_3

## 기능 

### 공지사항(포인트랑 비슷)
## 기능 
- 글쓰기, 수정, 삭제 id가  admin만 가능
- 글 리스트 페이지(최신순으로 출력)
- 리스트 페이지에서 글쓰기 버튼 클릭을 누르면 글쓰기로 이동
- 리스트 페이지에서 글 제목을 누르면 글 상세보기로 이동
- 글 상세보기에서 글 수정, 글 삭제 버튼 존재
- 글 삭제 버튼을 누르면 확인, 취소 창을 띄우고 확인을 누르면 삭제
- 글 수정을 누르면 글 수정페이지로 이동
- [option] 조회수 : 글 상세보기하면 조회수를 1 증가시킴 



## 페이지 



### member 
- 회원 가입      	: insert
- 회원 로그인   	: select
- 회원 수정	: update
- 회원 탈퇴 	: delete 
- 내 정보 보기 

## JSP
- /WEB-INF/views/member/..

URL
/member/memberJoin		memberJoin.jsp		GET
/member/memberJoin							POST
/member/memberLogin		memberLogin.jsp 	GET 
/member/memberLogin							POST
/member/memberPage		memberPage.jsp		GET
/member/memberUpdate	memberUpdate.jsp	GET
/member/memberUpdate						POST
/member/memberDelete						GET


### point 
- point list 출력
- point 등록
- point 상세 정보 출력	
- point 수정
- point 삭제

## JSP 
- pointList.jsp 	: List 출력 
- pointAdd.jsp 		: 입력폼 
- pointSelect.jsp 	: 상세정보 출력 
- pointMod.jsp		: 수정폼 

## URL 주소 	  /	JSP 		/ Method 
## /WEB-INF/views/point/*
- /point/pointList 	 /	pointList.jsp 	/ GET
- /point/pointAdd	 /	pointAdd.jsp	/ GET
- /point/pointAdd	 /					/ POST
- /point/pointSelect /	pointSelect.jsp	/ GET
- /point/pointMod	 /	pointMod.jsp	/ GET
- /point/pointMod	 /					/ POST
- /point/pointDelete /					/ GET