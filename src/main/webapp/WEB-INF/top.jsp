<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
<div>
    <p>Top Ten Songs:</p>
    <a href="/dashboard">Dashboard</a>
</div>
<div>
    <c:forEach var="song" items="${topTen}">
        <p><c:out value="${song.rating}"/> - <a href="/songs/${song.id}"><c:out value="${song.title}"/></a> - <c:out value="${song.artist}"/></p>
    </c:forEach>
</div>
</body>
</html>