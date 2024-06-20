<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://kit.fontawesome.com/053f0cac61.js" crossorigin="anonymous"></script>
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
			<%@ include file="/WEB-INF/view/common/nav.jsp"%>
		</div>
		<div>
			<a class="no-deco-link"	href="${pageContext.servletContext.contextPath }/index"> 
			<i class="fa-solid fa-house"></i>
			</a> 
			<span>행사목록</span> &gt; <span class="warning">행사</span>
		</div>
		<div class="wrap-md">
			<div class="align-center d-flex space-center">
				<h2 class="fw-2">${events.title }</h2>
				&nbsp;&nbsp; <span class="hash fw-2">#${events.tag }</span>
			</div>
			<div class="text-center border-rounded2 p-5">
				<span class="fs-5 float-right">등록 날짜 : ${events.registerAt }</span><br />
				<span class="float-left"> 🏟️ (${sportsCenter.owner })${sportsCenter.name }</span><br />
				<span class="float-left">📅 ${events.openAt }</span>
				<c:choose>
					<c:when test="${dday == 1 }">
						<span class="float-left emphasize">(D-day)</span>
					</c:when>
					<c:when test="${dday > 1 }">
						<span class="float-left emphasize">(마감된 행사입니다)</span>
					</c:when>
					<c:otherwise>
						<span class="float-left emphasize">(D${dday-1})</span>
					</c:otherwise>
				</c:choose>
				<p class="p-6 fs-3 space-center">${events.description }</p>
				<p>🙌🏻 ${events.attendee } / ${events.capacity }</p>
			</div>
			<a
				href="${pageContext.servletContext.contextPath }/events/join/${events.id }">
				<button class="align-right-b b2" type="button">참가신청</button>
			</a>
		</div>

		<div class="p-6">
			<h3>참가자[${partSize }] | 전체 댓글</h3>

			<form action="">
				<input class="box-s1" type="text"><br />
				<button class="space-right" type="button">등록</button>
			</form>
			<hr />
		</div>

	</div>
</body>
</html>