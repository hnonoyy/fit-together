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
			<a href="${pageContext.servletContext.contextPath }/events">
			<span class="fw-2 ">사용가능한 체육시설</span>
			</a>
			 &gt; <span class="warning">체육시설</span>
		</div>
		<div>
			<h2 class="text-center">체육시설</h2>
		</div>
		<table class="text-center wrap-md">
			<tr>
				<th>시설유형</th>
				<th>시설이름</th>
				<th>시설위치</th>
				<th>시설소유</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="one" items="${sportsCenters }">
			  <tr>
			    <td>${one.type }</td>
			    <td>${one.name }</td>
			    <td>${one.district }</td>
			    <td>${one.owner }</td>
			    <td>${one.management }</td>
  			  </tr>
			</c:forEach>
		</table>
		<div class="text-center my-3">
			<c:forEach begin="1" end="${totalPages }" var="i">
			<c:choose>
				<c:when test="${i == currentPage }">
					<b class="emphasize">${i }</b>
				</c:when>
				<c:otherwise>
					<a class="no-deco-link" href="${pageContext.servletContext.contextPath }/sportsCenter?p=${i}">${i }</a>
				</c:otherwise>
			</c:choose>
			</c:forEach>
		</div>

	</div>
</body>
</html>