<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="col-10 offset-1">
	<div class="row mt-3">
		<div class="col-6">
			<a class="btn btn-success col-3"
				href="${ pageContext.request.contextPath }/users/create">Create</a>
		</div>
		<div class="col-6"></div>
	</div>
	<table class="table table-dark table-strip mt-3">
		<thead>
			<tr>
				<td>ID</td>
				<td>Họ tên</td>
				<td>Email</td>
				<td>Giới tính</td>
				<td>Ngày sinh</td>
				<td>Tài khoản</td>
				<td>Trạng thái</td>
				<td colspan="2">Thao tác</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ listUser }" var="user">
			<tr>
				<td>${ user.id }</td>
				<td>${ user.name }</td>
				<td>${ user.email }</td>
				<td>${ user.gender == 1 ? "Nam" : "Nữ" }</td>
				<td>${ user.dob }</td>
				<td>${ user.role == 2 ? "Admin" : "User" }</td>
				<td>${ user.status == 1 ? "Đang hoạt động" : "Vô hiệu hóa" }</td>
				<td>
					<a class="btn btn-primary"
						href="${ pageContext.request.contextPath }/users/edit?id=${ user.id }">Update</a>
				</td>
				<td>
					<button class="btn btn-danger">Delete</button>
				</td>
			</tr>
			</c:forEach>
		
		</tbody>
	</table>
</div>
