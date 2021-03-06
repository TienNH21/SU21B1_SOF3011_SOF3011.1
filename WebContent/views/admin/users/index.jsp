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
	<table class="table table-strip mt-3">
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
					<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete_confirm_${ user.id }">Delete</button>
					<div class="modal fade" id="delete_confirm_${ user.id }" tabindex="-1" role="dialog" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">Delete Confirm</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        Xác nhận xóa người dùng ${ user.name } ?
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
					        <form method="POST" action="${ pageContext.request.contextPath }/users/delete" >
					        	<input type="hidden" name="id" value="${ user.id }"/>
					        	<button type="submit" class="btn btn-danger">Xóa</button>
					        </form>
					      </div>
					    </div>
					  </div>
					</div>
				</td>
			</tr>
			</c:forEach>
		
		</tbody>
	</table>
</div>
