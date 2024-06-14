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
		<div class="wrap-sm">
			<h2>핏투게더 계정 만들기</h2>
			<p class="fs-4">함께 건강하고 활동적인 생활을 시작해보세요! 지금 바로 가입하고, 당신에게 맞는 스포츠 활동을 찾아보세요.</p>
			<c:if test="${param.error != null }">
				<div>
				회원가입에 실패하였습니다. 다시 시도해주세요
				</div>
			</c:if>
			<form 
				action="${pageContext.servletContext.contextPath }/signup-handle"
				method="post"
			>
				<div>
					<label class="fs-3">계정아이디(*)</label>
					<div class="my-1">
						<input type="text" placeholder="아이디" class="w-100 p-1 fs-4" name="id"/>
					</div>
				</div>
				<div>
					<label class="fs-3">계정 비밀번호(*)</label>
					<div class="my-1">
						<input type="password" placeholder="비밀번호" class="w-100 p-1 fs-4" name="password" />
					</div>
				</div>
				<div>
					<label class="fs-3">사용자 이름(*)</label>
					<div class="my-1">
						<input type="text" placeholder="사용자 이름" class="w-100 p-1 fs-4"  name="name"/>
					</div>
				</div>
				<div>
					<label class="fs-3">e-mail(*)</label>
					<div class="my-1">
						<input type="text" placeholder="E-mail" class="w-100 p-1 fs-4"  name="email"/>
					</div>
				</div>
				<div>
					<label class="fs-3">탄생년도(*)</label>
					<div class="my-1">
						<select class="w-100 p-1 fs-4" name="birth">
							<option disabled selected>탄생년도</option>
							<c:forEach var="i" begin="0" end="60">
								<option>${2010-i }</option>
							</c:forEach>
						</select>

					</div>
				</div>
				<div>
					<label class="fs-3">성별(*)</label>
					<div class="my-1">
						<select class="w-100 p-1 fs-4" name="gender">
							<option disabled selected>성별</option>
							<option value="남">남</option>
							<option value="여">여</option>
						</select>
					</div>
				</div>
				<div>
					<label class="fs-3">관심운동</label>
					<div class="my-1 d-flex space-between">
						<input type="checkbox" name="interest" value="축구" id="soc" /><label for="soc">축구</label>
						<input type="checkbox" name="interest" value="수영" id="swm" /><label for="swm">수영</label>
						<input type="checkbox" name="interest" value="테니스" id="ten" /><label for="ten">테니스</label>
						<input type="checkbox" name="interest" value="농구" id="bsk" /><label for="bsk">농구</label>
						<input type="checkbox" name="interest" value="피트니스" id="fit" /><label for="fit">피트니스</label>
						<input type="checkbox" name="interest" value="육상" id="run" /><label for="run">육상</label>
						<input type="checkbox" name="interest" value="골프" id="glf" /><label for="glf">골프</label>
						<input type="checkbox" name="interest" value="기타" id="etc" /><label for="etc">기타</label>
					</div>
				</div>
				<div class="my-5">
					<button type="submit" class="w-100 fs-3 p-2">회원가입신청</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>