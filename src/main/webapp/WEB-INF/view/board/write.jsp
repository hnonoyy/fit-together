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
		<form action="${pageContext.servletContext.contextPath }/board/write-handle">
			<table style="border-collapse: collapse; width: 100%; color: #444;">
				<tr >
					<td class="write-td1" style="border-top-color: gray;">작성자</td>
					<td class="tb2" style="border-top-color: gray; text-indent: 10px"></td>
				</tr>
				<tr>
					<td class="write-td1">제목</td>
					<td class="tb2">
						<input class="write-td2" type="text" name="title" placeholder="제목을 입력해주세요" />
					</td>
				</tr>
				<tr>
					<td class="tb2" style="padding: 12px;" colspan="2">
					<textarea name="body" class="text-td" placeholder="내용을 입력해주세요"></textarea>
					</td>
				</tr>
				
			</table>
			<div style="text-align: center; margin-top: 10px"
				class="no-deco-link">
				<button type="submit" class="align-right-b b2">저장</button>
				<a href="${pageContext.servletContext.contextPath }/board/list">
					<button type="button" class="bt bt2">취소</button>
				</a>
			</div>
		</form>
	</div>

</body>
</html>