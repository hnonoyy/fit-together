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
		<h1 class="my-2">등록된 체육행사 목록</h1>

		<div style="display: flex; flex-wrap: wrap;">
			<c:forEach items="${events }" var="one">
				<div style="width: 50%; padding: 4px;">
					<div class="border-rounded p-3 item" style="height: 150px;">
						<div style="display: flex; justify-content: space-between;">
							<span class="hash"># ${one.event.tag }</span> 
							<span class="badge-info">
								${one.event.attendee } / ${one.event.capacity }</span>
						</div>
						<div>
							<c:url value="/events/${one.event.id }" var="link" />
							<h2 class="my-2">
								<a class="no-deco-link" href="${link }">${one.event.title }</a>
							</h2>
						</div>
						<hr/>
						<div class="d-flex space-right2">
							<c:if test="${one.joined }">
								<span class="badge-info emphasize">참여중</span>
							</c:if>
							<span class="badge-dark">${one.event.openAt }</span>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>
</body>
</html>