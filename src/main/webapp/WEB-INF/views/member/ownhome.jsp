<%@ page language="java" 
contentType="text/html;charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/member/ownhome.jsp">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/layout/main.css">

</head>

<body>
    <c:forEach var="cookies" items="${pageContext.request.cookies}">
        <c:if test = "${cookies.name == username}">
            <c:set var = "username" scope = "session" value = "${cookies.value}"/>
        </c:if>
        <c:if test = "${cookies.name == sessionID}">
            <c:set var = "sessionID" scope = "request" value = "${cookies.value}"/>
        </c:if>
    </c:forEach>
<h1>Halo <%= session.getAttribute("username") %> from Session</h1>

<h1>Halo ${username} from Session <br/>
    Your sessionID is ${sessionID}
</h1>
</body>

</html>