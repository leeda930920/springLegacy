<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	.error{
	  color:red; font-size:20%;
	}
</style>
</head>
<body>
  <h2>input_data.jsp</h2>
  <form:form action="input_procedure" modelAttribute="testBean1" method="post">
    
    data1 : <form:input path="data1" /><br>
            <form:errors  class="error"  path="data1" /><br>
    data2 : <form:input path="data2" /><br>
            <form:errors  class="error"  path="data2" /><br>
    data3 : <form:input path="data3" /><br>
            <form:errors  class="error"  path="data3" /><br>        
    <form:button type="submit">전 송</form:button>
  </form:form>
</body>
</html>







