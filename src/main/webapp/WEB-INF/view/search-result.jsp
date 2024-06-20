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
		<h1 class="my-2">검색결과</h1>
		<p><b>${q }</b>에 대한 검색결과입니다.</p>
		<div>
		<ul>
			<c:forEach items="${foundEvents }" var="one">
				<c:url value="/events/${one.id }" var="link" />
				<a class="no-deco-link" href="${link }">
					<li>${one.title }  - ${one.description }</li>
				</a>
			</c:forEach>
		</ul>
		</div>	

	</div>
</body>
</html>