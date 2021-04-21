<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
</br>
<div class="row">

	<div class="col-md-4"></div>
	<div class="col-md-4">
		<div class="card c1">
			<div class="card-body c1">
				<h3 class="text-center default-text py-3">
				<c:choose>
				<c:when test="${form.id==0}"><s:message code="label.adduser" /></c:when>
				<c:otherwise><s:message code="label.updateuser"></s:message></c:otherwise>
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

					<sf:label path="firstName">
						<s:message code="label.firstName" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa fa-user  grey-text"></span>
							</span>
						</div>
						<sf:input path="firstName" class="form-control"
							placeholder="${enterfirstName}" />
					</div>
					<font color="red"><sf:errors path="firstName" /></font>
					<br>

					<sf:label path="lastName">
						<s:message code="label.lastName" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa fa-calendar  grey-text"></span>
							</span>
						</div>
						<sf:input path="lastName" class="form-control"
							placeholder="${enterLastName}" />
					</div>
					<font color="red"><sf:errors path="lastName" /></font>
					<br>

					<sf:label path="gender">
						<s:message code="label.gender" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa fa-venus-mars grey-text"></span>
							</span>
						</div>
						<sf:select path="gender" class="form-control">
							<sf:option value="">
								<s:message code="label.selectgender"></s:message>
							</sf:option>
							<sf:options items="${genderList}" />
						</sf:select>
					</div>
					<font color="red"><sf:errors path="gender" /></font>
					<br>

					<sf:label path="dob">
						<s:message code="label.dob" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa fa-calendar  grey-text"></span>
							</span>
						</div>
						<sf:input readonly="readonly" path="dob" class="form-control"
							placeholder="${enterdob}" id="datepicker" />
					</div>
					<font color="red"><sf:errors path="dob" /></font>
					<br>

					<sf:label path="mobileNo">
						<s:message code="label.mobileNo" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa  fa-phone-square grey-text"></span>
							</span>
						</div>
						<sf:input path="mobileNo" class="form-control" maxlength="10"
							placeholder="${enterMobile}" />
					</div>

					<font color="red"><sf:errors path="mobileNo" /></font>
					<br>

					<sf:label path="login">
						<s:message code="label.email" />
						<s:message code="label.id" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa fa-calendar  grey-text"></span>
							</span>
						</div>
						<sf:input path="login" class="form-control"
							placeholder="${enteremail}" />
					</div>

					<font color="red"><sf:errors path="login" /></font>
					<br>

					<sf:label path="password">
						<s:message code="label.password" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa fa-lock  grey-text"></span>
							</span>
						</div>
						<sf:input type="password" path="password" class="form-control"
							placeholder="${enterpassword}" />
					</div>

					<font color="red"><sf:errors path="password" /></font>
					<br>


					<sf:label path="confirmPassword">
						<s:message code="label.confirmPassword" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa fa-key  grey-text"></span>
							</span>
						</div>
						<sf:input type="password" path="confirmPassword"
							class="form-control" placeholder="${enterconPassword}" />
					</div>

					<font color="red"><sf:errors path="confirmPassword" /> <c:if
							test="${conPwdMatch!=null }">
							<font color="red">${conPwdMatch}</font>
						</c:if> </font>
					<br>
					
					
					<sf:label path="roleId">
						<s:message code="label.role" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <span
							class="fa fa-book  grey-text"></span>
						</span>
					</div>
					<sf:select path="roleId" class="form-control">
						<sf:option value="0" label="${enterRoleName}" />
						<sf:options items="${roleList}" itemValue="id" itemLabel="roleName"/>
					</sf:select>
			</div>
			<font color="red"><sf:errors path="roleId" /></font> <br>
					
					
					<br>
					<div class=" text-center">
             <c:choose>
              		<c:when test="${form.id==0}"> 
						<button type="submit" class="btn btn-primary " name="operation" value="save"><s:message code="label.save"/></button>
						<button type="submit" class="btn btn-danger" name="operation" value="reset"><s:message code="label.reset"/></button>
						</c:when>
						<c:otherwise>
							<button type="submit" class="btn btn-success " name="operation" value="save"><s:message code="label.update"/></button>
							<button type="submit" class="btn btn-warning " name="operation" value="cancel"><s:message code="label.cancel"/></button>
						</c:otherwise>
				</c:choose>
              </div>





					<br>
					<br>
					<style>
					.btn{
					padding: 18px;
					}
					
					


i.css {
	border-radius: 6px 0px 0px 6px;
	border: 1px solid #ced4da;
	padding-left: 15px;
	padding-bottom: 18px;
	background-color: #e9ecef;;
}
.card{
background-color: #ECEFF1;
}
body{background-image: url("http://localhost:8080/orsproject0/resources/img/image6.png")

}
</style>
					<script type="text/javascript">
						$(function() {
							$("#datepicker").datepicker({
								changeMonth : true,
								changeYear : true,
								yearRange : '1970:2030',
								dateFormat : 'dd/mm/yy',
								endDate : '-18y'
							});
						});
					</script>

				</sf:form>
			</div>
		</div>
	</div>
	<div class="col-md-4"></div>
</div>
<br>
<br>
</body>















<%-- 
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
<title>User</title>
<link href='<c:url value = "http://localhost:8080/ProjectORS0/resources/css/style.css"></c:url>' rel="stylesheet" />
<style type="text/css">
body{
background-image: url("http://localhost:8080/orsproject0/resources/img/image6.png");
}
.card{
background-color: transparent;}

</style>

<script type="text/javascript">
				$(function() {
					$("#datepicker").datepicker({
						changeMonth : true,
						changeYear : true,
						yearRange : '1970:2030',
						dateFormat : 'dd/mm/yy',
						endDate : '-18y'
					});
				});
				
			</script>

</head>


 
<body>
  <div class="container-fluid">
   <div class="container mt-5" style="padding-top: 7%" >
      <div class="row">
        <div class="col-lg-4 col-md-6 col-sm-6 mx-auto">
          <div class="card card-login">
            <sf:form modelAttribute="form" method="post">
              <div class="card-header card-header-primary text-center">
                <h4 class="card-title"><c:choose><c:when test="${form.id==0}"><s:message code="label.adduser" /></c:when>
           			<c:otherwise><s:message code="label.updateuser"></s:message></c:otherwise>
           		</c:choose></h4>
                <div class="social-line">
                </div>
              </div>
               
               <c:if test="${success != null}">
              <div class="alert alert-success">
                <div class="container">
                  <div class="alert-icon">
                    <i class="material-icons">check</i>
                  </div>
                  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true"><i class="material-icons">clear</i></span>
                  </button>
                  <b>Success :</b> ${success}
                </div>
              </div>
              </c:if>
              
              <c:if test="${error != null}">
              <div class="alert alert-danger">
                <div class="container">
                  <div class="alert-icon">
                    <i class="material-icons">check</i>
                  </div>
                  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true"><i class="material-icons">clear</i></span>
                  </button>
                  <b>Warning:</b> ${error}
                </div>
              </div>
              </c:if>
              
              <sf:hidden path="id" />
				<sf:hidden path="createdBy" />
				<sf:hidden path="modifiedBy" />
				<sf:hidden path="createdDatetime" />
				<sf:hidden path="modifiedDatetime" />
              
              <div class="card-body">
               
                <span class="bmd-form-group">
                  <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="fa fa-user" aria-hidden="true"></i>
                    </span>
                  </div>
                  <sf:input  path="firstName"  class="form-control" placeholder="${enterfirstName}"/>
                  
                  
                </div>
                <div style="padding-left: 50px;">
                  <font  style=" color: red;"> <sf:errors path="firstName"></sf:errors> </font>
                </div>
              </span>

                <span class="bmd-form-group">
                  <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="fa fa-user" aria-hidden="true"></i>
                    </span>
                  </div>
                 <sf:input  path="lastName"  class="form-control" placeholder="${enterLastName}"/>
                  
                </div>
                <div style="padding-left: 50px;">
                  <font  style=" color: red;"><sf:errors path="lastName"></sf:errors></font>
                </div>
              </span>
                
                <span class="bmd-form-group">
                  <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="fa fa-sign-in"></i>
                    </span>
                  </div>
                   <sf:input  path="login"  class="form-control" placeholder="${enteremail}"/>
                 
                </div>
                <div style="padding-left: 50px;">
                  <font  style=" color: red;"><sf:errors path="login"></sf:errors></font>
                </div>
              </span>

            

                <span class="bmd-form-group">
                  <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class=" fa fa-lock" aria-hidden="true"></i>
                    </span>
                  </div>
                  <sf:input  path="password" type="password" class="form-control" placeholder="${enterpassword}"/>
                 
                </div>
                <div style="padding-left: 50px;">
                  <font  style=" color: red;"><sf:errors path="password"></sf:errors></font>
                </div>
              </span>
                  
                <span class="bmd-form-group">
                  <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class=" fa fa-lock" aria-hidden="true"></i>
                    </span>
                  </div>
                  <sf:input  path="confirmPassword" type="password" class="form-control" placeholder="${enterconPassword}"/>
                  
                </div>
                <div style="padding-left: 50px;">
                  <font  style=" color: red;"><sf:errors path="confirmPassword"></sf:errors></font>
                </div>
              </span>
              
                      <span class="bmd-form-group">
                  <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="fa fa-align-justify"></i>
                    </span>
                  </div>
                   <sf:select path="roleId" class="form-control">
					<sf:option value="0" label="${enterRoleName}" />
					<sf:options items="${roleList}" itemValue="id" itemLabel="roleName"/>
				</sf:select> 
                 
                </div>
                <div style="padding-left: 50px;">
                  <font  style=" color: red;"><sf:errors path="roleId"></sf:errors></font>
                </div>
              </span>
            
              <span class="bmd-form-group">
                <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fa fa-mobile" aria-hidden="true"></i>
                  </span>
                </div>
               <sf:input  path="mobileNo"  class="form-control" placeholder="${enterMobile}"/>
                
              </div>
              <div style="padding-left: 50px;">
                <font  style=" color: red;"><sf:errors path="mobileNo"></sf:errors></font>
              </div>
            </span>
             
             

           <sf:label path="dob">
				<s:message code="label.dob" />
				<span style="color: red;">*</span>
			</sf:label>
			<div class="input-group">

				<div class="input-group-prepend">
					<span class="input-group-text"> <span
						class="fa fa-calendar  grey-text"></span>
					</span>
				</div>
				<sf:input readonly="readonly" path="dob" class="form-control"
					placeholder="${enterdob}" id="datepicker" />
			</div>
			<font color="red"><sf:errors path="dob" /></font> <br>
			
			
              <span class="bmd-form-group">
                <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fa fa-mercury" aria-hidden="true"></i>
                  </span>
                </div>
              	<sf:select path="gender" class="form-control">
					<sf:option value="">
						<s:message code="label.selectgender"></s:message>
					</sf:option>
					<sf:options items="${genderList}" />
				</sf:select>
                
              </div>
              <div style="padding-left: 50px;">
                <font  style=" color: red;"><sf:errors path="gender"></sf:errors></font>
              </div>
            </span>

              </div>

              <br>
              
              
              
              
              
              <div class=" text-center">
             <c:choose>
              		<c:when test="${form.id==0}"> 
						<button type="submit" class="btn btn-primary " name="operation" value="save"><s:message code="label.save"/></button>
						<button type="submit" class="btn btn-danger" name="operation" value="reset"><s:message code="label.reset"/></button>
						</c:when>
						<c:otherwise>
							<button type="submit" class="btn btn-success " name="operation" value="save"><s:message code="label.update"/></button>
							<button type="submit" class="btn btn-warning " name="operation" value="cancel"><s:message code="label.cancel"/></button>
						</c:otherwise>
				</c:choose>
              </div>
             
           </sf:form>
          </div>
        </div>
      </div>
    </div>
 <br>
 <br>
</div>
</body>
</html> --%>