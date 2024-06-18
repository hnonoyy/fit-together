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
		<div>
			<h1 class="text-center">핏투게더</h1>
		</div>
	</div>
	<div class="text-right">
		<a href="<%=application.getContextPath() %>/login" 
		class="no-deco-link ">로그인</a> |
		<a href="<%=application.getContextPath() %>/signup" 
		class="no-deco-link ">회원가입</a>

	</div>
	<div>
		<a href="<%=application.getContextPath() %>/events/design" 
		class="no-deco-link ">행사등록</a>
	</div>
	<div>
		<a href="<%=application.getContextPath() %>/events" 
		class="no-deco-link ">행사목록</a>
	</div>
</body>
</html>