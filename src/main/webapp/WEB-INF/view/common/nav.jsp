<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <script src="https://kit.fontawesome.com/053f0cac61.js" crossorigin="anonymous"></script>
  </head>
  <body>
  	<div>
		<c:choose>
			<c:when test="${sessionScope.authUser == null}">
		  		<a class="no-deco-link" href="${pageContext.servletContext.contextPath }/index">
			  	<i class="fa-solid fa-house"></i>
		  		</a>
				로그인하세요
			</c:when>
			<c:otherwise>
				<a class="no-deco-link" href="${pageContext.servletContext.contextPath }/index">
			  	<i class="fa-solid fa-house"></i>
		  		</a>
				${sessionScope.authUser.name }(${sessionScope.authUser.id })님이 
				로그인 중입니다.
			</c:otherwise>
		</c:choose>
  	</div>
  </body>
</html>



