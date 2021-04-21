<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
background-image: url("http://localhost:8080/orsproject0/resources/img/LoginImage.jpg");
background-repeat: no-repeat;
background-size: 100%;
}
.row{
padding-top: 90px;
}
.c1{
background-color: transparent;

}
</style>
</head>
<body>


	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">

			<div class="card c1">

				<div class="card-body">
					<h3 class="text-center default-text py-3">
						<strong><s:message code="label.login"></s:message></strong>
					</h3>
					<div>
						<c:if test="${error!=null }">
							<div class="alert alert-danger alert-dismissible">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<div class="message">
									<i class="nc-icon nc-bell-55"></i>${error}
								</div>
							</div>
						</c:if>


						<c:if test="${success!=null }">
							<div class="alert alert-success alert-dismissible">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<div class="message">
									<i class="nc-icon nc-bell-55"></i>${success}
								</div>
							</div>
						</c:if>

					</div>
					<div>


						<sf:form class="register-form" method="POST" modelAttribute="form">

							<sf:hidden path="uri" value="${uri}" />
							<sf:label path="emailId">
							<strong><s:message code="label.emailId"></s:message></strong>
								<span style="color: red;">*</span>

							</sf:label>

							<div class="input-group">

								<div class="input-group-prepend">
									<span class="input-group-text"> <span
										class="fas fa-envelope  grey-text"></span>
									</span>
								</div>
								<sf:input path="emailId" class="form-control"
									placeholder="${enteremail}" />
							</div>

							<font color="red"><sf:errors path="emailId" /></font>
							<br>
							<sf:label path="password">
								<strong><s:message code="label.password" /></strong>
								
								<span style="color: red;">*</span>
							</sf:label>
							<div class="input-group">

								<div class="input-group-prepend">
									<span class="input-group-text"> <span
										class="fa fa-key  grey-text"></span>
									</span>
								</div>
								<sf:input type="password" path="password" class="form-control"
									placeholder="${enterpassword}" />
							</div>

							<font color="red"><sf:errors path="password" /></font>
							<br>
							<br>
							<br>
							<center>

								<button class="btn btn-success" name="operation"
									value="SignIn">
									<s:message code="label.login" />
								</button>
								<button class="btn btn-danger" name="operation"
									value="SignUp">
									<s:message code="label.signup" />
								</button>
								<br>
								<br>
								<br>
								<div class="forgot">
									<button class="btn btn-link btn-warning" name="operation"
										value="ForgotPassword">
										<s:message code="label.forgetpassword" />
									</button>
							</center>
						</sf:form>
					</div>

				</div>

			</div>


		</div>
		<div class="col-md-4"></div>


	</div>

</body>
</html>