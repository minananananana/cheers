<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../module/header2.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	  var msg = "${msg}";
		 
		if (msg != "") {
			alert(msg);
		}


</script>
</head>
<body>

                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-2">아이디 찾기</h1>
                                        <p class="mb-4">이메일을 입력해주세요!</p>
                                    </div>
                                    <form class="user" action="${ctxpath}/user/findId" method="POST">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user"
                                                id="u_email" aria-describedby="emailHelp" name="u_email"
                                                placeholder="Enter Email Address...">
                                        </div>
                                        <button type="submit" class="btn btn-primary btn-user btn-block">
                                            Find ID
                                        </button>
                                    </form>
                                    <hr>
                                  
                                    <a href="${ctxpath}/user/login" class="btn btn-facebook btn-user btn-block">
                                           Login
                                        </a>
                                        <hr>
                                       <div class="text-center">
                                        <a class="small" href="/board/list">메인페이지</a>
                                    </div>
</body>
</html>