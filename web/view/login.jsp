<%@ page import="model.TicketDao" %>
<%@ page import="model.Ticket" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>


<html>
<head>
    <title>Login</title>

    <style>
        <%@include file="../WEB-INF/css/footers.css"%>
    </style>
    <style>
        body {
            background-image: url("../icons/background.png");
        }

    </style>

</head>
<body>
<div id="registration">
    <h3>Cinema</h3>
    <form id="search" method="post" action="/login">

        <input type="text" placeholder="Enter username" name="username" required>
        <label name="username" id="s-user"><b>username</b></label>

        <input type="text" placeholder="Enter Email" name="email" required>
        <label name="email" id="s-email"><b>Email</b></label>

        <input type="password" placeholder="Enter Password" name="psw" required>
        <label name="psw" id="s-pass"><b>Password</b></label>

        <input type="submit" name="Log in" value="Log in">
        <%--<input type="submit" id="sign up" value="sign up">--%>

    </form>
    <form method="post" action="/view/registration.jsp">
        <input type="submit" id="sign up" value="sign up"/>
    </form>
</div>

<table border="1" width="100%">
    <tr>
        <th>Movie name</th>
        <th>Director</th>
        <th>Actors</th>
        <th>Release date</th>
        <th>Duration</th>
        <th>Time</th>
    </tr>

    <c:forEach var="movie" items="${listMovies}">
        <tr>
            <td><c:out value="${movie.movie_name}"/></td>
            <td><c:out value="${movie.movie_director}"/></td>
            <td><c:out value="${movie.movie_actors}"/></td>
            <td><c:out value="${movie.movie_releaseDate}"/></td>
            <td><c:out value="${movie.movie_duration_min}"/></td>
            <td><c:out value="${movie.movie_time}"/></td>
        </tr>
    </c:forEach>
</table>

<form id="loadMovies" method="get" action="/loadMovies">
    <input type="submit" name="loadMovies" value="load Movies"/>
</form>

<form id="loadAttendance" method="get" action="/loadAttendance">
    <input type="submit" name="loadAttendance" value="load Attendance"/>
</form>

<table border="1" width="50%">
    <tr>
        <th>Movie name</th>
        <th>day</th>
        <th>Time</th>
        <th>Seat</th>
    </tr>

    <c:forEach var="ticket" items="${listTickets}">
        <tr>
            <td><c:out value="${ticket.name}"/></td>
            <td><c:out value="${ticket.day}"/></td>
            <td><c:out value="${ticket.time}"/></td>
            <td><c:out value="${ticket.seat}"/></td>
        </tr>
    </c:forEach>
</table>

<%--Try The Grid of seats--%>
<c:forEach var="tkt" items="${listTickets}">
    <c:set var="tikt" value="${tkt}"/>
</c:forEach>
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

<%--Try The Grid of seats--%>
<%@include file="footer.jsp" %>
</body>
</html>

