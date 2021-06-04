<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/bootstrap.min.css"></link>

</head>
<body>
	<!-- Header -->
	<ul class="nav">
		<c:if test="${ true }">
		    <li class="nav-item">
		        <a class="nav-link active" aria-current="page" href="#">Quản lý User</a>
		    </li>
		    <li class="nav-item">
		        <a class="nav-link" href="#">Quản lý Video</a>
		    </li>
		</c:if>
	</ul>
	<!-- End Header -->
	
	<div class="row">
	    <!-- Sidebar -->
	    <div class="col-2">
	    	Sidebar
	    </div>
	    <!-- End Sidebar -->
	    
	    <!-- Content -->
	    <div class="col-10">
	    	<jsp:include page="${ view }"></jsp:include>
	    </div>
	    <!-- End Content -->
	</div>
	<div class="mt-5">
	    Footer
	</div>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</body>
</html>