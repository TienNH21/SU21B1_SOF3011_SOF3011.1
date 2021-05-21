<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/bootstrap.min.css"></link>
</head>
<body>

	<div class="col-10 offset-1">
		<form method="POST"
			action="${ pageContext.request.contextPath }/users/store">
		  <div class="form-group">
		    <label for="hoTen">Họ tên</label>
		    <input type="text" class="form-control" id="hoTen" name="hoTen">
		  </div>
		  
		  <div class="form-group">
		    <label for="maSV">Mã SV</label>
		    <input type="text" class="form-control" id="maSV" name="maSV">
		  </div>
		  
		  <div class="form-group">
		    <label for="email">Email</label>
		    <input type="email" class="form-control" id="email" name="email">
		  </div>
		  
		  <div class="form-group">
		    <label for="password">Password</label>
		    <input type="password" class="form-control" id="password" name="password">
		  </div>
		  
		  <div class="form-group">
		    <label for="gioiTinh">Giới tính</label>
			<select class="form-control" id="gioiTinh" name="gioiTinh">
		      <option value="1">Nam</option>
		      <option value="0">Nữ</option>
		    </select>
		  </div>
		  
		  <div class="form-group">
		    <label for="chuyenNganh">Chuyên ngành</label>
			<select class="form-control" id="chuyenNganh" name="chuyenNganh">
		      <option value="1">UDPM</option>
		      <option value="2">TKTW</option>
		      <option value="3">LTMT</option>
		    </select>
		  </div>
		  
		  <div class="form-group">
		    <label for="avatar">Avatar</label>
		    <input type="file" class="form-control" id="avatar" name="avatar" />
		  </div>
		  
		  <div class="form-group">
		    <label for="phanQuyen">Phân quyền</label>
			<select class="form-control" id="phanQuyen" name="role">
		      <option value="1">Sinh Viên</option>
		      <option value="2">Giảng viên</option>
		    </select>
		  </div>
		  
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>