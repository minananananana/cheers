<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<title>Insert title here</title>
</head>
<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='writeForm']");
			$(".write_btn").on("click", function(){
				if(fn_valiChk()){
					return false;
				}
				formObj.attr("action", "writePro");
				formObj.attr("method", "post");
				formObj.submit();
			});
		})
		function fn_valiChk(){
			var regForm = $("form[name='writeForm'] .chk").length;
			for(var i = 0; i<regForm; i++){
				if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
					alert($(".chk").eq(i).attr("title"));
					return true;
				}
			}
		}
	</script>

<body>
	<div id="root">
		<header>
			<h1>게시판</h1>
		</header>
		<hr />

		<div>
			<%@include file="nav.jsp"%>
		</div>
		<hr />
		<section id="container">
			<form name="writeForm" method="post" action="writePro">
				<table>
					<tbody>
						<tr>
							<td><label for="title">제목</label><input type="text"
								id="b_title" name="b_title" class="chk" title="제목을 입력하세요." /></td>
						</tr>
						<tr>
							<td><label for="content">내용</label> <textarea id="b_content"
									name="b_content" class="chk" title="내용을 입력하세요."></textarea></td>
						</tr>
						<tr>
							<td><label for="writer">작성자</label><input type="text"
								id="b_writer" name="b_writer" class="chk" title="작성자를 입력하세요." /></td>
						<tr>
							<td>
								<button class="write_btn" type="submit">작성</button>
							</td>
						</tr>
					</tbody>
				</table>
			</form>

		</section>
		<hr />
	</div>
</body>
</html>