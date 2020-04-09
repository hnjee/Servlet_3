# Servlet_3

## 기능 

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
/member/memberJoin
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

# 집에서 추가
# 집에서 추가 2
