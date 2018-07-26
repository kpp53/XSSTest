<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Employee</title>
</head>
<jsp:include page="menu.jsp" />
<body>
	<h3 style="color: red;">Search Employee</h3>

	<div id="addEmployee">
		<form:form action="/searchEmployees" method="post"
			modelAttribute="emp">
			<p>
				<label>Enter Employee Id</label>
				<form:input path="empId" />
			</p>
			<input type="SUBMIT" value="Submit" />
		</form:form>
		<c:if test="${not empty employees}">
			         <li>${employees}</li>
		</c:if>
		
	</div>
</body>
</html>
