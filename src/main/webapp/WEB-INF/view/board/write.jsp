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
			<span class="fw-2 ">자유게시판</span>
			</a>
			 &gt; <span class="warning">글 작성</span>
		</div>
		<div
			style="text-align: left; margin-bottom: 10px; font-size: 0.8rem;">
			<span style="color: red;">*</span> 개인정보를 포함한 내용은 게시할 수 없으며 통보없이 삭제 될 수 있습니다.
		</div>
		<div class="wrap-md my-5">
		<form action="${pageContext.servletContext.contextPath }/board/write-handle">
			<div class="d-flex my-1" style="gap:10px;">
				<span>카테고리</span><br /> <select name="category" >
					<option value="건의사항">건의사항</option>
					<option value="대회정보">대회정보</option>
					<option value="질문">질문</option>
					<option value="운동정보">운동정보</option>
					<option value="기타">기타</option>
				</select>
			</div>
			<div class="my-1">
				<span>제목</span><br />
				 <input name="title" type="text"
						class="w-100  p-2 border-rounded fs-3" />
			</div>
			<div class="my-1">
				<span>내용</span><br />
				<textarea name="body" class="w-100  p-2 border-rounded fs-3"
					style="height: 160px; resize: none"></textarea>
			</div>
			<div style="text-align: center; margin-top: 10px"
				class="no-deco-link">
				<button type="submit" class="align-right-b b2">등록</button>
				<a href="${pageContext.servletContext.contextPath }/board/list">
					<button type="button" class="align-right-b b2">취소</button>
				</a>
			</div>
		</form>
		</div>
	</div>

</body>
</html>