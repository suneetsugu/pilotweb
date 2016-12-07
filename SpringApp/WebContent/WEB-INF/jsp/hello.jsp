<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Application</title>
</head>
<body>
    <h1>Hello - Spring Application</h1>
     <p>Greetings, Its ${now} now.</p>
     <h3>Products</h3>
     <c:forEach items="${products}" var="prod">
      <c:out value="${prod.description}"/> <i>&#8377;<c:out value="${prod.price}"/></i><br><br>
     </c:forEach>  
    <br>
    <a href="<c:url value="priceincrease"/>">Increase Prices</a>
    <br>
</body>
</html>