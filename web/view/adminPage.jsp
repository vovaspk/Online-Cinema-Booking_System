<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<html>
<head>
    <title>Cinema Admin</title>
    <style>
        <%@include file="../WEB-INF/css/footers.css"%>
    </style>
</head>
<body>
<% if(session.getAttribute("admin")==null){
    response.sendRedirect("/view/login.jsp");
}
%>
<%--MAKE HEADER WITH COLOR -> WELCOME ADMIN              LOG OUT--%>
    <h3>Welcome Admin</h3>



<table border = "1" width = "100%">
    <tr>
        <th>Movie name</th>
        <th>Director</th>
        <th>Actors</th>
        <th>Release date</th>
        <th>Duration</th>
        <th>Time</th>
    </tr>

    <c:forEach var = "movie" items = "${listMovies}">
        <tr>
            <td><c:out value = "${movie.movie_name}"/></td>
            <td><c:out value = "${movie.movie_director}"/></td>
            <td><c:out value = "${movie.movie_actors}"/></td>
            <td><c:out value = "${movie.movie_releaseDate}"/></td>
            <td><c:out value = "${movie.movie_duration_min}"/></td>
            <td><c:out value = "${movie.movie_time}"/></td>
            <td>
                <form method="post" action='<c:url value="/deleteMovie"/>' style="display:inline;">
                    <input type="hidden" name="id" value="${movie.movie_id}">
                    <input type="submit" value="Cancel Movie">
                </form>

            </td>
        </tr>
    </c:forEach>
</table>

<form id="loadMoviesForAdmin" method="get" action="/loadMoviesForAdmin">
    <input type="submit" name="Load Movies" value="Load Movies">
</form>

here I have to see the attendance of the hall
<form id="loadAtt" method="get" action="/loadAttendanceForAdmin">
    <input type="submit" name="loadAttendance" value="load Attendance"/>
</form>
<table class="table">

    <thead>
    <tr>
        <th></th>
        <c:forEach begin="1" end="5" varStatus="loop">
            <th>${loop.index}</th>
        </c:forEach>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <c:forEach begin="1" end="5" varStatus="loop">
            <c:forEach var="tk" items="${listTickets}">

                <c:choose>
                    <c:when test="${tk.seat==loop.index}">
                        <td style="background-color:red;">${loop.index}</td>
                    </c:when>
                    <%--<c:otherwise>--%>
                    <%--<td>${loop.index}</td>--%>
                    <%--</c:otherwise>--%>
                </c:choose>

            </c:forEach>
            <td>${loop.index}</td>
        </c:forEach>
    </tr>
    <tr>
        <td>2</td>
        <c:forEach begin="6" end="10" varStatus="loop">

            <c:forEach var="tk" items="${listTickets}">

                <c:choose>
                    <c:when test="${tk.seat==loop.index}">

                        <td style="background-color:red;">${loop.index}</td>
                    </c:when>
                    <%--<c:otherwise>--%>
                    <%--<td>${loop.index}</td>--%>
                    <%--</c:otherwise>--%>

                </c:choose>
            </c:forEach>

            <td>${loop.index}</td>
        </c:forEach>

    </tr>
    <tr>
        <td>3</td>
        <c:forEach begin="11" end="15" varStatus="loop">
            <c:forEach var="tk" items="${listTickets}">

                <c:choose>

                    <c:when test="${tk.seat==loop.index}">
                        <td style="background-color:red;">${loop.index}</td>
                    </c:when>
                    <%--<c:otherwise>--%>
                    <%--<td>${loop.index}</td>--%>
                    <%--</c:otherwise>--%>

                </c:choose>
            </c:forEach>
            <td>${loop.index}</td>
        </c:forEach>
    </tr>
    <tr>
        <td>4</td>
        <c:forEach begin="16" end="20" varStatus="loop">
            <c:forEach var="tk" items="${listTickets}">

                <c:choose>

                    <c:when test="${tk.seat==loop.index}">
                        <td style="background-color:red;">${loop.index}</td>
                    </c:when>
                    <%--<c:otherwise>--%>
                    <%--<td>${loop.index}</td>--%>
                    <%--</c:otherwise>--%>

                </c:choose>
            </c:forEach>
            <td>${loop.index}</td>
        </c:forEach>
    </tr>
    </tbody>
</table>



<a href="/view/addNewFilm.jsp">Add new Film</a>
<a href="/view/login.jsp">Log Out</a>

<%--<%@include file="footer.jsp" %>--%>
</body>
</html>
