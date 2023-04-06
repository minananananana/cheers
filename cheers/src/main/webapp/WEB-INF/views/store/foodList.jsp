<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../module/header2.jsp"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	Date nowTime = new Date();
SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/eat.css">
<style type="text/css">
.user-wrap {
	overflow: hidden;
	position: relative;
	text-align: left;
}

.user-image img {
	width: 100%;
}

.user-text {
	position: absolute;
	top: 50%;
	left: 50%;
	width: 100%;
	transform: translate(-50%, -50%);
	font-size: 30px;
	text-align: center;
	justify-content: center;
	color: white !important;
	text-shadow: 1px 2px 4px rgb(0, 0, 0);
	text-decoration: none;
}

.user-text:hover {
	text-decoration: none;
}

.sub_title2 {
	height: 200px;
	display: flex;
	align-items: center;
	justify-content: center;
	flex-flow: column;
}

.sub_title3 {
	font-size: 15px;
	text-align: center;
	color: #c8c8c8;
	margin-top: 10px;
}

.sub_title {
	margin-top: 1rem;
}

.emoji {
	font-size: 40px;
}
</style>
</head>
<body>

	<div class="sub_title2">
		<div class="emoji">🍶</div>
		<h2 class="sub_title">사케 맛집 베스트 4곳</h2>
		<div class="sub_title3"><%=sf.format(nowTime)%></div>
	</div>

	<div
		class="container text-center container text-center pt-5 pb-5 food_list">
		<c:forEach var="store" items="${list}">
			<div class="row mb-4 box">
				<div class="col">
					<div class="user-wrap">
						<div class="user-image">
							<a href="storeInfo?s_num=${store.s_num}"> <img
								src="${ctxpath}/resources/imgs/${store.image}" width='200'
								height='200'>
							</a>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="user-wrap">
						<div class="user-image">
							<a href="storeInfo?s_num=${store.s_num}">
								<h3 class="name">${store.s_name}<span class="score">${store.ratingAvg}</span>
								</h3>
								<p class="addr">${store.s_addr}</p>
								<p class="comment">${store.r_content}</p>
							</a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>