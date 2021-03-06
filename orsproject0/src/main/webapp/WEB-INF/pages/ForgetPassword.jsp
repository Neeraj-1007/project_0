<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
<br>
<br>
<div class="row">

	<div class="col-md-4"></div>
	<div class="col-md-4">
		<div class="card c1 ">
			<div class="card-body c1">

				<h3 class="text-center default-text py-3">
					<s:message code="label.pass" />
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


				<sf:form method="post" modelAttribute="form">

					<sf:label path="login">
						<s:message code="label.email" />
						<s:message code="label.id" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fas fa-envelope grey-text"></span>
							</span>
						</div>
						<sf:input path="login" class="form-control"
							placeholder="${enteremail}" />
					</div>
					<font color="red"><sf:errors path="login" /></font>
					<br>
					<br>
					<br>



					<center>
						<button class="btn btn-success" name="operation"
							value="Go">
							<s:message code="label.go" />
						</button>
						<button class=" btn btn-danger" name="operation"
							value="Cancel">
							<s:message code="label.cancel" />
						</button>
					</center>
					<style>
body{
background-image: url("http://localhost:8080/orsproject0/resources/img/LoginImage.jpg");
background-size: 100%;

}

.btn {
	padding: 20px;
}

.card {
	background-color: transparent;
	padding-top:120px;
}
</style>
				</sf:form>
			</div>

			<div class="col-md-4"></div>
		</div>
	</div>
</div>
</body>
