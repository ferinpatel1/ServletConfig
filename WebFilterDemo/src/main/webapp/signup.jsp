<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<style type="text/css">
tr,td{
padding : 10px;
}
</style>
</head>
<body>
<b style="color:red;">
<%
 if(request.getAttribute("msg")!=null){
	 out.println(request.getAttribute("msg"));
 }
%>
</b>
<form method="post" action="Controller">
<table>
<tr>
<td>First Name: </td>
<td><input type="text" name="fname" > </td>
</tr>

<tr>
<td>Last Name: </td>
<td><input type="text" name="lname"></td>

</tr>

<tr>
<td>Email: </td>
<td><input type="text" name="email" > </td>
</tr>

<tr>
<td>Mobile : </td>
<td><input type="text" name="mobile" > </td>
</tr>

<tr>
<td>Password : </td>
<td><input type="password" name="password" > </td>
</tr>

<tr>
<td>Confirm Password : </td>
<td><input type="password" name="cpassword" > </td>
</tr>

<tr cols="3" width="100%" align="center">
<td><input type="submit" name="action" value="signup"></td>
</tr>

</table>
</form>
</body>
</html>