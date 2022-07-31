<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify!</title>
</head>
<body>
<div>
    <a href="/songs/new">Add New</a>
    <a href="/search/topten">Top Songs</a>
    <form action="/search" method="post">
        <input type="text" name="artist">
        <input type="submit" value="Search Artists">
    </form>
</div>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="song" items="${songs}">
        <tr>
            <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="">delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>