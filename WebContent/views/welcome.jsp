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
	
	<form action="/SOF3011.1/hello-servlet" method="POST">
		<input type="text" name="username" />
		<input type="password" name="password" />
		
		<button>Submit</button>
	</form>
</body>
</html>
