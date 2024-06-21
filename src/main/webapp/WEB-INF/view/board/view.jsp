<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:choose>
	<c:when test="${empty title }">
		<title>핏투게더</title>
	</c:when>
	<c:otherwise>
		<title>${title }::핏투게더</title>
	</c:otherwise>
</c:choose>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/style.css?<%=System.currentTimeMillis() %>" />
</head>
<body>
	<div class="container px-1">
		<div class="my-3">
			<%@ include file="/WEB-INF/view/common/nav.jsp" %>
		</div>
		<div >
			<a href="${pageContext.servletContext.contextPath }/board/list">
			<span class="fw-2 ">자유게시판</span>
			</a>
			 &gt; <span class="warning"></span>
		
		<div class="wrap-md">
			<div class="align-center d-flex space-center">
				<h2 class="fw-2">${board.title }</h2> &nbsp;&nbsp;
				<span class="hash fw-4">#${board.category }</span> 
			</div>
			<div class="text-center border-rounded2 p-5 ">
				<div class="fs-5">
					<span class="float-left"> 작성자 : ${board.writeId}</span>
					<span class="float-right" >  | 등록일 :${board.writeAt} </span>
					<span class="float-right">&nbsp; 조회 ${board.readCnt} &nbsp;</span><br/>
				</div>
				<br/>
				<p class="mx-5 my-5">
					${board.body }
				</p>
			</div>
			<button type="button" class="align-right-b b2">수정</button>
			<a href="${pageContext.servletContext.contextPath }/board/list">
				<button type="button" class="align-right-b b2">목록</button>
			</a>
					
		</div>	
	</div>	
</body>
</html>