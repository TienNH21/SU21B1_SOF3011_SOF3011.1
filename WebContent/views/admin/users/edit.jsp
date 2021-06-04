<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-10 offset-1">
	<form method="POST"
		action="${ pageContext.request.contextPath }/users/update?id=${ user.id }">
	  <div class="form-group">
	    <label for="name">Họ tên</label>
	    <input type="text" class="form-control" value="${ user.name }" id="name" name="name">
	  </div>
	  
	  <div class="form-group">
	    <label for="email">Email</label>
	    <input type="email" class="form-control" value="${ user.email }" id="email" name="email">
	  </div>
	  
	  <div class="form-group">
	    <label for="password">Password</label>
	    <input type="password" class="form-control" value="${ user.password }" id="password" name="password">
	  </div>
	  
	  <div class="form-group">
	    <label for="gender">Giới tính</label>
		<select class="form-control" id="gender" name="gender">
	      <option value="1" ${ user.gender == 1 ? "selected" : "" } >Nam</option>
	      <option value="0" ${ user.gender == 0 ? "selected" : "" }>Nữ</option>
	    </select>
	  </div>
	  
	  <div class="form-group">
	    <label for="avatar">Ngày sinh</label>
	    <input type="date" class="form-control" value="${ user.dob }" id="dob" name="dob" />
	  </div>
	  
	  <div class="form-group">
	    <label for="avatar">Avatar</label>
	    <input type="file" class="form-control" id="avatar" name="avatar" />
	  </div>
	  
	  <div class="form-group">
	    <label for="role">Phân quyền</label>
		<select class="form-control" id="role" name="role">
	      <option value="1" ${ user.role == 1 ? "selected" : "" }>Sinh Viên</option>
	      <option value="2" ${ user.role == 0 ? "selected" : "" }>Giảng viên</option>
	    </select>
	  </div>
	  
	  <div class="form-group">
	    <label for="status">Trạng thái</label>
		<select class="form-control" id="status" name="status">
	      <option value="1" ${ user.status == 1 ? "selected" : "" }>Đang hoạt động</option>
	      <option value="2" ${ user.status == 0 ? "selected" : "" }>Vô hiệu hóa</option>
	    </select>
	  </div>
	  
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
