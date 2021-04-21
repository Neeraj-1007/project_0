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
				<s:message code="label.marksheetmeritlist"></s:message>
			</h3>
			
			
			<div style="margin-left: 82%;" >

<a style="font-size: 16px;" href="<c:url value="/ctl/Jasper"/>" class="btn btn-primary " role="button" target = "blank">
<span class="fa fa-print mr-1"></span>Print</a>
</div>

			<sf:form method="post" modelAttribute="form">
				<c:set value="${((form.pageNo-1)*form.pageSize)+1}" var="index"></c:set>
				<sf:hidden path="pageNo" />
				<sf:hidden path="pageSize" />
				<c:if test="${!empty list}">
					

					<div class="row d-flex justify-content-center">
						<div class="col-lg-12 table-responsive">
							<table
								class="table table-hover table-striped border border-secondary">
								<thead class="c3">
									<tr>
										
										<th scope="col" class="text-center"><s:message
												code="label.sno" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.name" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.rollNo" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.physics" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.chemistry" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.maths" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.total" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.percentage" /></th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="marksheet" varStatus="ct">
										<c:set var="percentage">
											<fmt:formatNumber type="number" minFractionDigits="2"
												maxFractionDigits="2"
												value="${(marksheet.physics+marksheet.chemistry+marksheet.maths)/3}" />
										</c:set>

										<tr>
											
											<td class="text-center"><c:out
													value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" />
												<c:set var="index"
													value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" />
											</td>
											<td class="text-center">${marksheet.name}</td>
											<td class="text-center">${marksheet.rollNo}</td>
											<td class="text-center">${marksheet.physics}</td>
											<td class="text-center">${marksheet.chemistry}</td>
											<td class="text-center">${marksheet.maths}</td>
											<td class="text-center">${marksheet.physics+marksheet.chemistry+marksheet.maths}</td>
											<td class="text-center">${percentage}%</td>
											
										</tr>
									</c:forEach>

								</tbody>
							</table>
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
background-color: buttonhighlight;
}
body{
background-image: url("http://localhost:8080/orsproject0/resources/img/image6.png");
}
</style>

			</sf:form>

		</div>
	</div>
</div>
</body>