<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>


<link rel="stylesheet" type="text/css" href="mystyle.css">
<style>

body {
    background-color: Cornsilk;
}
h1 {
    color: orange;
}

</style>
<title>SHOPPINGFRONT</title>
</head>
<body>


	<jsp:include page="/WEB-INF/jsp/AdminHead.jsp"></jsp:include>
	
	<div>
		<c:choose>
			<c:when test="${ProductPageClicked}">
				<c:import url="/WEB-INF/jsp/AdminProductPage.jsp"></c:import>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${CategoryPageClicked}">
				<c:import url="/WEB-INF/jsp/AdminCategoryPage.jsp"></c:import>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${SupplierPageClicked}">
				<c:import url="/WEB-INF/jsp/AdminSupplierPage.jsp"></c:import>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>