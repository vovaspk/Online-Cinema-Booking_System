<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<head>
    <title>Home</title>
    <style>
        <%@include file="../WEB-INF/css/footers.css"%>
    </style>
</head>
<body>
<div id="topDiv">
    <h1>Hello User</h1>
</div>
<div id="movTabl">
    <h2>Movies</h2>
    <% if (session.getAttribute("user") == null) {
        response.sendRedirect("/view/login.jsp");
    }%>


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
</div>
<div id="buyTick">
    <h1>Buy tickets</h1>
    <div class="custom-select" style="width:320px" ;>
        <form action="/buyTicket" method="post">
            <select name="movie_name">
                <c:forEach var="movie" items="${listMovies}">
                    <option><c:out value="${movie.movie_name}"/></option>
                </c:forEach>
            </select>
            <c:out value="Select Movie"/>
            <select name="day_of_movie">
                <option>Monday</option>
                <option>Tuesday</option>
                <option>Wednesday</option>
                <option>Thursday</option>
                <option>Friday</option>
                <option>Saturday</option>
                <option>Sunday</option>
            </select>
            <c:out value="Select Day"/>
            <select name="time">
                <option>9:00</option>
                <option>11:00</option>
                <option>13:00</option>
                <option>15:00</option>
                <option>17:00</option>
                <option>19:00</option>
                <option>21:00</option>
                <option>23:00</option>
            </select>
            <c:out value="Select Time"/>
            <select name="seat">
                <c:forEach var="i" begin="1" end="20">
                    <option><c:out value="${i}"/></option>
                </c:forEach>
            </select>
            <c:out value="Select Seat"/>


            <input type="submit" value="buy">
        </form>
    </div>
</div>
<div id="attendance">
    <h3>Your Tickets</h3>
    <table border="1"width="25%">
        <tr>
            <th>Movie</th>
            <th>Day</th>
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



    <c:out value="Home"/>

    <%--<<a href="/view/login.jsp">Log out</a>--%>
    <form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout"/>
    </form>
</div>
<%--<c:set var="un" value="${param.username}"/>--%>
<%--<c:out value="${param.username}"/>--%>
<%@include file="footer.jsp" %>
</body>
</html>
