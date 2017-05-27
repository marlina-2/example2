<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ann
  Date: 14.05.17
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>categories</title>
</head>
<body>
<c:forEach var = "category" items = "${categories}">
    <a href="<c:out value ="/category"/>"><h2><c:out value = "${category.name}"/></h2></a>
</c:forEach>

</body>
</html>
