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
		<div>
			<span>체육행사등록</span> &gt; <span class="warning">행사 세부 정보 입력</span>
		</div>
		<h2 class="my-2">계속하기: 행사 세부 정보 입력</h2>
		<p class="fs-3">행사의 세부 정보를 입력해 주세요. 필요한 정보로는 행사의 제목, 날짜, 최대 참가 인원
			수, 그리고 행사에 대한 간략한 설명이 포함됩니다. 이 정보들은 참가자들이 행사를 이해하고, 필요한 준비를 할 수 있도록
			도움을 줄 것입니다. 간단하게 몇 가지 정보만 입력하면, 행사 등록이 완료됩니다!</p>
		<p class="">※ 행사의 주제나 내용을 잘 나타낼 수 있는 태그를 설정하면 참가자들에게 효과적으로 알릴 수
			있습니다.</p>
		<form
			action="${pageContext.servletContext.contextPath }/events/new-handle" method="post">
			<div class="d-flex my-1" style="gap:10px;">
				<div>
					<small>태그</small><br /> <select name="tag" class=" p-2 border-rounded fs-3 text-center">
						<option value="축구">축구</option>
						<option value="수영">수영</option>
						<option value="테니스">테니스</option>
						<option value="농구">농구</option>
						<option value="피트니스">피트니스</option>
						<option value="육상">육상</option>
						<option value="골프">골프</option>
						<option value="기타">기타</option>
					</select>
				</div>
				<div >
					<small>행사개최일</small><br /> <input type="date" name="openAt"
						class="  p-2 border-rounded fs-3" />
				</div>
				
				<div>
					<small>최대참가인원</small><br /> <input name="capacity" type="number"
						class="  p-2 border-rounded fs-3 text-right" />
				</div>
			
			</div>
			<div class="my-1">
				<small>행사제목</small><br />
				 <input name="title" type="text"
						class="w-100  p-2 border-rounded fs-3" />
			</div>
			<div class="my-1">
				<small>개최장소</small><br /> <select name="sportsCenterId"
					class="w-100 p-2 border-rounded fs-3">
					<option selected disabled>체육관(${param.type })을 선택해주세요.</option>
					<c:forEach var="one" items="${sportsCenter }">
						<option value="${one.id }">${one.name }</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="my-1">
				<small>행사설명</small><br />
				<textarea name="description" class="w-100  p-2 border-rounded fs-3"
					style="height: 160px; resize: none"></textarea>
			</div>

			
			<div class="my-1">
				<button class="w-100 p-2 border-rounded fs-2" >행사 등록</button>
			</div>
		</form>

	</div>
</body>
</html>