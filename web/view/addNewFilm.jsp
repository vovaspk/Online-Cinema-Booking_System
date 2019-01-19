<%--
  Created by IntelliJ IDEA.
  User: Vova
  Date: 11.01.2019
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Film</title>
</head>
<body>
<% if(session.getAttribute("admin")==null){
    response.sendRedirect("/view/login.jsp");
}
%>
<h1>Add New Film</h1>
<div>
<form action="/addNewFilm" method="post">
    <input type="text"  name="movieName" placeholder="Enter name of the movie">
    <input type="text"  name="movie_director" placeholder="movie_director of the movie">
    <input type="text"  name="movie_actors" placeholder="Actors">
    <input type="datetime-local"  name="movie_releaseDate" placeholder="release date">
    <input type="number"  name="movie_duration" placeholder="movie_duration_min of the movie">
    <input type="text" name="time" placeholder="Enter time to show movie">
    <input type="submit" placeholder="Add new Film">
</form>
</div>
</body>
</html>
