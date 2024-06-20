<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <script src="https://kit.fontawesome.com/053f0cac61.js" crossorigin="anonymous"></script>
  </head>
  <body>
  <div class="my-2 p-2 px-5">
  	<div class="d-flex space-between">
	  	<div class="d-flex align-center space-between g-4">
	  		<a class="no-deco-link" href="${pageContext.servletContext.contextPath }/index">
			<i class="fa-solid fa-dumbbell"></i>		  		</a>
	  		<a href="${pageContext.servletContext.contextPath }/events"
	  		class="fs-3 badge-dark no-deco-link">행사목록 <small></small></a>
	  		<a href="${pageContext.servletContext.contextPath }/events"
			class="fs-3 badge-dark no-deco-link">자유게시판 <small></small></a> 
			<a href="${pageContext.servletContext.contextPath }/events"
			class="fs-3 badge-dark no-deco-link">체육시설 <small></small></a>
			<div>
				<form class="fa-search" action="${pageContext.servletContext.contextPath }/search">
					<input class="search-box" type="text" placeholder="검색하세요" name="q"/>
					<i class="fa-solid fa-magnifying-glass icon-search"></i>
				</form>
			</div>
	  	</div>
	  	<div class="d-flex align-center space-bg ">
			<c:choose>
				<c:when test="${sessionScope.authUser == null}">
			  		<a href="<%=application.getContextPath() %>/login" class="no-deco-link ">로그인</a>|
					<a href="<%=application.getContextPath() %>/signup" class="no-deco-link ">회원가입</a>
				</c:when>
				<c:otherwise>
					${sessionScope.authUser.name }(${sessionScope.authUser.id })님이 
					로그인 중입니다. |
					<a class="no-deco-link " href="${pageContext.servletContext.contextPath }/logout">
					<span>로그아웃</span>
			</a>
				</c:otherwise>
			</c:choose>
	  	</div>
  	</div>
  </div>
  </body>
</html>



