<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="${ pageContext.request.contextPath }/dang-ky" >
		<div>
			<label>Họ Tên</label>
			<input type="text" name="name" />
		</div>
		<div>
			<label>Email</label>
			<input type="email" name="email" />
		</div>
		<div>
			<label>Password</label>
			<input type="password" name="password" />
		</div>
		<div>
			<label>Giới tính</label>
			<select name="gender">
				<option value="1">Nam</option>
				<option value="0">Nữ</option>
			</select>
		</div>
		<div>
			<div>
				<input type="checkbox" name="hobbies" value="game" /> Chơi game
			</div>
			<div>
				<input type="checkbox" name="hobbies" value="drink" /> Nhậu
			</div>
			<div>
				<input type="checkbox" name="hobbies" value="reading" /> Đọc sách
			</div>
		</div>
		<div>
			<select name="test" multiple>
				<option value="a">AAAAAAAAAAAA</option>
				<option value="b">BBBBBBBBBBBB</option>
				<option value="c">CCCCCCCCCCCC</option>
			</select>
		</div>
		<button>Đăng ký</button>
	</form>

</body>
</html>