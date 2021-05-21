<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello ${ myName }</h1>
	
	<form action="${ pageContext.request.contextPath }/hello-servlet" method="POST">
		<input type="text" name="username" />
		<input type="password" name="password" />
		${ param.username }
		<button>Submit</button>
	</form>
</body>
</html>
