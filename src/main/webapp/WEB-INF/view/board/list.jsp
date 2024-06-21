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
	<div class="my-3">
			<%@ include file="/WEB-INF/view/common/nav.jsp" %>
	</div>
 	<div class="wrap-md">
 		<h2>자유게시판</h2>
	 	<table class="text-center wrap-md">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th> 
				<th>작성일</th>
				<th>조회수</th>
			</tr>
	 		<c:forEach var="one" items="${board }">
			<tr>
			    <td>${one.no }</td>
			    <td><a class="no-deco-link" href="${pageContext.servletContext.contextPath }/board/${one.no }">${one.title }</a></td>
			    <td>${one.writeId }</td>
			    <td>${one.writeAt }</td>
			    <td>${one.readCnt }</td>
	 		</tr>
			</c:forEach>
		</table>
		<div class="text-center wrap-md">
		<c:forEach begin="1" end="${totalPages }" var="p">
			<c:choose>
				<c:when test="${i == currentPage }">
					<b class="emphasize">${p }</b>
				</c:when>
				<c:otherwise>
					<a class="no-deco-link" href="${pageContext.servletContext.contextPath }/board/list?p=${p}">${p }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>	
		</div>
		<div class="my-3">
		<a class="no-deco-link" href="${pageContext.servletContext.contextPath }/board/write">
			<button type="button" class="align-right-b b2">글 작성</button>
		</a>
	 	</div>
 	</div>
 	
</body>
</html>