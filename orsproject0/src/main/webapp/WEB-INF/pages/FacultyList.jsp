<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
<br>
<div class="row">
	<div class="col-lg-12">
		<div class="card card-table c1">
			<h3 class="w-100 text-center under-over-line">
				<s:message code="label.facultylist"></s:message>
			</h3>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
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
				<div class="col-md-4"></div>
			</div>

			<sf:form method="post" modelAttribute="form">
				<c:set value="${((form.pageNo-1)*form.pageSize)+1}" var="index"></c:set>
				<sf:hidden path="pageNo" />
				<sf:hidden path="pageSize" />
				<c:if test="${!empty list}">
					<div class="row p-2 d-flex justify-content-center">
						<div class="col-lg-3">
							<sf:input path="firstName"
								cssClass="form-control border-left-right"
								placeholder="${enterfFirstName}" />
						</div>
						<div class="col-lg-3">
							<sf:input path="lastName"
								cssClass="form-control border-left-right"
								placeholder="${enterLastName}" />
						</div>
						<div class="col-lg-3">
							<sf:input path="emailId" cssClass="form-control border-left-right"
								placeholder="${enteremail}" />
						</div>
						<div class="col-lg-3">
							<div class="row">
								<div class="col-6">
									<button type="submit"
										class="btn btn-info btn-block btn-round w-100"
										name="operation" value="Search">Search</button>
								</div>
								<div class="col-6">
									<button type="submit"
										class="btn btn-warning btn-block btn-round w-100"
										name="operation" value="Reset">Reset</button>
								</div>
							</div>
						</div>
					</div>

					<div class="row d-flex justify-content-center">
						<div class="col-lg-12 table-responsive">
							<table
								class="table table-hover table-striped border border-secondary">
								<thead class="c3">
									<tr>
										<th scope="col" class="text-center text-white"><input
											type="checkbox" id="selectall" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.sno" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.firstName" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.lastName" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.gender" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.emailId" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.mobileNo" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.dob" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.collegeName" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.courseName" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.subjectname" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.edit" /></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="faculty" varStatus="ct">
										<tr>
											<td class="text-center"><input class="case"
												name="chk_1" type="checkbox" value="${faculty.id}">
											</td>
											<td class="text-center"><c:out
													value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" />
												<c:set var="index"
													value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" />
											</td>
											<td class="text-center">${faculty.firstName}</td>
											<td class="text-center">${faculty.lastName}</td>
											<td class="text-center">${faculty.gender}</td>
											<td class="text-center">${faculty.email}</td>
											<td class="text-center">${faculty.mobileNo}</td>
											<td class="text-center"><fmt:formatDate
													value="${faculty.dob}" type="date" pattern="dd-MM-yyyy" /></td>
											<td class="text-center">${faculty.collegeName}</td>
											<td class="text-center">${faculty.courseName}</td>
											<td class="text-center">${faculty.subjectName}</td>
											<td class="text-center"><c:url var="editUrl"
													value="/ctl/Faculty/Faculty?id=" /> <a
												class="btn btn-outline-warning btn-block btn-round w-100"
												href="${editUrl}${faculty.id}"><i class="fa fa-trash"
													aria-hidden="true"></i>
												<s:message code="label.edit" /></a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
					<div class="row d-flex justify-content-center">
						<div class="col-lg-1 col-3">
							<c:choose>
								<c:when test="${form.pageNo > 1}">
									<button type="submit"
										class="btn btn-primary btn-block btn-round w-100"
										name="operation" value="Previous">
									<!-- 	<i class="fa fa-arrow-circle-left" aria-hidden="true"></i> -->
										<s:message code="label.previous"></s:message>
									</button>
								</c:when>
								<c:otherwise>
									<button type="submit"
										class="btn btn-secondary btn-block btn-round w-100"
										name="operation" value="Previous" disabled>
										<!-- <i class="fa fa-arrow-circle-left" aria-hidden="true"></i> -->
										<s:message code="label.previous"></s:message>
									</button>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="col-lg-1 col-3">
							<button type="submit"
								class="btn btn-success btn-block btn-round w-100"
								name="operation" value="New">
								<!-- <i class="fa fa-plus" aria-hidden="true"></i> -->
								<s:message code="label.new"></s:message>
							</button>
						</div>
						<div class="col-lg-1 col-3">
							<button type="submit"
								class="btn btn-danger btn-block btn-round w-100"
								name="operation" value="Delete">
								<!-- <i class="fa fa-trash" aria-hidden="true"></i> -->
								<s:message code="label.delete"></s:message>
							</button>
						</div>
						<div class="col-lg-1 col-3" >
							<c:choose>
								<c:when test="${nextlistsize != 0}">
									<button type="submit"
										class="btn btn-primary btn-block btn-round w-100"
										name="operation" value="Next">
										<!-- <i class="fa fa-arrow-circle-right" aria-hidden="true"></i> -->
										<s:message code="label.next"></s:message>
									</button>
								</c:when>
								<c:otherwise>
									<button type="submit"
										class="btn btn-secondary btn-block btn-round w-100"
										name="operation" value="Next" disabled>
										<!-- <i class="fa fa-arrow-circle-right" aria-hidden="true"></i> -->
										<s:message code="label.next"></s:message>
									</button>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:if>
				<c:if test="${empty list}">
					<div class="row d-flex justify-content-center">
						<div class="col-lg-2 col-6">
							<button type="submit"
								class="btn btn-outline-warning btn-block btn-round w-100"
								name="operation" value="Back">
								<i class="fa fa-reply" aria-hidden="true"></i>
								<s:message code="label.back"></s:message>
							</button>
						</div>
					</div>
				</c:if>
				<style>
.c3 {
	background-color: #36cac3;
}
.card{
background-color: #e4fcffe3;
}
body{background-image: url("http://localhost:8080/orsproject0/resources/img/image6.png")}
</style>

			</sf:form>

		</div>
	</div>
</div>
</body>