<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
</br>
<div class="row">

	<div class="col-md-3"></div>
	<div class="col-md-5">
		<div class="card c1">
			<div class="card-body c1">
				<h3 class="text-center default-text py-3">
				<c:choose>
				<c:when test="${form.id==0}"><s:message code="label.addcollege" /></c:when>
				<c:otherwise><s:message code="label.updatecollege"></s:message></c:otherwise>
				</c:choose>
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
					<sf:hidden path="id" />
					<sf:hidden path="createdBy" />
					<sf:hidden path="modifiedBy" />
					<sf:hidden path="createdDatetime" />
					<sf:hidden path="modifiedDatetime" />

					<sf:label path="name">
						<s:message code="label.name" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fas fa-university  grey-text"></span>
							</span>
						</div>
						<sf:input path="name" class="form-control"
							placeholder="${enterName}" />
					</div>
					<font color="red"><sf:errors path="name" /></font>
					<br>
					<sf:label path="address">
						<s:message code="label.address" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa fa-address-book grey-text"></span>
							</span>
						</div>
						<sf:input path="address" class="form-control"
							placeholder="${enterAddress}" />
					</div>
					<font color="red"><sf:errors path="address" /></font>
					<br>
					<sf:label path="state">
						<s:message code="label.state" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fas fa-key  grey-text"></span>
							</span>
						</div>
						<sf:input path="state" class="form-control"
							placeholder="${enterState}" />
					</div>
					<font color="red"><sf:errors path="state" /></font>
					<br>
					<sf:label path="city">
						<s:message code="label.city" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fas fa-key  grey-text"></span>
							</span>
						</div>
						<sf:input path="city" class="form-control"
							placeholder="${enterCity}" />
					</div>
					<font color="red"><sf:errors path="city" /></font>
					<br>

					

				

					<sf:label path="phoneNo">
						<s:message code="label.phoneNo" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fas fa-mobile  grey-text"></span>
							</span>
						</div>
						<sf:input path="phoneNo" class="form-control" maxlength="10"
							placeholder="${enterPhoneNo}" />
					</div>
					<font color="red"><sf:errors path="phoneNo" /></font>
					<br>
				
			<div>
			<c:choose>
			<c:when test="${form.id==0}">
			<center>
					<button type="submit" class="btn btn-success"
						name="operation" value="Save">
						<s:message code="label.save" />
					</button>
					<button type="submit" class="btn btn-danger"
						name="operation" value="Reset">
						<s:message code="label.reset" />
					</button>
					</center>
				</c:when>
				<c:otherwise>
					<center>
					<button type="submit" class="btn btn-success"
						name="operation" value="Save">
						<s:message code="label.update" />
					</button>
					<button type="submit" class=" btn btn-warning"
						name="operation" value="Cancel">
						<s:message code="label.cancel" />
					</button>
					</center>
				</c:otherwise>
				</c:choose>
			</div>





			<br> <br>
			<style>
.c1 {
	border-width: 5px;
	border-style: ridge;
	border-radius: 25px;
}
.btn{
padding: 20px;
}
.card{
background-color: #ECEFF1;
}
body{
background-image: url("http://localhost:8080/orsproject0/resources/img/image6.png")
}

</style>
			

			</sf:form>
		</div>
	</div>
</div>
<div class="col-md-4"></div>
</div>
<br>
<br>
