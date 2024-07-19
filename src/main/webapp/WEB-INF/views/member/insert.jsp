<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
<!-- 		127.0.0.1:8888/member -->
		<link rel="stylesheet" href="../resources/css/main.css">
	</head>
	<body>
		<h1>회원가입 폼</h1>
		<form action="/member/register.kh" method="post">
			<fieldset>
				<legend>회원가입</legend>
				<ul>
					<li>
						<label>아이디 *</label>
						<input type="text" name="memberId">
					</li>
					<li>
						<label>비밀번호 *</label>
						<input type="password" name="memberPw">
					</li>
					<li>
						<label>이름 *</label>
						<input type="text" name="memberName">
					</li>
					<li>
						<label>나이</label>
						<input type="text" name="memberAge">
					</li>
					<li>
						<label>성별</label>
						남<input type="radio" name="memberGender" value="M">
						여<input type="radio" name="memberGender" value="F">
					</li>
					<li>
						<label>이메일</label>
						<input type="text" name="memberEmail">
					</li>
					<li>
						<label>전화번호</label>
						<input type="text" name="memberPhone">
					</li>
					<li>
						<label>주소</label>
						<input type="text" name="memberAddress">
					</li>
				</ul>
			</fieldset>
			<div class="login-area">
			<input type="submit" value="회원가입">
			<button>뒤로가기</button>
			</div>
		</form>
	</body>
</html>